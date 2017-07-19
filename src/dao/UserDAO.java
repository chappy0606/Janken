package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file:C:/users/chapp/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	Connection conn = null;

	public boolean exist(String name, String pass) {

		try {
			Class.forName(DRIVER_NAME);

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT NAME, PASS FROM USERS WHERE NAME = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			ResultSet rs = pStmt.executeQuery();
			
			
			  while (rs.next()) { 
		            String strageName = rs.getString("name"); 
		            String stragePass = rs.getString("pass"); 
		            if (name.equals(strageName) && pass.equals(stragePass)) { 
		                return true;
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
		return false;

	}

	public boolean insert(String name, String pass) {
		try {
			Class.forName(DRIVER_NAME);

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO USERS(NAME,PASS) VALUES (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2, pass);

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