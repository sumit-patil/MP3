package com.iit.mp2.driver;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iit.mp2.DAO.CustomersDAO;
import com.iit.mp2.DAO.EmployeesDAO;
import com.iit.mp2.DAO.OrdersDAO;
import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.exception.DatabaseConnectionException;
import com.iit.mp2.util.Utility;


public class MainDriver {
	
	public static EmployeesDAO employeesDAO;
	public static CustomersDAO customersDAO;
	public static OrdersDAO ordersDAO;
	public static RDEmployeeCustomerRecord rDEmployeeCustomerRecord;
	public static List<Employees> employees = new ArrayList<Employees>();
	public static List<Customers> customers = new ArrayList<Customers>();
	public static List<Orders> orders = new ArrayList<Orders>();
	
	private static java.sql.Timestamp getTimeStampForDate(java.util.Date date) {
		return new java.sql.Timestamp(date.getTime());
	}
	
	public static void main(String[] args) 
	{	
		final String dbUrl ="jdbc:mysql://localhost:3306/MP2";
		final String username = "root";
		final String password = "password";
		
		final Scanner scanner;
		final String userInput;
		
		scanner = new Scanner(System.in);
		
		System.out.println("\nWhat would you like to do:");
		System.out.println("1. Load the Database Data into the application");
		System.out.println("2. Add a new Order File to the Database");
		System.out.println("3. Retrieve (view) or Delete any Employee by PrimaryKey");
		System.out.println("4. Retrieve (view) or Delete any Customer by PrimaryKey");
		System.out.println("5. View all Employees");
		System.out.println("6. View all Customers");
		System.out.println("7. View all Orders\n");
		employeesDAO = new EmployeesDAO(dbUrl, username, password);
		customersDAO = new CustomersDAO(dbUrl, username, password);
		ordersDAO = new OrdersDAO(dbUrl, username, password);
		
		rDEmployeeCustomerRecord= new RDEmployeeCustomerRecord();
		
		userInput = scanner.next();
		
				switch (userInput) {
				case "1":
				{
					 try {
						customers = customersDAO.getAllCustomersfromDatabase();
						employees = employeesDAO.getAllEmployeesFromDatabase();
						orders = ordersDAO.getAllOrdersFromDatabase();
						System.out.println("Database loaded into application successfully !\n");
						
						
						String[] arguments = new String[] {"123"};
						MainDriver.main(arguments);
					} catch (DatabaseConnectionException e) {
						System.out.println("There was a DatabaseConnectionException Case1\n"+e.getMessage());
					}
					
				}break;
		
				case "2":
				{
					System.out.println("To add new Order record\nEnter order number,order date, required date, shipped date, status, comments, customer number");
					System.out.println("Enter date in format 'yyyy-mm-dd'\n");
					String[] valuesForNewOrder = new String[7];
				    for (int i = 0; i < valuesForNewOrder.length; i++)
				    {
				        valuesForNewOrder[i] = scanner.next();
					}
					try {
						ordersDAO.insertOrderIntoDatabase(
								Utility.checkInteger(valuesForNewOrder[0]),
								getTimeStampForDate(Utility.getDateFromString(valuesForNewOrder[1])),
								getTimeStampForDate(Utility.getDateFromString(valuesForNewOrder[2])),
								getTimeStampForDate(Utility.getDateFromString(valuesForNewOrder[3])),
								valuesForNewOrder[4],
								valuesForNewOrder[5],
								Utility.checkInteger(valuesForNewOrder[6]));
					} catch (ParseException e) {
						System.out.println("Some ParseException Occured during Order record Insert !!");
					}
					orders = ordersDAO.getAllOrdersFromDatabase();
					String[] arguments = new String[] {"123"};
					MainDriver.main(arguments);	
				}break;
				
				case "3":
				{
					RDEmployeeCustomerRecord.userOptionsForEmployees();					
				}break;
				
				case "4":
				{
					try {
						RDEmployeeCustomerRecord.userOptionsForCustomers();
					} catch (DatabaseConnectionException e) {
						System.out.println("Some databaseConnectionException occured in case4");
					}
				}break;
				
				case "5":
				{
					if(employees.size()==0)
					{
						System.out.println("First you will have to load the database into the application\n");
					}
					else
					{
						for (Employees emp : employees) {
						System.out.println(emp.toString());	
						}
					}
					String[] arguments = new String[] {"123"};
					MainDriver.main(arguments);
				}
				break;
				
				case "6":
				{
					if(customers.size()==0)
					{
						System.out.println("First you will have to load the database into the application\n");
					}
					else
					{
						for (Customers cust : customers) {
							System.out.println(cust.toString());	
						}
					}
					String[] arguments = new String[] {"123"};
					MainDriver.main(arguments);
				}break;
				
				case "7":
				{
					if(orders.size()==0){
						System.out.println("First you will have to load the database into the application\n");
					}
					else
					{
						for (Orders ord : orders) {
							System.out.println(ord.toString());	
						}
					}
					String[] arguments = new String[] {"123"};
					MainDriver.main(arguments);
				}break;
				
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
