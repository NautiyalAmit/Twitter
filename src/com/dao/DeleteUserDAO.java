package com.dao;
/**
 * 
 * @author Amit Bharat:DeleteUserDAO(model).It reads the
 *         data from bean.Here the connection with the database is made and SQL
 *         query is implemented. Its method deleteProfile is called in the
 *         DeleteServlet which is used to delete the logged in person profile.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;


public class DeleteUserDAO {

	public static UserBean deleteProfile(String username) throws SQLException,
			ClassNotFoundException, Exception {
		Connection currentCon = null;
		PreparedStatement pstmt = null;
		UserBean bean = new UserBean();
		try {
			currentCon = ConnectionManager.getConnection(); // connect to DB
			String deleteQuery = "delete from person where user_id=?";
			pstmt = currentCon.prepareStatement(deleteQuery);
			pstmt.setString(1, username);
			pstmt.executeUpdate();
			bean.setDeleteCheck(1);

		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	public static UserBean deleteSecurityCheck(String username)
			throws SQLException, ClassNotFoundException, Exception {
		Connection currentCon = null;
		PreparedStatement pstmt = null;
		UserBean bean = new UserBean();
		try {
			currentCon = ConnectionManager.getConnection(); // connect to DB
			String deleteQuery = "delete from securitycheck where user_id=?";
			pstmt = currentCon.prepareStatement(deleteQuery);
			pstmt.setString(1, username);
			pstmt.executeUpdate();
			bean.setDeleteCheck(1);

		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}
}
