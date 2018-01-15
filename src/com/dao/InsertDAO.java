package com.dao;
/**
 * 
 * @author Amit Bharat:In this DAO username,password and
 *         email of the logged in person are inserted into the person table
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;
//building db layer , it is DAO , part of model
public class InsertDAO {

	public static UserBean login(UserBean bean) throws SQLException,
			ClassNotFoundException, Exception {
		Connection currentCon = null;// preparing some objects for connection
		@SuppressWarnings("unused")
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		// username & password etc created through bean getter
		String username = bean.getUser_id();// getters called
		String fullname = bean.getFullName();
		String password = bean.getPassword();
		String answer = bean.getAnswer();
		String email = bean.getEmail();

		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			// search query to find out for specific user
			String insertQuery = "insert into person(user_id,fullName,password,email,active) values(?, ?,SHA(?) ,?,?)";
			// insert query to insert values into person table
			pstmt = currentCon.prepareStatement(insertQuery); // create a
																// statement

			pstmt.setString(1, username); // set input parameter 1
			pstmt.setString(2, fullname); // set input parameter 2
			pstmt.setString(3, password); // set input parameter 3
			pstmt.setString(4, email);// set input parameter 4
			pstmt.setString(5, "1");// set input parameter 5

			pstmt.executeUpdate(); // execute insert statement

			String insertQuery1 = "insert into securitycheck (user_id,fullName,password,answer,email) values(?, ?,SHA(?),?,?)";
			// insert query to insert values into securitycheck table
			pstmt = currentCon.prepareStatement(insertQuery1); // create a
																// statement
			pstmt.setString(1, username); // set input parameter 1
			pstmt.setString(2, fullname); // set input parameter 2
			pstmt.setString(3, password); // set input parameter 3
			pstmt.setString(4, answer);// set input parameter 4
			pstmt.setString(5, email);// set input parameter 5
			pstmt.executeUpdate(); // execute insert statement

			bean.setActive(1);
		}
		// Free the database resources
		finally {
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				
				} catch (Exception e) {

				}
			}
		}
		return bean;
	}
}
