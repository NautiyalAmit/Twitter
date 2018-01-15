package com.dao;
/**
 * 
 * @author Amit Bharat:EditTweetDAO(model).It reads the
 *         data from bean.Here the connection with the database is made and SQL
 *         query is implemented. Its method editTweet is called in the
 *         EditTweetServlet which is used to edit the tweet of logged in user.
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;
import com.connection.ConnectionManager;
//building db layer , it is DAO , part of model
public class EditTweetDAO {
	// preparing some objects for connection
	public static UserBean editTweet(String tweetId, String updateTweet)
			throws SQLException, ClassNotFoundException, Exception {

		Connection currentCon = null;
		PreparedStatement pstmt = null;
		UserBean bean = new UserBean();
		String updateTweetQuery = "update tweet set message=? where tweet_id=?";
		try {
			currentCon = ConnectionManager.getConnection();
			pstmt = currentCon.prepareStatement(updateTweetQuery);
			pstmt.setString(1, updateTweet);
			pstmt.setString(2, tweetId);
			pstmt.executeUpdate();
			bean.setEditTweetCheck(1);
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
