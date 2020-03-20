package com.wipro.sales.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String uName = "root";
        String pass = "Kshv@wrkfr28";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,uName,pass);
    }
}
