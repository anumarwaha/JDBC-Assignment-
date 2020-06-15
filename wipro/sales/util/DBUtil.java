package util;

import java.sql.*;

public class DBUtil {

	private static Connection con = null;

	public static Connection getDBConnection() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="412589";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			//System.out.println("connection established\n");

			//Statement st=con.createStatement();
			//st.executeUpdate("drop table TBL_SALES");
			//st.executeUpdate("drop table TBL_STOCK");
			/*st.executeUpdate("CREATE table TBL_STOCK "
					+ "( Product_ID VARCHAR2(6) PRIMARY KEY,"
					+ "Product_Name VARCHAR2(20) UNIQUE,"
					+ "Quantity_On_Hand NUMBER,"
					+ "Product_Unit_Price NUMBER,"
					+ "Reorder_Level NUMBER,"
					+ "constraint TBL_STOCK_C1 check (Quantity_On_Hand >=0),"
					+ "constraint TBL_STOCK_C2 check (Product_Unit_Price >=0),"
					+ "constraint TBL_STOCK_C3 check (Reorder_Level >=0) )");*/

			/*st.executeUpdate("CREATE table TBL_SALES (\r\n" + 
					"Sales_ID VARCHAR2(6) PRIMARY KEY,\r\n" + 
					"Sales_Date DATE,\r\n" + 
					"Product_ID VARCHAR2(6),\r\n" + 
					"Quantity_Sold NUMBER,\r\n" + 
					"Sales_Price_Per_Unit NUMBER,\r\n" + 
					"constraint TBL_SALES_C1 check (Quantity_Sold >=0),\r\n" + 
					"constraint TBL_SALES_C2 check (Sales_Price_Per_Unit >=0),\r\n" + 
					"constraint TBL_SALES_C3 FOREIGN KEY (Product_ID) REFERENCES TBL_STOCK(Product_ID) \r\n" + 
					")");*/
			//st.executeUpdate("insert into TBL_STOCK values('RE1001','REDMI Note 3',20,12000,5)");
			//st.executeUpdate("insert into TBL_STOCK values('IP1002','Iphone 5S',10,21000,2)");
			//st.executeUpdate("insert into TBL_STOCK values('PA1003','Panasonic P55',50,5500,5)");

			//st.executeUpdate("create sequence SEQ_SALES_ID start with 1000 increment by 1 nocache nocycle noorder");
			//st.executeUpdate("create sequence SEQ_PRODUCT_ID start with 1004 increment by 1 nocache nocycle noorder");
			//st.executeUpdate("drop sequence SEQ_PRODUCT_ID");
			//st.executeUpdate("drop sequence SEQ_SALES_ID");

			/*st.executeUpdate("create view V_SALES_REPORT as "
					+ "select "
					+ "Sales_ID, Sales_Date, Product_ID, Product_Name, Quantity_Sold, Product_Unit_Price, Sales_Price_Per_Unit, "
					+ "(Sales_Price_Per_Unit - Product_Unit_Price) Profit_Amount "
					+ "from TBL_STOCK natural join TBL_SALES "
					+ "order by Profit_Amount desc, Sales_ID asc");*/
			//st.executeUpdate("commit");
			//for testing purpuse
			/*ResultSet rs=st.executeQuery("select Sales_ID from V_SALES_REPORT");
			while(rs!=null&&rs.next())
				System.out.println(rs.getString(1));

			rs=st.executeQuery("select Product_ID from TBL_STOCK");
			while(rs!=null&&rs.next())
				System.out.println(rs.getString(1));*/
		}
		catch(SQLException e) {System.out.println("Connection Failed");e.printStackTrace();}
		return con;
	}
}
