package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CallDAO;
import model.PasswordUtil;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
			request.setAttribute("isNull", "未入力の項目があります");
			request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
		} else {
			PasswordUtil password = new PasswordUtil();
			String passCode = password.toPassCode(pass);

			CallDAO callDAO = new CallDAO();

			if (callDAO.callUserInsert(name, passCode)) {
				request.getRequestDispatcher("/WEB-INF/jsp/registerDone.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "既にニックネームが使われています");
				request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(request, response);
			}
		}
	}
}
