package com.wipro.sales.service;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Stock;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;

import java.util.ArrayList;

public class Administrator {
    String insertStock(Stock stockObj) throws Exception{
        StockDao stockDao = new StockDao();
        if (stockObj != null && stockObj.getProductName().length() >= 2){
            stockDao.insertStock(stockObj);
            stockDao.generateProductID(stockObj.getProductName());

            return stockDao.generateProductID(stockObj.getProductName());
        }
        return "Data Not Valid for insertion";
    }

    String deleteStock(String ProductId) throws Exception{
        StockDao stockDao = new StockDao();
        try {
            stockDao.deleteStock(ProductId);
        }
        catch (Exception e){
            return "record can not be deleted";
        }
        return "";
    }

    String insertSales(Stock salesObj){
        SalesDao salesDao = new SalesDao();
        if (salesObj == null){
            return "Object Not Valid For Instruction";
        }
        return "";
    }
//
//    ArrayList<SalesReport> getSalesReport(){
//
//    }
}
