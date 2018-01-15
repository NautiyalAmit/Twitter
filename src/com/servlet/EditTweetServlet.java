package com.servlet;

/**
 * 
 * @author Amit Bharat:EditTweetServlet (controller),
 *         acts as a link between model(UserBean & EditTweetDAO) and
 *         Profile_Admin_Servlet. On successful execution of update query in
 *         DAO, user's tweet will be updated and control will be redirected to
 *         AdminProfile Page.
 * 
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.EditTweetDAO;

/** * Servlet implementation class httpServlet */
// it is controller servlet , it is glue between model and view
// it conveys which view [JSP] and model[bean,DAO,DB setting and helping classes
// to be called]
// is required to communicate
public class EditTweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditTweetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String tweetId = (String) session.getAttribute("tweetID");
		String updateTweet = request.getParameter("modifytweet");
		UserBean bean = new UserBean();
		try {
			bean = EditTweetDAO.editTweet(tweetId, updateTweet);
			if (bean.getEditTweetCheck() == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/Profile_Admin_Servlet");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);
		}
	}

}
