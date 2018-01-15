/**
 * 
 * @author Amit Bharat:In ModifyServlet logged in user's
 *         fullname, password and email are modified.On successful updation
 *         control is transferred to UpdateSuccessful.jsp else to donnotknow.
 * 
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;

public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PasswordResetServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection currentCon = null;
		Statement stmt = null;
		Statement stmt1 = null;
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		UserBean bean = (UserBean) session.getAttribute("bean");
		String userId = bean.getUser_id();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt1 = currentCon.createStatement();
			String updatePassword;
			String updatePassword1;
			updatePassword = "update securitycheck set password=sha('"
					+ password + "') where user_id='" + userId + "'";
			updatePassword1 = "update person set password=sha('" + password
					+ "') where user_id='" + userId + "'";
			stmt.executeUpdate(updatePassword);
			stmt1.executeUpdate(updatePassword1);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Login.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				currentCon.close();
			} catch (SQLException e) {

			}

		}
	}

}
