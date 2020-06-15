package main;

import bean.*;
import services.*;
import util.DBUtil;

import java.util.*;
import java.text.*;

public class SalesApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil.getDBConnection();
		try {
			Scanner sc = new Scanner(System.in);
			
			Administrator admin = new Administrator();
			
			int choice;
			
			do {
				System.out.print("\n");
				System.out.println("1. Insert Stock");
				System.out.println("2. Delete Stock");
				System.out.println("3. Insert Sales");
				System.out.println("4. View Sales Report");
				System.out.print("\n");
				System.out.print("Enter your Choice: ");
				choice = sc.nextInt();
				System.out.print("\n");
				
				switch (choice) {
				case 1:
					Stock stock = new Stock();
					System.out.print("Enter product name: ");
					stock.setProductName(sc.next());
					System.out.print("Enter quantity on hand: ");
					stock.setQuantityOnHand(sc.nextInt());
					System.out.print("Enter product unit price: ");
					stock.setProductUnitPrice(sc.nextDouble());
					System.out.print("Enter product reorder level: ");
					stock.setReorderLevel(sc.nextInt());
					admin.insertStock(stock);
					break;
				case 2:
					System.out.print("Enter product id to be deleted: ");
					String removeId = sc.next();
					removeId = admin.deleteStock(removeId);
					break;
				case 3:
					Sales sales = new Sales();
					System.out.print("Enter date (mm-dd-yyyy): ");
					String sDate = sc.next();  
				    Date date = new SimpleDateFormat("mm-dd-yyyy").parse(sDate); 
					sales.setSalesDate(date);
					System.out.print("Enter product id: ");
					sales.setProductID(sc.next());
					System.out.print("Enter quantity sold: ");
					sales.setQuantitySold(sc.nextInt());
					sc.nextLine();
					System.out.print("Enter sales price per unit: ");
					sales.setSalesPricePerUnit(sc.nextDouble());
					admin.insertSales(sales);
					break;
				case 4:
					admin.getSalesReport();
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}
			} while (choice >= 1 && choice <= 4);
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
