package com.iit.mp2.driver;

import java.util.List;
import java.util.Scanner;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.exception.DatabaseConnectionException;
import com.iit.mp2.util.Utility;

public class RDEmployeeCustomerRecord {

	private static Scanner scanner;
	private static String userInput;

	public static void userOptionsForEmployees()
	{	
		scanner = new Scanner(System.in);
		System.out.println("1. View Employee by Employee Number");
		System.out.println("2. Delete Employee by Employee Number\n");
		
		userInput = scanner.next();
		Integer employeeNo = Utility.checkInteger(userInput);
		switch (userInput) {
			case "1":
			{
				System.out.println("Enter the Employee Number to view details\n");
				userInput = scanner.next();
				employeeNo = Utility.checkInteger(userInput);
				List<Employees> employees =MainDriver.employeesDAO.retieveRecordByEmployeeNumber(employeeNo);
				for (Employees emp : employees) {
					System.out.println(emp.toString());	
				}	
				String[] arguments = new String[] {"123"};
				MainDriver.main(arguments);
			}
			break;
					
			case "2":
			{
				System.out.println("Enter the Employee Number to delete from database\n");
				userInput = scanner.next();
				employeeNo = Utility.checkInteger(userInput);
				MainDriver.employeesDAO.deleteEmployeeFromDatabase(employeeNo);
				String[] arguments = new String[] {"123"};
				MainDriver.main(arguments);
			}
			break;
		}
	}
	
	public static void userOptionsForCustomers() throws DatabaseConnectionException
	{
		scanner = new Scanner(System.in);
		
		System.out.println("1. View Employee by Customer Number");
		System.out.println("2. Delete Employee by Customer Number\n");
		userInput = scanner.next();
		Integer customerNo;
		switch (userInput) {
			case "1":
			{
				System.out.println("Enter the Customer Number to view details\n");
				userInput = scanner.next();
				customerNo = Utility.checkInteger(userInput);
				List<Customers> customers;
				try {
					customers = MainDriver.customersDAO.retieveRecordByCustomerNumber(customerNo);
					for (Customers cust : customers) {
						System.out.println(cust.toString());	
					}
				} catch (DatabaseConnectionException e) {
					throw new DatabaseConnectionException("There was databaseConnectionException occured in retrieving customer details by ID");
				}
					
				String[] arguments = new String[] {"123"};
				MainDriver.main(arguments);
			}
			break;
					
			case "2":
			{
				System.out.println("Enter the Customer Number to delete from database\n");
				userInput = scanner.next();
				customerNo = Utility.checkInteger(userInput);
				try {
					MainDriver.customersDAO.deleteCustomerFromDatabase(customerNo);
				} catch (DatabaseConnectionException e) {
					throw new DatabaseConnectionException("There was databaseConnectionException in customer occured during delete");
				}
				String[] arguments = new String[] {"123"};
				MainDriver.main(arguments);
			}
			break;
			
			default:
			{
				System.out.println("Sorry, Invalid Entry");
				String[] arguments = new String[] {"123"};
			    MainDriver.main(arguments);
			    scanner.close();
			}break;		
		}
	}
}
