/**
 * 
 * @author Amit Bharat:ProfileServlet is used to display
 *         the details and tweets of the searched person and the control is
 *         transferred to FollowServlet
 * 
 */
package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Statement stmt = null;
		Connection currentCon = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String followingId = request.getParameter("id");

		HttpSession session = request.getSession(false);
		session.setAttribute("following", followingId);
		// or remove <string>
		List<String> dataList = new ArrayList<String>();
		List<String> dataList1 = new ArrayList<String>();

		if (followingId.equals(session.getAttribute("user"))) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Home.jsp");
			dispatcher.include(request, response);

		} else {
			try {
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				String searchQuery7;
				searchQuery7 = "select * from person where user_id='"
						+ followingId + "'";
				stmt.executeQuery(searchQuery7);
				rs = stmt.getResultSet();

				while (rs.next()) {
					dataList.add(rs.getString("fullName"));
					dataList.add(rs.getString("email"));
					dataList.add(rs.getString("joined"));
				}

				String searchQuery8;
				searchQuery8 = "select user_id,message,created from tweet where user_id='"
						+ followingId + "'";

				stmt.executeQuery(searchQuery8);
				rs1 = stmt.getResultSet();

				while (rs1.next()) {
					dataList1.add(rs1.getString("UserID"));
					dataList1.add(rs1.getString("Tweet"));
					dataList1.add(rs1.getString("Created"));
				}
			}

			catch (Exception e) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/Donotknow.jsp");
				dispatcher.include(request, response);
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
			session.setAttribute("data", dataList);
			session.setAttribute("data5", dataList1);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("FollowServlet");
			dispatcher.forward(request, response);

		}

	}
}
