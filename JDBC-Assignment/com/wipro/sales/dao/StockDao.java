package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.sales.bean.Stock;
import com.wipro.sales.util.DBUtil;

public class StockDao {

    public int insertStock(Stock stock) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO TBL_STOCK VALUES(?, ?, ?, ?, ?)";
        int stocksInserted = 0;

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            preparedStatement.setString(1, stock.getProductID());
            preparedStatement.setString(2, stock.getProductName());
            preparedStatement.setInt(3, stock.getQuantityOnHand());
            preparedStatement.setDouble(4, stock.getProductUnitPrice());
            preparedStatement.setInt(5, stock.getReorderLevel());

            if (preparedStatement.executeUpdate() == 1) {
                stocksInserted = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocksInserted;
    }


    public String generateProductID(String productName) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "SELECT SEQ_PRODUCT_ID.NEXTVAL FROM DUAL";

        int SEQ_PRODUCT_ID;
        String output = "";

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            SEQ_PRODUCT_ID = resultSet.getInt(1);

            output += productName.substring(0, 2);
            output += SEQ_PRODUCT_ID;

            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public int updateStock(String productID, int soldQty) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "UPDATE TBL_STOCK SET Quantity_On_Hand = Quantity_On_Hand - ? WHERE Product_ID = ?";
        int stocksUpdated = 0;

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            preparedStatement.setInt(1, soldQty);
            preparedStatement.setString(2, productID);

            if (preparedStatement.executeUpdate() == 1) {
                stocksUpdated = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocksUpdated;
    }

    public Stock getStock(String productID) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "SELECT * FROM TBL_STOCK WHERE Product_ID = ?";

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            preparedStatement.setString(1, productID);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Stock stock = new Stock();
            stock.setProductID(resultSet.getString(1));
            stock.setProductName(resultSet.getString(2));
            stock.setQuantityOnHand(resultSet.getInt(3));
            stock.setProductUnitPrice(resultSet.getDouble(4));
            stock.setReorderLevel(resultSet.getInt(5));

            return stock;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public int deleteStock(String productID) {
        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "DELETE TBL_STOCK WHERE Product_ID = ?";
        int stockDeleted = 0;

        try {
            connection = DBUtil.getDBConnection();
            validateConnection(connection);
            preparedStatement = connection.prepareStatement(sql);
            validatePreparedStatement(preparedStatement);
            preparedStatement.setString(1, productID);

            if (preparedStatement.executeUpdate() == 1) {
                stockDeleted = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stockDeleted;
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
