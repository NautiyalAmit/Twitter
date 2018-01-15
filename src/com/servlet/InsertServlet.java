/**
 * 
 * @author Amit Bharat:Insert Servlet is the controller,
 *         it acts as a glue between model(InsertDAO & UserBean) and
 *         view(Login.jsp & Home.jsp). In InsertDAO insert query is executed
 *         which insert logged in user details in person table.
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
import com.dao.InsertDAO;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = new UserBean();// 'user' bean created
			user.setUser_id(request.getParameter("username"));// setters called
			user.setFullName(request.getParameter("fullname"));
			user.setPassword(request.getParameter("password"));
			user.setAnswer(request.getParameter("anscheck"));
			user.setEmail(request.getParameter("email"));
			String userId = user.getUser_id();
			user = InsertDAO.login(user);
			if (user.getActive() == 1) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", userId);
				RequestDispatcher rd = request
						.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("/Error.jsp");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
