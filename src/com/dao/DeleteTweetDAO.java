package com.dao;
/**
 * 
 * @author Amit Bharat :DeleteTweetDAO(model).It reads
 *         the data from bean.Here the connection with the database is made and
 *         SQL query is implemented. Its method deleteTweet is called in the
 *         DeleteTweetServlet which is used to delete the tweet of logged in
 *         person profile.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;
//building db layer , it is DAO , part of model

public class DeleteTweetDAO {

	public static UserBean deleteTweet(String tweetId) throws SQLException,
	// preparing some objects for connection
			ClassNotFoundException, Exception {
		Connection currentCon = null;
		PreparedStatement pstmt = null;
		UserBean bean = new UserBean();
		try {// connect to DB
			currentCon = ConnectionManager.getConnection(); // connect to DB
			String deleteTweet = "delete from tweet where tweet_id=?";
			pstmt = currentCon.prepareStatement(deleteTweet);
			pstmt.setString(1, tweetId);
			pstmt.executeUpdate();
			bean.setDeleteTweetCheck(1);
			// some exception handling
			} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
			try {
				currentCon.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}
}
