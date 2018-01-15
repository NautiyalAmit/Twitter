/**
 * 
 * @author Amit Bharat:DeleteTweetServlet(controller),
 *         acts as a link between model(UserBean & DeleteTweetDAO) and
 *         Intermediateservlet. On successful execution of delete query in DAO,
 *         control will flow to Intermediateservlet where counter value of tweet
 *         will be updated.
 * 
 */
package com.servlet;

/** * Servlet implementation class deletetweetservletServlet */
//it is controller servlet , it is glue between model and view
//it conveys which view [JSP] and model[bean,DAO,DB setting and helping classes to be called] 
//is required to communicate
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.DeleteTweetDAO;

public class DeleteTweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTweetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		String tweetId = request.getParameter("id");
		try {// userbean
			bean = DeleteTweetDAO.deleteTweet(tweetId);
			if (bean.getDeleteTweetCheck() == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/Intermediateservlet");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);
		}
	}

}
