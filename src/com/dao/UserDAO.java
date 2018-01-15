package com.dao;
/**
 * 
 * @author Amit Bharat: UserDAO is the model.It reads the
 *         data from bean.Here the connection with the database is made and SQL
 *         queries are implemented. Its method login is called in the Login
 *         Servlet which is used to validate logged in user.
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;


public class UserDAO {

	public static UserBean login(UserBean bean) throws SQLException,
			ClassNotFoundException, IOException, Exception {
		Connection currentCon = null;// preparing some objects for connection
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String username = bean.getUser_id();// username & password created
											// through bean getter
		String password = bean.getPassword();// search query to find out for
												// specific user
		String searchQuery = "select * from person where user_id=? AND password=SHA(?)";
		try {
			currentCon = ConnectionManager.getConnection();// connect to DB
			pstmt = currentCon.prepareStatement(searchQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			boolean more = rs.next();
			if (!more) {
				bean.setActive(0);
			} else if (more) {
				String fullname = rs.getString("fullName");
				bean.setFullName(fullname);
				bean.setActive(1);
			}
		} finally {// Free the database resources
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
			}
		}
		return bean;
	}
}
