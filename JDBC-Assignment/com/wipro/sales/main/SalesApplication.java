package com.wipro.sales.main;

import com.wipro.sales.bean.Stock;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.service.Administrator;

import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesApplication {

    public static void main(String[] args) throws ParseException {
        Administrator administrator = new Administrator();
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        int choice = selectChoice(scanner);

        switch (choice) {
            case 1:
                insertStock(administrator, scanner);
                break;
            case 2:
                deleteProduct(administrator, scanner);
                break;
            case 3:
                insertSales(administrator, scanner);
                break;
            case 4:
                administrator.getSalesReport();
                break;
            default:
                System.out.println("Not a valid option!!");
                break;
        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Enter your Choice. Press ");
        System.out.println("1 for Insert Stock");
        System.out.println("2 for Delete Stock");
        System.out.println("3 for Insert Sales");
        System.out.println("4 for View Sales Report");
    }

    public static int selectChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void insertStock(Administrator administrator, Scanner scanner) {
        Stock stock = new Stock();

        System.out.println("Enter product ID: ");
        String productID = scanner.next();
        stock.setProductID(productID);

        System.out.println("Enter product name: ");
        String productName = scanner.next();
        stock.setProductName(productName);

        System.out.println("Enter quantity on hand: ");
        stock.setQuantityOnHand(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter product unit price: ");
        stock.setProductUnitPrice(scanner.nextDouble());

        System.out.println("Enter product reorder level: ");
        stock.setReorderLevel(scanner.nextInt());
        scanner.nextLine();
        administrator.insertStock(stock);
    }

    public static void deleteProduct(Administrator administrator, Scanner scanner) {
        System.out.print("Enter product id to be deleted: ");
        String removeId = scanner.nextLine();
        removeId = administrator.deleteStock(removeId);
        if (removeId != null) System.out.println(removeId + " removed successfully");
    }

    public static void insertSales(Administrator administrator, Scanner scanner) throws ParseException {
        Sales sales = new Sales();
        System.out.print("Enter sales id: ");
        sales.setSalesID(scanner.nextLine());
        System.out.print("Enter date (dd-mm-yyyy): ");
        String sDate = scanner.nextLine();
        Date date = new SimpleDateFormat("dd-mm-yyyy").parse(sDate);
        sales.setSalesDate(date);
        System.out.print("Enter product id: ");
        sales.setProductID(scanner.nextLine());
        System.out.print("Enter quantity sold: ");
        sales.setQuantitySold(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter sales price per unit: ");
        sales.setSalesPricePerUnit(scanner.nextDouble());
        administrator.insertSales(sales);
    }

}
