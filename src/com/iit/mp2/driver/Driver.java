package com.iit.mp2.driver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Offices;
import com.iit.mp2.domain.OrderDetails;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.domain.Payments;
import com.iit.mp2.domain.ProductLines;
import com.iit.mp2.domain.Products;
import com.iit.mp2.exception.FileParsingException;
import com.iit.mp2.fileio.FileDeserializer;
import com.iit.mp2.fileio.FileInputRunner;
import com.iit.mp2.fileio.FileSerializer;
import com.iit.mp2.fileio.TotalList;
/*
 * This is the Driver class which contains the main method from where the execution of program starts
 * 
 */
public class Driver {

	private static Scanner scanner;
	private static String userInput;
	private static FileInputRunner fileInputRunner;
	private static FileSerializer fileSerializer;
	private static FileDeserializer fileDeserializer;
	private static String filePathForSerialization;
	private static String filePathForDeserialization;

	private static TotalList totalList;
	private static OutputStream outputStream;
	private static Writer writer;
	
	private static String filePathForCustomers;
	private static String filePathForEmployees;
	private static String filePathForOrders;
	private static String filePathForOffices;
	private static String filePathForOrderDetails;
	private static String filePathForPayments;
	private static String filePathForProductLines;
	private static String filePathForProducts;
	
	public static List<Customers> customers;
	public static List<Employees> employees;
	public static List<Orders> orders;
	public static List<Offices> offices;
	public static List<OrderDetails> orderDetails;
	public static List<Payments> payments;
	public static List<ProductLines> productLines;
	public static List<Products> products;
	
	public static void setUp() throws FileParsingException
	{
		scanner = new Scanner(System.in);
		customers = new ArrayList<>();
		employees = new ArrayList<>();
		orders = new ArrayList<>();	
		offices = new ArrayList<>();
		orderDetails  = new ArrayList<>();
		payments = new ArrayList<>();
		productLines = new ArrayList<>();
		products = new ArrayList<>();
		
		filePathForCustomers =  Driver.class.getResource("/data/Customers.txt").getPath();
		filePathForEmployees = Driver.class.getResource("/data/Employees.txt").getPath();
		filePathForOrders = Driver.class.getResource("/data/Orders.txt").getPath();
		filePathForOffices = Driver.class.getResource("/data/Offices.txt").getPath();
		filePathForOrderDetails = Driver.class.getResource("/data/OrderDetails.txt").getPath();
		filePathForPayments = Driver.class.getResource("/data/Payments.txt").getPath();
		filePathForProductLines = Driver.class.getResource("/data/ProductLines.txt").getPath();
		filePathForProducts = Driver.class.getResource("/data/Products.txt").getPath();
				
		fileInputRunner = new FileInputRunner(filePathForCustomers, filePathForEmployees, filePathForOrders, filePathForOffices, filePathForOrderDetails, filePathForPayments, filePathForProductLines, filePathForProducts);
		fileInputRunner.run();
		
		customers = fileInputRunner.getListForCustomers();
		employees = fileInputRunner.getListForEmployees();
		orders = fileInputRunner.getListForOrders();
		offices = fileInputRunner.getListForOffices();
		orderDetails = fileInputRunner.getListForOrderDetails();
		payments = fileInputRunner.getListForPayments();
		productLines = fileInputRunner.getListForProductLines();
		products = fileInputRunner.getListForProducts();
		
		totalList = new TotalList();
		totalList.addCustomersList(customers);
		totalList.addEmployeesList(employees);
		totalList.addOrdersList(orders);
		totalList.addOfficesList(offices);
		totalList.addOrderDetailsList(orderDetails);
		totalList.addPaymentsList(payments);
		totalList.addProductLinesList(productLines);
		totalList.addProductsList(products);
		
		fileSerializer = new FileSerializer(totalList);
		fileDeserializer = new FileDeserializer();

		try {
			outputStream = new FileOutputStream(filePathForOrders, true);
		} catch (FileNotFoundException e) {
			throw new FileParsingException("Driver, setup, fileNotFoundException"+e.getMessage());
		}
        try {
			writer = new OutputStreamWriter(outputStream, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new FileParsingException("Driver, setup, UnsupportedEncodingException"+e.getMessage());
		} 

	}
	
	public static void main(String[] args)
	{
			try {
				Driver.setUp();
			} catch (FileParsingException e1) {
				System.out.println("FileParsingException in Main method, calling Driver.setUo()\n"+e1.getMessage());
			}
		
			System.out.println("\nWhat would you like to do:");
			System.out.println("1. load data file into the application");
			System.out.println("2. load a previous session from a serialized file");
			System.out.println("3. save the current session to a serialized file");
			System.out.println("4. add a new Order Record");
			System.out.println("5. view all Customers");
			System.out.println("6. view all Employees");
			System.out.println("7. view all Orders by Customer Number");
			System.out.println("8. view all Offices");
			System.out.println("9. view all Order Details");
			System.out.println("10. view all Payments");
			System.out.println("11. view all Product Lines");
			System.out.println("12. view all Products");
			
			userInput = scanner.next();
			
				switch (userInput) {
				case "1":
						{
							try {
								FileLoader.loadFile();
							} catch (FileParsingException e) {
								System.out.println("FileParsingException in driver class, Case1\n"+e.getMessage());
							} catch (IOException e) {
								System.out.println("IOException in driver class, Case1\n"+e.getMessage());
							}
						}
						break;
				case "2":
						{
							System.out.println("\nEnter Path to load the serialized file\n");
							filePathForDeserialization = scanner.next();
							try {
								fileDeserializer.getDataByDeserializingFileAtPath(filePathForDeserialization);
							} catch (FileParsingException e) {
								System.out.println("FileParsingException in driver class, case2\n"+e.getMessage());
							}
							String[] arguments = new String[] {"123"};
						    Driver.main(arguments);
						}
						break;
				case "3":
						{
							System.out.println("\nEnter Path to save the serialized file\n");
							filePathForSerialization = scanner.next();
							try {
								fileSerializer.saveTotalListTo(filePathForSerialization);
							} catch (FileParsingException e) {
								System.out.println("FileParsingException in driver class, case3\n"+e.getMessage());
							}
							String[] arguments = new String[] {"123"};
						    Driver.main(arguments);
						}
						break;
				case "4":
						{
							System.out.println("To add new Order record\nEnter order number,order date, required date, shipped date, status, comments, customer number\n ");
							String[] valuesForNewOrder = new String[7];
							try{
									writer.write("\r\n");
								    for (int i = 0; i < valuesForNewOrder.length; i++)
								    {
								        valuesForNewOrder[i] = scanner.next();
								        writer.write(valuesForNewOrder[i]+",");
									}
								    writer.close();
								    System.out.println("New Order record added\n");
						            for (Orders ord : orders) {
										System.out.println(ord.toString());	
									}
							}
							catch (IOException e)
							{
								System.out.println("IOException in driver class, case4\n"+e.getMessage());
							}
				            
							String[] arguments = new String[] {"123"};
						    Driver.main(arguments);
							
						}
						break;
				case "5":
						{
							for (Customers cust : customers) {
								System.out.println(cust.toString());	
							}
							String[] arguments = new String[] {"123"};
						    Driver.main(arguments);
						}
						break;
				case "6":
				{
					for (Employees emp : employees) {
						System.out.println(emp.toString());	
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "7":
				{
					System.out.println("Enter the Customer number you wish to see details\n");
					userInput= scanner.next();
					int countOfResult=0;
					try{
						for(Orders order:orders)
						{
								if(order.getCustomerNumber().equals(Integer.valueOf(userInput)))
								{
									countOfResult++;
									System.out.println(order);
								}
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("some comparision problem\n"+e.getMessage());
					}
					if(countOfResult==0)
					{
						System.out.println("No customer with that number");
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "8":
				{
					for (Offices off : offices) {
						System.out.println(off.toString());	
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "9":
				{
					orderDetails = fileInputRunner.getListForOrderDetails();
					for (OrderDetails od : orderDetails) {
						System.out.println(od.toString());	
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "10":
				{
					payments = fileInputRunner.getListForPayments();
					for (Payments pay : payments) {
						System.out.println(pay.toString());	
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "11":
				{
					productLines = fileInputRunner.getListForProductLines();
					for (ProductLines pl : productLines) {
						System.out.println(pl.toString());	
					}
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				case "12":
				{
					for (Products prod : products) {
						System.out.println(prod.toString());	
					}
					System.out.println("\nPrinitng orders");
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				}break;
				default:
				{
					System.out.println("Sorry, Invalid Entry");
					String[] arguments = new String[] {"123"};
				    Driver.main(arguments);
				    scanner.close();
				}break;			
			}
				
	}

}
