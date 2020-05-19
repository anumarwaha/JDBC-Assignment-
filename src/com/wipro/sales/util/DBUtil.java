package com.wipro.sales.util;

import java.sql.*;

public class DBUtil {
	static String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	static Connection con = null;
	static String user = "username";
	static String pass = "password";
	public static Connection getDBConnection() {
		try {
			//Register driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "username", "password");
			return con;
		} catch (Exception e) {
			System.out.println("Connection could not be estanlished");
			e.printStackTrace();
			return null;
		}
	}
}
