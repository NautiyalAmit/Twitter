/**
 * 
 * @author Amit Bharat:Search servlet is called  which is used to fetch the search id of the searched person
 *         and control is redirected to the ProfileServlet.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionManager;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String str = request.getParameter("queryString");
		Connection currentCon = null;// preparing some objects for connection
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "Select fullName,user_id from person where fullName LIKE '"
				+ str + "%' LIMIT 10";
		try {
			currentCon = ConnectionManager.getConnection();// connect to DB
			stmt = currentCon.createStatement();
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();

			out.println("<link rel='stylesheet' type='text/css' href='"
					+ request.getContextPath() + "/w3.css' />");
			out.println("<html><body><ul>");

			while (rs.next()) {
				out.println("<li onclick= 'fill(" + rs.getString("fullName")
						+ ");'><a href=\"ProfileServlet?id="
						+ rs.getString("user_id") + "\">"
						+ rs.getString("fullName") + "</a>");
			}
			out.println("</ul></body></html>");

		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Donotknow.jsp");
			rd.forward(request, response);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
			}
		}
	}
}
