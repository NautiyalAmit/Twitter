package com.dao;
/**
 * 
 * @author Amit Bharat:In this DAO tweets of logged in
 *         person are displayed.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;

public class TweetDisplayDAO {

	public static List<String> displayTweet(String username) throws SQLException,
			Exception {
		Connection currentCon = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> dataList = new ArrayList<String>();

		String selectTweetQuery = "select tweet_id,message,created from tweet where user_id=? order by created DESC";

		try {
			currentCon = ConnectionManager.getConnection();// connect to DB
			pstmt = currentCon.prepareStatement(selectTweetQuery);
			pstmt.setString(1, username);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				dataList.add(rs.getString("tweet_id"));
				dataList.add(rs.getString("message"));
				dataList.add(rs.getString("created"));
			}
		} finally {// Free the database resources
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return dataList;
	}
}
