package com.wipro.sales.dao;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class SalesDao {
    void insertSales(Sales sales) throws Exception{
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO TBL_SALES VALUES (?,?,?,?,?)");
        statement.setString(1,sales.getSalesID());
        statement.setDate(2, (java.sql.Date) sales.getSalesDate());
        statement.setString(3,sales.getProductID());
        statement.setInt(4,sales.getQuantitySold());
        statement.setDouble(5,sales.getSalesPricePerUnit());
        statement.executeUpdate();
    }

    String generateSales(Date salesDate) throws Exception{

        return " ";
    }

//    ArrayList<SalesReport> getSalesReport(){
//
//    }
}
