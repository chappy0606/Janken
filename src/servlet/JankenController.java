package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CallDAO;
import model.Janken;
import model.JankenJudgeLogic;
import model.User;

@WebServlet("/JankenController")
public class JankenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/Janken.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		int myHand = Integer.parseInt(request.getParameter("hand"));
		int cpuHand = getCpuHand();

		Janken janken = new Janken(myHand, cpuHand);

		CallDAO callDAO = new CallDAO();
		callDAO.callJankenInsert(myHand, cpuHand, loginUser.getId());
		
		session.setAttribute("counter", callDAO.callJankenExist(loginUser.getId()));

		JankenJudgeLogic jankenJudgeLogic = new JankenJudgeLogic();
		janken.setResult(jankenJudgeLogic.battle(myHand, cpuHand));

		session.setAttribute("janken", janken);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/JankenJudgeResult.jsp");
		dispatcher.forward(request, response);
	}

	private int getCpuHand() {
		double ransu = Math.random();
		int cpuHand = (int) (ransu * 3);
		return cpuHand;
	}
}
