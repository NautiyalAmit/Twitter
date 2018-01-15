/**
 * 
 * @author Amit BHarat:In TweetServlet TweetDAO method
 *         tweetInfo and Tweet_Follow_FollowingNoDAO's method Count is called to
 *         insert the tweet of logged in person and count its no. of tweets.From
 *         here control goes to Intermediateservlet where counters are updated.
 *
 */
package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.TweetDAO;
import com.dao.Tweet_Follow_FollowingNoDAO;


public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TweetServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = new UserBean();// 'user' bean created
			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("user");
			String msg1 = request.getParameter("tweet");
			String msg= msg1.trim();
			if (msg.length() == 0) {
				@SuppressWarnings("unused")
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/EnterMessageError.jsp");
				response.sendRedirect("Home.jsp");
			} else {
				user.setTweet(msg);
				user.setUser_id(username);
		
				user = TweetDAO.tweetInfo(user);
	
				user = Tweet_Follow_FollowingNoDAO.Count(user);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/Intermediateservlet");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);

		}

	}

}
