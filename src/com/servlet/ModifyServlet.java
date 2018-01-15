/**
 * 
 * @author Amit Bharat:In ModifyServlet logged in user's
 *         fullname, password and email are modified.On successful updation
 *         control is transferred to UpdateSuccessful.jsp else to donotknow.
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;

@SuppressWarnings("unused")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean bean = (UserBean) session.getAttribute("bean");
		String oldpswd=bean.getPassword();
		String username = bean.getUser_id();
		String oldpswdjsp=(String)request.getParameter("passwordold");
		String fullname = request.getParameter("fullname1");
		String password = request.getParameter("c_password1");
		String email = request.getParameter("email1");
		String b1 = request.getParameter("fullname_edit");
		String b3 = request.getParameter("password_edit");
		String b4 = request.getParameter("email_edit");

		if (b1 != null)
			fullnameModify(username, fullname, request, response);

		if (b3 != null)
			passwordModify(username, password,oldpswd,oldpswdjsp, request, response);

		if (b4 != null)
			emailModify(username, email, request, response);
	}

	void fullnameModify(String username, String fullname,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Connection currentCon = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String updateFullname = "update person set fullName='" + fullname
					+ "' where user_id='" + username + "'";
			stmt.executeUpdate(updateFullname);

			String updateFullname1 = "update securitycheck set fullName='"
					+ fullname + "' where user_id='" + username + "'";
			stmt.executeUpdate(updateFullname1);
// or we can remove <string> 
			// but that will give warning
			List<String> dataList = new ArrayList<String>();
			String sql = "Select * from person where user_id='" + username
					+ "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dataList.add(rs.getString(1));
				dataList.add(rs.getString(3));
				dataList.add(rs.getString(4));
				dataList.add(rs.getString(5));
			}

			HttpSession session = request.getSession();
			UserBean bean = (UserBean) session.getAttribute("bean");
			bean.setModifiedUserDetail(dataList);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/UpdateSuccessful.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/Donotknow.jsp");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	void passwordModify(String username, String password,String oldpswd,String oldpswdjsp,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Connection currentCon = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			if(oldpswd.equals(oldpswdjsp))
			{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String updatePassword = "update person set password=sha('"
					+ password + "') where user_id='" + username + "'";
			stmt.executeUpdate(updatePassword);

			String updatePassword1 = "update securitycheck set password=sha('"
					+ password + "') where user_id='" + username + "'";
			stmt.executeUpdate(updatePassword1);

			List<String> dataList = new ArrayList<String>();
			String sql = "Select * from person where user_id='" + username
					+ "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dataList.add(rs.getString(1));
				dataList.add(rs.getString(3));
				dataList.add(rs.getString(4));
				dataList.add(rs.getString(5));
			}

			HttpSession session = request.getSession();
			UserBean bean = (UserBean) session.getAttribute("bean");
			bean.setModifiedUserDetail(dataList);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/UpdateSuccessful.jsp");
			rd.forward(request, response);

		}
			else
			{
				HttpSession session = request.getSession();
				UserBean bean = (UserBean) session.getAttribute("bean");
				
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher(
						"/ModifyJSP.jsp");
				rd.forward(request, response);

			}
		}catch (Exception e) {
			response.sendRedirect("/GenericError.jsp");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}

	}

	void emailModify(String username, String email, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Connection currentCon = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String updateEmail = "update person set email='" + email
					+ "' where user_id='" + username + "'";
			stmt.executeUpdate(updateEmail);

			String updateEmail1 = "update securitycheck set email='" + email
					+ "' where user_id='" + username + "'";
			stmt.executeUpdate(updateEmail1);

			List<String> dataList = new ArrayList<String>();
			String sql = "Select * from person where user_id='" + username
					+ "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dataList.add(rs.getString(1));
				dataList.add(rs.getString(3));
				dataList.add(rs.getString(4));
				dataList.add(rs.getString(5));
			}

			HttpSession session = request.getSession();
			UserBean bean = (UserBean) session.getAttribute("bean");
			bean.setModifiedUserDetail(dataList);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/UpdateSuccessful.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("/Donotknow.jsp");
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}

	}
}
