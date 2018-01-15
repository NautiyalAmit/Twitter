/**
 * 
 * @author Amit Bharat:Profile_Admin_Servlet displays
 *         the logged in person details.
 * 
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.TweetDisplayDAO;


public class Profile_Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null;

	public Profile_Admin_Servlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("user");
		// or simply <string> can b e removed
		List<String> dataList = new ArrayList<String>();
		List<?> tweetDisplay = new ArrayList<Object>();

		try {
			currentCon = ConnectionManager.getConnection();
			String searchQuery = "select * from person where user_id=?";
			pstmt = currentCon.prepareStatement(searchQuery);
			pstmt.setString(1, username);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				dataList.add(rs.getString("fullName"));
				dataList.add(rs.getString("email"));
				dataList.add(rs.getString("joined"));
			}
			tweetDisplay = TweetDisplayDAO.displayTweet(username);
			session.setAttribute("data", dataList);
			session.setAttribute("data22", tweetDisplay);
			session.setAttribute("username", username);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.forward(request, response);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {

			}
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/AdminProfile.jsp");
		dispatcher.forward(request, response);
	}

}
