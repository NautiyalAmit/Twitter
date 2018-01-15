package com.servlet;

/**
 * 
 * @author Amit Bharat:DeleteServlet (controller), acts
 *         as a glue between model(UserBean & DeleteUserDAO) and
 *         view(DeleteJSP.jsp). On successful execution of delete query in DAO,
 *         user's account will be deleted and user will be redirected to Login
 *         Page.
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
import com.dao.DeleteUserDAO;

/** * Servlet implementation class deleteServlet */
// it is controller servlet , it is glue between model and view
// it conveys which view [JSP] and model[bean,DAO,DB setting and helping classes
// to be called]
// is required to communicate
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		UserBean bean = new UserBean();
		try {// userbean created
			bean = DeleteUserDAO.deleteProfile(username);
			bean = DeleteUserDAO.deleteSecurityCheck(username);
			if (bean.getDeleteCheck() == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/DeleteJSP.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/DeleteError.jsp");
			rd.forward(request, response);
		}

	}

}
