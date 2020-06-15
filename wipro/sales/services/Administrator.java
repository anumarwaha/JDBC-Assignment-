package services;

import bean.*;
import dao.*;
import java.util.*;

public class Administrator {
	private static StockDao stockDao = new StockDao();
	private static SalesDao salesDao = new SalesDao();
	
	//method 1
	public synchronized String insertStock(Stock stockobj) throws Exception {
		if (stockobj != null && stockobj.getProductName().length() >= 2) {
			String productID = stockDao.generateProductID(stockobj.getProductName());
			stockobj.setProductID(productID);
			if (stockDao.insertStock(stockobj) == 1)
				return productID;
			else
				return "Data not Valid for insertion";
		} else {
			return "Data not Valid for insertion";
		}
	}
	
	//method 2
	public String deleteStock(String ProductID) throws Exception {
		if (stockDao.deleteStock(ProductID) == 1)
			return "deleted";
		else 
			return "record cannot be deleted";
	}
	
	//method 3
	public String insertSales(Sales salesobj) throws Exception {
		if (salesobj == null) 
			return "Object not valid for insertion";
		else if (stockDao.getStock(salesobj.getProductID()) == null)
			return "Unknown Product for sales";
		else if (stockDao.getStock(salesobj.getProductID()).getQuantityOnHand() < salesobj.getQuantitySold())
			return "Not enough stock on hand for sales";
		else if (salesobj.getSalesDate().before(new Date()))
		return "Invalid date";
		
		String salesID = SalesDao.generateSalesID(salesobj.getSalesDate());
		salesobj.setSalesID(salesID);
		
		if (salesDao.insertSales(salesobj) == 1) {
			if (stockDao.updateStock(salesobj.getProductID(), salesobj.getQuantitySold()) == 1)
				return "sales record inserted successfully";
			else 
				return "Error";
		} else {
			return "Error";
		}
		
	}
	
	//method 4
	public ArrayList<SalesReport> getSalesReport() throws Exception {	
		return salesDao.getSalesReport();
	}
}
