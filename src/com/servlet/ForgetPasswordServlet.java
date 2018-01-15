package com.servlet;
/**
 * 
 * @author Amit Bharat: here
 *         logged in user is verified whether he is authentic or not. If he is
 *         authentic then he is allowed to reset is password and directed to
 *         Password.jsp.
 * 
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;

public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgetPasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection currentCon = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String username = request.getParameter("usercheck");
		String answer = request.getParameter("anscheck");
		String email = request.getParameter("emailcheck");
		UserBean bean = new UserBean();
		bean.setUser_id(username);
		HttpSession session = request.getSession();
		session.setAttribute("bean", bean);
		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			String searchQuery = "select count(*) from securitycheck where user_id=? and answer=? and email=?";
			// select query to get values from securityCheck table
			pstmt = currentCon.prepareStatement(searchQuery);// create a
																// statement
			pstmt = currentCon.prepareStatement(searchQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, answer);
			pstmt.setString(3, email);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();// result set for records
			rs.next();
			int recordFound = rs.getInt(1);

			if (recordFound == 1) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/Password.jsp");
				dispatcher.include(request, response);

			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/ForgetPassUserError.jsp");
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
