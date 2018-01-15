/**
 * 
 * @author Amit Bharat:It is used to check whether the
 *         username already exists in the database or not
 * 
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionManager;

public class UserIDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserIDCheckServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		Connection currentCon = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		currentCon = ConnectionManager.getConnection();
		String searchQuery = "select count(*) from person where user_id=?";
		// select query to get values from person table
		try {
			pstmt = currentCon.prepareStatement(searchQuery);// create a
																// prepared
																// statement
			pstmt.setString(1, username);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();// result set for records
			rs.next();
			int recordFound = rs.getInt(1);

			if (recordFound == 1) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/Error.jsp");
				dispatcher.include(request, response);
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/NoError.jsp");
				dispatcher.include(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.include(request, response);
		} finally {
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
	}

}
