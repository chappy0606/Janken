package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Janken;
import model.JankenJudgeLogic;

@WebServlet("/JankenController")
public class JankenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Janken.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int myHand = Integer.parseInt(request.getParameter("hand"));
		int cpuHand = getCpuHand();

		Janken janken = new Janken(myHand, cpuHand);

		JankenJudgeLogic jankenJudgeLogic = new JankenJudgeLogic();
		janken.setResult(jankenJudgeLogic.battle(myHand, cpuHand));

		request.setAttribute("janken", janken);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/JankenJudgeResult.jsp");
		dispatcher.forward(request, response);
	}

	private int getCpuHand() {
		double ransu = Math.random();
		int cpuHand = (int) (ransu * 3);
		return cpuHand;
	}
}
