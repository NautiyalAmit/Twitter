package com.servlet;

/**
 * 
 * @author Amit Bharat:Follow servlet (controller), here
 *         database connection is made and insert query is executed in which
 *         following table is updated in which for a logged in user
 *         corresponding users whom he follows is inserted. From here flow goes
 *         to FollowServlet
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.connection.ConnectionManager;
import com.dao.SearchDAO;

public class Follow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Follow() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection currentCon = null;
		PreparedStatement pstmt = null;
		HttpSession session = request.getSession(false);
		String followerId = (String) session.getAttribute("following");
		String userId = (String) session.getAttribute("user");
		String followInsertQuery = "insert into following values (?,?)";
		try {
			currentCon = ConnectionManager.getConnection();
			pstmt = currentCon.prepareStatement(followInsertQuery);
			pstmt.setString(1, userId);
			pstmt.setString(2, followerId);
			pstmt.executeUpdate();
			UserBean user = new UserBean();
			user = SearchDAO.Count1(user);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Donotknow.jsp");
			dispatcher.include(request, response);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/FollowServlet");
		rd.forward(request, response);
	}
}
