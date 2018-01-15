/**
 * 
 * @author Amit Bharat:Follow servlet (controller), here
 *         database connection is made and select query is executed in which
 *         test condition is checked i.e. whether the person searched by the
 *         logged in user is followed by the logged in person or not. Similarly
 *         result attribute is set either as follow or unfollow and control goes
 *         to Profile.jsp
 * 
 * 
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;
import com.dao.FollowerTweetDAO;
import com.dao.SearchDAO;


public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FollowServlet() {
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
		@SuppressWarnings("rawtypes")
		List tweetDisplay;
		try {
			UserBean user = new UserBean();// bean created
			HttpSession session = request.getSession(false);
			String followerId = (String) session.getAttribute("following");
			String userId = (String) session.getAttribute("user");
			user.setSearch_id(followerId);
			user = SearchDAO.Count1(user);

			int TweetNo = user.getSearch_TweetNo();// getters called
			String TweetNo1 = String.valueOf(TweetNo);
			int FollowingNo = user.getSearch_FollowingNo();
			String FollowingNo1 = String.valueOf(FollowingNo);
			int FollowerNo = user.getSearch_FollowerNo();
			String FollowerNo1 = String.valueOf(FollowerNo);
			tweetDisplay = FollowerTweetDAO.displayTweet(followerId);

			session.setAttribute("data11", tweetDisplay);
			session.setAttribute("tweetno1", TweetNo1);
			session.setAttribute("followingno1", FollowingNo1);
			session.setAttribute("followerno1", FollowerNo1);

			currentCon = ConnectionManager.getConnection();// connect to DB
			String testQuery = "select * from following where user_id=? and following_id=?";

			pstmt = currentCon.prepareStatement(testQuery);
			pstmt.setString(1, userId);
			pstmt.setString(2, followerId);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			if (!rs.next())// result not found
			{
				session.setAttribute("result", "follow");
			} else {
				session.setAttribute("result", "unfollow");
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/Profile.jsp");
		rd.forward(request, response);

	}
}
