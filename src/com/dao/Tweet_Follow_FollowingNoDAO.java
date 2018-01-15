package com.dao;
/**
 * 
 * @author Amit Bharat: Tweet_Follow_FollowingNoDAO is the
 *         model. It reads the data from bean.Here the connection with the
 *         database is made and SQL queries are implemented. Its method count is
 *         called in the LoginServlet which is used to display count values of
 *         following,followers and tweets of the logged in user.
 * 
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bean.UserBean;
import com.connection.ConnectionManager;


public class Tweet_Follow_FollowingNoDAO {

	public static UserBean Count(UserBean bean) throws Exception {
		Statement stmt = null;// preparing some objects for connection
		Connection currentCon = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int followingno = 0;
		int followerno = 0;
		int tweetno = 0;
		String username = bean.getUser_id();// getter called

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String query = "select count(user_id) from following where user_id='"
					+ username + "'";
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				followingno = rs.getInt(1);
			}
			bean.setFollowingNo(followingno);// setter called

			String query2 = "select count(following_id) from following where following_id='"
					+ username + "'";
			rs1 = stmt.executeQuery(query2);

			if (rs1.next()) {
				followerno = rs1.getInt(1);
			}
			bean.setFollowerNo(followerno);// setter called

			String query3 = "select count(message) from tweet where user_id='"
					+ username + "'";
			rs2 = stmt.executeQuery(query3);

			if (rs2.next()) {
				tweetno = rs2.getInt(1);
			}
			bean.setTweetNo(tweetno);
		}

		// Free the database resources
		finally {
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
