package com.dao;

/**
 * 
 * @author Amit Bharat:Here database connection is made
 *         and no. of tweets,followers and following of searched person is
 *         considered.
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.UserBean;
import com.connection.ConnectionManager;

public class SearchDAO {

	public static UserBean Count1(UserBean bean) throws SQLException, Exception {
		Connection currentCon = null;// preparing some objects for connection
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int followingno = 0;
		int followerno = 0;
		int tweetno = 0;
		Statement stmt = null;
		String username = bean.getSearch_id();// getter called
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String query = "select count(user_id) from following where user_id='"
					+ username + "'";
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				followingno = rs.getInt(1);
			}
			bean.setSearch_FollowingNo(followingno);

			String query2 = "select count(following_id) from following where following_id='"
					+ username + "'";
			rs1 = stmt.executeQuery(query2);

			if (rs1.next()) {
				followerno = rs1.getInt(1);
			}
			bean.setSearch_FollowerNo(followerno);

			String query3 = "select count(message) from tweet where user_id='"
					+ username + "'";
			rs2 = stmt.executeQuery(query3);

			if (rs2.next()) {
				tweetno = rs2.getInt(1);
			}
			bean.setSearch_TweetNo(tweetno);

		}

		finally // Free the database resources
		{
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
				currentCon = null;
			}
		}

		return bean;
	}
}
