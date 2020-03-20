package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static String databaseUrl = "jdbc:oracle:thin:@localhost:1521";
    static Connection connection = null;
    static String username = "admin";
    static String password = "password";

    public static Connection getDBConnection() {
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Connection could not be established. Stack trace details : ");
            e.printStackTrace();
        }
        return connection;
    }
}
