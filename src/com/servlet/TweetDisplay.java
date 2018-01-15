/**
 * 
 * @author Amit Bharat:TweetDisplay Servlet is used to
 *         display tweets of logged in person. Here method of TweetDisplayDAO
 *         displayTweet is called where query is executed.From here control goes
 *         to AdminProfile.jsp
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

import com.dao.TweetDisplayDAO;


public class TweetDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TweetDisplay() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			@SuppressWarnings("rawtypes")
			List tweetDisplay;
			String username = (String) session.getAttribute("user");

			tweetDisplay = TweetDisplayDAO.displayTweet(username);
			session.setAttribute("data1", tweetDisplay);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/AdminProfile.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.forward(request, response);

		}
	}
}
