package dao;

import bean.*;
import java.util.*;
import java.sql.*;
import util.*;

public class SalesDao {
	
	//method 1
	public int insertSales(Sales sales) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO TBL_SALES VALUES(?, ?, ?, ?, ?)";
		
		java.sql.Date sqlDate = new java.sql.Date(sales.getSalesDate().getTime());
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, sales.getSalesID());
			ps.setDate(2, sqlDate);
			ps.setString(3, sales.getProductID());
			ps.setInt(4, sales.getQuantitySold());
			ps.setDouble(5, sales.getSalesPricePerUnit());
			
			if (ps.executeUpdate() == 1) return 1;
			else return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		}
	
	//method 2
	public static String generateSalesID(java.util.Date salesDate) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT SEQ_SALES_ID.NEXTVAL FROM DUAL";
		
		int SEQ_SALES_ID = 0;
		String out = salesDate.toString().substring(salesDate.toString().length()-2, salesDate.toString().length());
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			SEQ_SALES_ID = rs.getInt(1);
			
			out += SEQ_SALES_ID;
			return out;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//method 3
	public ArrayList<SalesReport> getSalesReport() throws Exception{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "SELECT * FROM V_SALES_REPORT";
		
		ArrayList<SalesReport> list = new ArrayList<SalesReport>();
		
		try {
			con = DBUtil.getDBConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int i=0;
			while (rs.next()) {
				SalesReport salesReport = new SalesReport();
				salesReport.setSalesID(rs.getString(1));
				salesReport.setSalesDate(rs.getDate(2));
				salesReport.setProductID(rs.getString(3));
				salesReport.setProductName(rs.getString(4));
				salesReport.setQuantitySold(rs.getInt(5));
				salesReport.setProductUnitPrice(rs.getDouble(6));
				salesReport.setSalesPricePerUnit(rs.getDouble(7));
				salesReport.setProfitAmount(rs.getDouble(8));
				list.add(salesReport);
				
				System.out.println(list.get(i).getSalesID()+" "+list.get(i).getSalesDate()+" "+list.get(i).getProductID()+" "+list.get(i).getProductName()+" "+list.get(i).getQuantitySold()+" "+list.get(i).getProductUnitPrice()+" "+list.get(i).getSalesPricePerUnit()+" "+list.get(i).getProfitAmount());
				++i;
			}
			i=0;
		} catch (SQLException e) {e.printStackTrace();return null;}		
		
		return list;
		
	}
}
