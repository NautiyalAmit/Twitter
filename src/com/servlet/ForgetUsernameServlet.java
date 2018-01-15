/**
 * 
 * @author Amit Bharat :ForgetUsernameServlet, here
 *         logged in user is verified whether he is authentic or not. If he is
 *         authentic then his username is retrieved from the database and
 *         forwarded to Username.jsp.
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;

public class ForgetUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgetUsernameServlet() {
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
		String fullname = request.getParameter("fullcheck");
		String answer = request.getParameter("anscheck");
		String email = request.getParameter("emailcheck");
		String username = null;
		try {
			currentCon = ConnectionManager.getConnection();
			String searchQuery = "select user_id from securitycheck where fullname=? and answer=? and email=?";
			pstmt = currentCon.prepareStatement(searchQuery);
			pstmt.setString(1, fullname);
			pstmt.setString(2, answer);
			pstmt.setString(3, email);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				username = rs.getString("user_id");
			}
			if (username == null) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/ForgetPassUserError.jsp");
				dispatcher.include(request, response);
			} else {
				UserBean bean = new UserBean();
				bean.setUser_id(username);
				HttpSession session = request.getSession();
				session.setAttribute("bean", bean);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Username.jsp");
				dispatcher.include(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.include(request, response);
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

	}

}
