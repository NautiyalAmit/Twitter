/**
 * 
 * @author Amit Bharat:In this servlet, when logged in
 *         user wants to unfollow a searched person, delete query is executed
 *         and table is updated.Also SearchDAO is called where count values are
 *         updated.
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
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;
import com.dao.SearchDAO;

public class Unfollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null;
	int rowCount = -1;

	public Unfollow() {
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
		String followerId = (String) session.getAttribute("following");
		String userId = (String) session.getAttribute("user");
		try {
			currentCon = ConnectionManager.getConnection();
			String unfollowDeleteQuery = "delete from following where user_id=? and following_id=?";
			pstmt = currentCon.prepareStatement(unfollowDeleteQuery);
			pstmt.setString(1, userId);
			pstmt.setString(2, followerId);
			pstmt.executeUpdate();
			UserBean user = new UserBean();
			user = SearchDAO.Count1(user);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.include(request, response);
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/FollowServlet");
		rd.forward(request, response);

	}
}
