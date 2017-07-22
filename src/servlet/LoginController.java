package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CallDAO;
import model.PasswordUtil;
import model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	Connection conn = null;
	PreparedStatement ps = null;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		PasswordUtil password = new PasswordUtil();
		String passCode = password.toPassCode(pass);

		CallDAO callDAO = new CallDAO();
		boolean isExisted = callDAO.callUserExist(name, passCode);

		if (isExisted) {
			int autoIncrementId = callDAO.callUserFindAll(name);

			User user = new User(autoIncrementId, name, passCode);

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

			response.sendRedirect("/Kadai/JankenController");
		} else {
			request.setAttribute("error", "ユーザー名かパスワードが間違っています");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(
					request, response);
		}
	}
}
