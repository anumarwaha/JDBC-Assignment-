package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;

public class SalesDao {

    public int insertSales(Sales sales) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO TBL_SALES VALUES(?, ?, ?, ?, ?)";
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String strDate = dateFormat.format(date);
        int salesInserted = 0;
        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            preparedStatement.setString(1, sales.getSalesID());
            preparedStatement.setString(2, strDate);
            preparedStatement.setString(3, sales.getProductID());
            preparedStatement.setInt(4, sales.getQuantitySold());
            preparedStatement.setDouble(5, sales.getSalesPricePerUnit());

            if (preparedStatement.executeUpdate() == 1) {
                salesInserted = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesInserted;
    }

    public String generateSalesID(Date salesDate) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "SELECT SEQ_SALES_ID.NEXTVAL FROM DUAL";

        int SEQ_SALES_ID;
        final String stringDate = salesDate.toString();
        String lastTwoDigit = stringDate.substring(stringDate.length() - 2);
        String output;

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            SEQ_SALES_ID = resultSet.getInt(1);
            output = lastTwoDigit + SEQ_SALES_ID;
            return output;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SalesReport> getSalesReport() {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "SELECT * FROM V_SALES_REPORT";

        ArrayList<SalesReport> list = new ArrayList<SalesReport>();

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SalesReport salesReport = new SalesReport();
                salesReport.setSalesID(resultSet.getString(1));
                salesReport.setSalesDate(resultSet.getDate(2));
                salesReport.setProductID(resultSet.getString(3));
                salesReport.setProductName(resultSet.getString(4));
                salesReport.setQuantitySold(resultSet.getInt(5));
                salesReport.setProductUnitPrice(resultSet.getDouble(6));
                salesReport.setSalesPricePerUnit(resultSet.getDouble(7));
                salesReport.setProfitAmount(resultSet.getDouble(8));
                list.add(salesReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void validateConnection(Connection connection) {
        if (connection == null) {
            throw new RuntimeException("Connection object is null");
        }
    }

    public void validatePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            throw new RuntimeException("Prepared statement object is null");
        }
    }
}
