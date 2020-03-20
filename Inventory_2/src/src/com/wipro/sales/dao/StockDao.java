package com.wipro.sales.dao;
import com.wipro.sales.bean.Stock;
import com.wipro.sales.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockDao {
    public void insertStock(Stock stock) throws Exception{
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO TBL_STOCK VALUES (?,?,?,?,?)");
        statement.setString(1,stock.getProductId());
        statement.setString(2,stock.getProductName());
        statement.setInt(3,stock.getQuantityOnHand());
        statement.setDouble(4,stock.getProductUnitPrice());
        statement.setInt(5,stock.getReorderLevel());
        statement.executeUpdate();
    }

    public String generateProductID(String productName) throws Exception{
        String query = "SELECT PRODUCT_ID from TBL_STOCK WHERE Product_Name = " + productName;
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        return productName.substring(0,1).concat(statement.executeQuery().getString(0));
    }

    public void updateStock(String productId,int soldQty){

    }

    public Stock getStock(String productId) throws Exception{
        String query = "SELECT * from TBL_STOCK WHERE Product_ID = " + productId;
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        Stock stock = new Stock();
        stock.setProductId(resultSet.getString(0));
        stock.setProductName(resultSet.getString(1));
        stock.setQuantityOnHand(resultSet.getInt(2));
        stock.setProductUnitPrice(resultSet.getDouble(3));
        stock.setReorderLevel(resultSet.getInt(4));
        return stock;
    }

   public void deleteStock(String productId) throws Exception{
        String query = "DELETE from TBL_STOCK WHERE Product_Id = " + productId;
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

}
