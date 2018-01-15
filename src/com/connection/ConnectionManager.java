package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Amit Bharat Date:11th nov 2015::DB connectivity done connection
 *         object is being returned by static getConnection() DB connectivity
 *         done
 *
 */

public class ConnectionManager {

	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3309/test"; // DB URL
			String dbUser = "root";
			String dbPassword = "root1";

			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, dbUser, dbPassword);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.getStackTrace();
		}

		return con;
	}
}
