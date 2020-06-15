package dao;

import bean.*;
import java.sql.*;
import util.*;

public class StockDao {
	
	//method 1
	public int insertStock(Stock stock) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO TBL_STOCK VALUES(?, ?, ?, ?, ?)";
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, stock.getProductID());
			ps.setString(2, stock.getProductName());
			ps.setInt(3, stock.getQuantityOnHand());
			ps.setDouble(4, stock.getProductUnitPrice());
			ps.setInt(5, stock.getReorderLevel());
			
			if (ps.executeUpdate() == 1) return 1;
			else return 0;
		} catch (SQLException e) {e.printStackTrace();return 0;}
	}
	
	//method 2
	public String generateProductID(String productName) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT SEQ_PRODUCT_ID.NEXTVAL FROM DUAL";
		
		int SEQ_PRODUCT_ID = 0;
		String out = "";
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			SEQ_PRODUCT_ID = rs.getInt(1);
			
			out += productName.substring(0, 2);
			out += SEQ_PRODUCT_ID;
			
			return out;
		} catch (SQLException e) {e.printStackTrace();return null;}
	}
	
	//method 3
	public int updateStock(String productID,int soldQty) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE TBL_STOCK SET Quantity_On_Hand = Quantity_On_Hand - ?"
				+ "WHERE Product_ID = ?";
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, soldQty);
			ps.setString(2, productID);
			
			if (ps.executeUpdate() == 1) return 1;
			else return 0;
		} catch (SQLException e) {e.printStackTrace();return 0;}
	}
	
	//method 4
	public Stock getStock(String productID) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT * FROM TBL_STOCK WHERE Product_ID = ?";
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productID);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			Stock stock = new Stock();
			stock.setProductID(rs.getString(1));
			stock.setProductName(rs.getString(2));
			stock.setQuantityOnHand(rs.getInt(3));
			stock.setProductUnitPrice(rs.getDouble(4));
			stock.setReorderLevel(rs.getInt(5));
			
			return stock;
		} 
		catch (SQLException e) {e.printStackTrace();return null;}
		
	}
	
	//method 5
	public int deleteStock(String productID) throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE TBL_STOCK WHERE Product_ID = ?";
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productID);
			
			if (ps.executeUpdate() == 1) return 1;
			else return 0;
		} catch (SQLException e) {e.printStackTrace();return 0;}
	}
}
