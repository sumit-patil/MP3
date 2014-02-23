package com.iit.mp2.fileio;

import java.util.ArrayList;
import java.util.List;

import com.iit.mp2.data.FileParser;
import com.iit.mp2.domain.*;
import com.iit.mp2.exception.FileParsingException;
/*
 * This file is used for multithreading. It executes the parsing and loading of the data files in the run method
 */

public class FileInputRunner implements Runnable {

	private List<Customers> customers;
	private List<Employees> employees;
	private List<Orders> orders;
	private String filePathForCustomers;
	private String filePathForEmployees;
	private String filePathForOrders;
		
	private List<Offices> offices;
	private List<OrderDetails> orderDetails;
	private List<Payments> payments;
	private List<ProductLines> productLines;
	private List<Products> products;
	private String filePathForOffices;
	private String filePathForOrderDetails;
	private String filePathForPayments;
	private String filePathForProductLines;
	private String filePathForProducts;
	
	private FileParser fileParser;
	
	public FileInputRunner(String filePathForCustomers, String filePathForEmployees, String filePathForOrders,
			String filePathForOffices,
			String filePathForOrderDetails,
			String filePathForPayments,
			String filePathForProductLines,
			String filePathForProducts)
	{
		this.customers = new ArrayList<>();
		this.employees = new ArrayList<>();
		this.orders = new ArrayList<>();
		this.offices = new ArrayList<>();
		this.orderDetails = new ArrayList<>();
		this.payments = new ArrayList<>();
		this.productLines = new ArrayList<>();
		this.products = new ArrayList<>();
		
		this.fileParser = new FileParser();
		this.filePathForCustomers = filePathForCustomers;
		this.filePathForEmployees = filePathForEmployees;
		this.filePathForOrders = filePathForOrders;
		this.filePathForOffices =filePathForOffices;
		this.filePathForOrderDetails=filePathForOrderDetails;
		this.filePathForPayments=filePathForPayments;
		this.filePathForProductLines=filePathForProductLines;
		this.filePathForProducts=filePathForProducts;
	}

	@Override
	public void run(){
		try {
			
			getListForCustomers().addAll(fileParser.getCustomersFromTextFile(filePathForCustomers));
			getListForEmployees().addAll(fileParser.getEmployeesFromTextFile(filePathForEmployees));
			getListForOrders().addAll(fileParser.getOrdersFromTextFile(filePathForOrders));
			getListForOffices().addAll(fileParser.getOfficesFromTextFile(filePathForOffices));
			getListForOrderDetails().addAll(fileParser.getOrderDetailsFromTextFile(filePathForOrderDetails));
			getListForPayments().addAll(fileParser.getPaymentsFromTextFile(filePathForPayments));
			getListForProductLines().addAll(fileParser.getProductLinesFromTextFile(filePathForProductLines));
			getListForProducts().addAll(fileParser.getProductsFromTextFile(filePathForProducts));
			
		} 
		catch (FileParsingException e) {
			//throw new FileParsingException("Some file parsing exception occured in run method of FileInputRunner"+ e.getMessage());
			System.out.println("Some file parsing exception occured in run method of FileInputRunner");
		}
	}

	public synchronized List<Customers> getListForCustomers() {
		return this.customers;
	}
	
	public synchronized List<Employees> getListForEmployees() {
		return this.employees;
	}
	
	public synchronized List<Orders> getListForOrders() {
		return this.orders;
	}

	public synchronized List<Offices> getListForOffices() {
		return this.offices;
	}
	
	public synchronized List<OrderDetails> getListForOrderDetails() {
		return this.orderDetails;
	}
	
	public synchronized List<Payments> getListForPayments() {
		return this.payments;
	}
	public synchronized List<ProductLines> getListForProductLines() {
		return this.productLines;
	}
	
	public synchronized List<Products> getListForProducts() {
		return this.products;
	}
	
}
