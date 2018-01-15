package com.dao;
/**
 * 
 * @author Amit Bharat:In this DAO tweets of the logged
 *         in user are inserted into the tweet table in tthe database.
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;


public class TweetDAO {

	public static UserBean tweetInfo(UserBean bean) throws SQLException,
			ClassNotFoundException, Exception {
		Connection currentCon = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String username = bean.getUser_id();
		String tweet = bean.getTweet();

		String insertQuery = "insert into tweet(user_id,message)values(?, ?)";
		try {
			currentCon = ConnectionManager.getConnection();// connect to DB
			pstmt = currentCon.prepareStatement(insertQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, tweet);
		
			pstmt.executeUpdate();
		} finally {// Free the database resources
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {

				}
				pstmt = null;
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
