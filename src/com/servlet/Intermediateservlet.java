/**
 * 
 * @author Amit Bharat :In Intermediateservlet all the
 *         counts of logged in user are updated and control is transferred to
 *         Home.jsp
 *
 */
package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.StaticTweetDisplayDAO;
import com.dao.TweetDisplayDAO;
import com.dao.Tweet_Follow_FollowingNoDAO;

public class Intermediateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Intermediateservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = new UserBean();
			HttpSession session = request.getSession(false);
			String str = (String) session.getAttribute("user");
			user.setUser_id(str);
			user = Tweet_Follow_FollowingNoDAO.Count(user);

			int TweetNo = user.getTweetNo();
			String TweetNo1 = String.valueOf(TweetNo);
			int FollowingNo = user.getFollowingNo();
			String FollowingNo1 = String.valueOf(FollowingNo);
			int FollowerNo = user.getFollowerNo();
			String FollowerNo1 = String.valueOf(FollowerNo);

			@SuppressWarnings("rawtypes")
			List tweetlist1 = TweetDisplayDAO.displayTweet(str);
			@SuppressWarnings("rawtypes")
			List tweetlist = StaticTweetDisplayDAO.tweetDisplay(str);

			session.setAttribute("tweetno", TweetNo1);
			session.setAttribute("followingno", FollowingNo1);
			session.setAttribute("followerno", FollowerNo1);
			session.setAttribute("tweetList", tweetlist);
			session.setAttribute("tweetList1", tweetlist1);

			response.sendRedirect("Home.jsp");

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);
		}
	}

}
