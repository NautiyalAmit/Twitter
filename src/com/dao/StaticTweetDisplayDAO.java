package com.dao;

/**
 * 
 * @authorAmit Bharat:In this servlet tweets of logged
 *              in person and the persons he is following are displayed
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;

public class StaticTweetDisplayDAO {

	@SuppressWarnings("unchecked")
	public static List<String> tweetDisplay(String username)
			throws SQLException,// preparing some objects for connection
			ClassNotFoundException, Exception {
		Connection currentCon = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		// search query to find out for specific user
		String displayQuery = "select user_id,message,created from tweet where user_id=? or user_id IN (select following_id from following where user_id=?) order by created DESC;";
		List<String> displayList = new ArrayList<String>();
		try {
			currentCon = ConnectionManager.getConnection();
			pstmt = currentCon.prepareStatement(displayQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, username);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				displayList.add(rs.getString("user_id"));
				displayList.add(rs.getString("message"));
				displayList.add(rs.getString("created"));
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
		return displayList;
	}
}
