/**
 * 
 * @author Amit Bharat 
 * 		   LOGIN SERVLET is the controller,
 *         it acts as a glue between model(UserBean & UserDAO) and
 *         view(Login.jsp & Home.jsp).
 *
 */
package com.servlet;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.StaticTweetDisplayDAO;
import com.dao.Tweet_Follow_FollowingNoDAO;
import com.dao.UserDAO;

/** * Servlet implementation class LoginServlet */
// it is controller servlet , it is glue between model and view
// it conveys which view [JSP] and model[bean,DAO,DB setting and helping classes
// to be called]
// is required to communicate
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2562294252731783855L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			// 'user' bean created
			UserBean user = new UserBean(); // 'user' bean created
			// setters called
			String user_id = request.getParameter("name");
			user.setUser_id(user_id);// setters called
			String password = request.getParameter("password");
			user.setPassword(password);

			user = UserDAO.login(user);// DAO method login called

			if (user.getActive() == 1) {
				HttpSession session = request.getSession(true);// session
																// created
				session.setAttribute("bean", user);
				session.setAttribute("user", user_id);
				user = Tweet_Follow_FollowingNoDAO.Count(user);// DAO method
																// Count called
				int TweetNo = user.getTweetNo();// getters called
				String TweetNo1 = String.valueOf(TweetNo);
				int FollowingNo = user.getFollowingNo();
				String FollowingNo1 = String.valueOf(FollowingNo);
				int FollowerNo = user.getFollowerNo();
				String FollowerNo1 = String.valueOf(FollowerNo);
				session.setAttribute("tweetno", TweetNo1);
				session.setAttribute("followingno", FollowingNo1);
				session.setAttribute("followerno", FollowerNo1);
				@SuppressWarnings("rawtypes")
				List tweetlist = StaticTweetDisplayDAO.tweetDisplay(user_id);// DAO
																				// method
																				// tweetDisplay
																				// called
				session.setAttribute("tweetList", tweetlist);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/Home.jsp");// home page
				rd.forward(request, response);
			} else
				response.sendRedirect("InvalidLogin.jsp"); // error page
		} catch (Throwable theException) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");// error page
			rd.forward(request, response);
		}
	}
}
