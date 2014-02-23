package com.iit.mp2.driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iit.mp2.data.FileParser;
import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.exception.FileParsingException;
/*
 * This is the FileLoader class. It handles the event details when user selects very first option in the main menu
 * 
 */
public class FileLoader {
	static String filePath = null;
	static Scanner scanner = new Scanner(System.in);
	static String userInput = null;
	static List<Customers> customers;
	static List<Employees> employees;
	static List<Orders> orders;
	static FileParser fileParser;
	
	public static void loadFile() throws FileParsingException, IOException
	{
		System.out.println("Which file would you like to load:");
		System.out.println("1. Customer File");
		System.out.println("2. Employee File");
		System.out.println("3. Order File");
		userInput = scanner.next();
		System.out.println(userInput);
		
		customers = new ArrayList<>();
		employees = new ArrayList<>();
		orders = new ArrayList<>();
		fileParser = new FileParser();
		
		switch (userInput) {
		case "1":
			{
				System.out.println("Please enter the file path to Customers file\n");
				filePath = scanner.next();
				try {
					customers= fileParser.getCustomersFromTextFile(filePath);
				} catch (FileParsingException e) {
					System.out.println("There was a problem parsing customer data file (FileParsingException)\n"+e.getMessage());
				}
				if (customers.size()>0) {
					System.out.println("Customers data loaded successfully\n");
					for(Customers cust: customers)
					{
						System.out.println(cust);
					}
					
				}
				else{
					System.out.println("Sorry! There was a problem loading cusotmers\n");}
				String[] arguments = new String[] {"123"};
				Driver.main(arguments);
			    
				
			}break;
		case "2":
			{
				System.out.println("Please enter the file path to Employees file\n");
				filePath = scanner.next();
				try {
					employees= fileParser.getEmployeesFromTextFile(filePath);
				} catch (FileParsingException e) {
					System.out.println("There was a problem parsing employees data file (FileParsingException)\n"+e.getMessage());
				}
				if (employees.size()>0) {
					System.out.println("Employees data loaded successfully\n");
					for(Employees emp: employees)
					{
						System.out.println(emp);
					}
					
				}
				else{
					System.out.println("Sorry! There was a problem loading Employees");}
				String[] arguments = new String[] {"123"};
				Driver.main(arguments);
			    
				
			}break;
		case "3":
			{
				System.out.println("Please enter the file path to Orders file\n");
				filePath = scanner.next();
				try {
					orders= fileParser.getOrdersFromTextFile(filePath);
				} catch (FileParsingException e) {
					System.out.println("There was a problem parsing employees data file (ParseException)"+e.getMessage());
				}
				if (orders.size()>0) {
					System.out.println("Orders data loaded successfully\n");	
					for(Orders ord: orders)
					{
						System.out.println(ord);
					}
				}
				else{
					System.out.println("Sorry! There was a problem loading orders\n");}
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
