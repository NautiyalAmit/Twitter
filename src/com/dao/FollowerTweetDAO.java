package com.dao;

/**
 * 
 * @author Amit Bharat: FollowerTweetDAO is the model.It
 *         reads the data from bean.Here the connection with the database is
 *         made and SQL queries are implemented. Its method displayTweet is
 *         called in the FollowServlet which is used to display tweet of
 *         searched person.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionManager;

//db

public class FollowerTweetDAO {

	public static List<String> displayTweet(String searchname)
			throws SQLException, ClassNotFoundException, Exception {
		Connection currentCon = null;// preparing some objects for connection
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		// or <string > could be removed but WARNING WILL BE GENERATED
		List<String> dataList = new ArrayList<String>();
		String selectTweetQuery = "select user_id,message,created from tweet where user_id=? order by created desc";
		try {
			currentCon = ConnectionManager.getConnection(); // connect to DB
			pstmt = currentCon.prepareStatement(selectTweetQuery);
			pstmt.setString(1, searchname);
			pstmt.executeQuery();
			rs = pstmt.getResultSet();

			while (rs.next()) {
				dataList.add(rs.getString("user_id"));
				dataList.add(rs.getString("message"));
				dataList.add(rs.getString("created"));
			}

		} finally {
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
