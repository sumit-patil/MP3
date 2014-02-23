package com.iit.mp2.test.fileio;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iit.mp2.domain.*;
import com.iit.mp2.fileio.FileInputRunner;

public class FileInputRunnerTest {

	private String filePathForCustomers;
	private String filePathForEmployees;
	private String filePathForOrders;
	private String filePathForOffices;
	private String filePathForOrderDetails;
	private String filePathForPayments;
	private String filePathForProductLines;
	private String filePathForProducts;
	
	private FileInputRunner fileInputRunner;
	
	@Before
	public void setup(){
		this.filePathForCustomers = getClass().getResource("/data/Customers.txt").getPath();
		this.filePathForEmployees = getClass().getResource("/data/Employees.txt").getPath();
		this.filePathForOrders = getClass().getResource("/data/Orders.txt").getPath();
		this.filePathForOffices = getClass().getResource("/data/Offices.txt").getPath();
		this.filePathForOrderDetails = getClass().getResource("/data/OrderDetails.txt").getPath();
		this.filePathForPayments = getClass().getResource("/data/Payments.txt").getPath();
		this.filePathForProductLines = getClass().getResource("/data/ProductLines.txt").getPath();
		this.filePathForProducts = getClass().getResource("/data/Products.txt").getPath();
	
		this.fileInputRunner = new FileInputRunner(this.filePathForCustomers, this.filePathForEmployees, this.filePathForOrders, this.filePathForOffices,
				this.filePathForOrderDetails, this.filePathForPayments, this.filePathForProductLines, this.filePathForProducts);
		this.fileInputRunner.run();
	}
	
	@Test
	public void testLoadCustomerFile() {
		List<Customers> customers = fileInputRunner.getListForCustomers();
		assertTrue(customers.size()>0);
		System.out.println("customers data thread: "+customers);
	}
	
	@Test
	public void testLoadEmployeeFile(){
		List<Employees> employees = fileInputRunner.getListForEmployees();
		assertTrue(employees.size()>0);
		System.out.println("Employees data thread: "+employees);
	}
	
	@Test
	public void testLoadOrdersFile(){
		List<Orders> orders = fileInputRunner.getListForOrders();
		assertTrue(orders.size()>0);
		System.out.println("Orders data thread: "+orders);
	}
	
	@Test
	public void testLoadOfficesFile(){
		List<Offices> offices = fileInputRunner.getListForOffices();
		assertTrue(offices.size()>0);
		System.out.println("Offices data in thread: "+offices);
	}
	
	@Test
	public void testLoadOrderDetailsFile(){
		List<OrderDetails> orderDetails = fileInputRunner.getListForOrderDetails();
		assertTrue(orderDetails.size()>0);
		System.out.println("OrderDetails data thread: "+orderDetails);
	}
	
	@Test
	public void testLoadPaymentsFile(){
		List<Payments> payments = fileInputRunner.getListForPayments();
		assertTrue(payments.size()>0);
		System.out.println("Payments data thread: "+payments);
	}
	
	@Test
	public void testLoadProductLinesFile(){
		List<ProductLines> productLines = fileInputRunner.getListForProductLines();
		assertTrue(productLines.size()>0);
		System.out.println("ProductLines data thread: "+productLines);
	}
	
	@Test
	public void testLoadProductsFile(){
		List<Products> products = fileInputRunner.getListForProducts();
		assertTrue(products.size()>0);
		System.out.println("Products data thread: "+products);
	}
}
