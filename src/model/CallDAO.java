package model;

import dao.JankenDAO;
import dao.UserDAO;

public class CallDAO {

	public boolean callJankenInsert(int myHand, int cpuHand, int userId) {
		JankenDAO jankenDAO = new JankenDAO();
		return jankenDAO.Insert(myHand, cpuHand, userId);
	}

	public int[] callJankenExist(int userId) {
		JankenDAO jankenDAO = new JankenDAO();
		return jankenDAO.exist(userId);
	}

	public boolean callUserInsert(String name, String passCode) {
		UserDAO userDAO = new UserDAO();
		return userDAO.insert(name, passCode);
	}

	public boolean callUserExist(String name, String passCode) {
		UserDAO userDAO = new UserDAO();
		return userDAO.exist(name, passCode);

	}

	public int callUserFindAll(String name) {
		UserDAO userDAO = new UserDAO();
		return userDAO.findBy(name);
	}

}
