package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.JankenJudgeLogic;

public class JankenDAO {

	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file:C:/users/chapp/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	Connection conn = null;

	public int[] exist(int userId) {
		int winCount = 0;
		int loseCount = 0;
		int drawCount = 0;

		try {
			Class.forName(DRIVER_NAME);

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "select jankens.myhand, jankens.cpuhand from users inner join jankens on users.id = jankens.userid where users.id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int myHand = rs.getInt("myhand");
				int cpuHand = rs.getInt("cpuhand");
				JankenJudgeLogic jankenJudgeLogic = new JankenJudgeLogic();
				switch (jankenJudgeLogic.battle(myHand, cpuHand)) {
				case 0:
					winCount++;
					break;
				case 1:
					loseCount++;
					break;
				case 2:
					drawCount++;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		int countStr[] = { winCount, loseCount, drawCount };
		return countStr;
	}

	public boolean Insert(int myHand, int cpuHand, int userId) {
		try {
			Class.forName(DRIVER_NAME);

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO JANKENS(myhand, cpuhand, userid) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, myHand);
			pStmt.setInt(2, cpuHand);
			pStmt.setInt(3, userId);

			int r = pStmt.executeUpdate();

			return (r > 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
}
