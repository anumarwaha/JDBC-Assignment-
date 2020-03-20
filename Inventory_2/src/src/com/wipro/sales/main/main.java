package com.wipro.sales.main;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.Stock;
import com.wipro.sales.dao.StockDao;

import java.lang.reflect.Method;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input){
            case 1:
                insertStock(scanner);
                break;
            case 2:
                deleteStock(scanner);
                break;
            case 3:
                insertSales(scanner);
            case 4:
                viewSalesReport();
                break;
            default:
                System.out.println("Invalid Input Sequence");
        }
    }
    public static void insertStock(Scanner scanner) throws Exception{
        Stock stock = new Stock();
        stock.setProductId(scanner.next());
        stock.setProductName(scanner.next());
        stock.setQuantityOnHand(scanner.nextInt());
        stock.setProductUnitPrice(scanner.nextDouble());
        stock.setReorderLevel(scanner.nextInt());
        StockDao stockDao = new StockDao();
        stockDao.insertStock(stock);
    }

    public static void deleteStock(Scanner scanner){

    }

    public static void insertSales(Scanner scanner){
        Sales sales = new Sales();
        sales.setSalesID(scanner.next());
        sales.setProductID(scanner.next());
        sales.setQuantitySold(scanner.nextInt());
        sales.setSalesPricePerUnit(scanner.nextDouble());
    }

    public static void viewSalesReport(){

    }
}
