package com.iit.mp2.test.domain;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iit.mp2.data.FileParser;
import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Offices;
import com.iit.mp2.domain.OrderDetails;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.domain.Payments;
import com.iit.mp2.domain.ProductLines;
import com.iit.mp2.domain.Products;
import com.iit.mp2.exception.FileParsingException;

public class FileParserTest {

	private String filePathForCustomers;
	private String filePathForEmployees;
	private String filePathForOrders;
	private String wrongFilePath;
	private FileParser parser;
	
	private String filePathForOffices;
	private String filePathForOrderDetails;
	private String filePathForPayments;
	private String filePathForProductLines;
	private String filePathForProducts;
	
	@Before
	public void setup(){
		filePathForCustomers = getClass().getResource("/data/Customers.txt").getPath();
		filePathForEmployees = getClass().getResource("/data/Employees.txt").getPath();
		filePathForOrders = getClass().getResource("/data/Orders.txt").getPath();
		wrongFilePath = getClass().getResource("/data/WrongTestFile.txt").getPath();
		filePathForOffices = getClass().getResource("/data/Offices.txt").getPath();
		filePathForOrderDetails = getClass().getResource("/data/OrderDetails.txt").getPath();
		filePathForPayments = getClass().getResource("/data/Payments.txt").getPath();
		filePathForProductLines = getClass().getResource("/data/ProductLines.txt").getPath();
		filePathForProducts = getClass().getResource("/data/Products.txt").getPath();
		parser= new FileParser();
	}
	
	@Test
	public void testGetCustomersFromTextFile() throws FileParsingException, ParseException, IOException{
		List<Customers> customers = parser.getCustomersFromTextFile(filePathForCustomers);
		assertTrue(customers.size()>0);
		assertEquals(new Integer(103),customers.get(0).getCustomerNumber());
	}
	
	@Test(expected = NumberFormatException.class)
	public void throwExceptionForWrongFilePath() throws FileParsingException, ParseException, IOException{
		parser.getCustomersFromTextFile(wrongFilePath);
	}
	
	@Test(expected = FileParsingException.class)
	public void throwExceptionForWrongFilePathAnother() throws FileParsingException,FileNotFoundException, ParseException, IOException, NumberFormatException{
		parser.getCustomersFromTextFile(wrongFilePath + "/junkPath");
	}
	
	@Test
	public void testGetEmployeesFromTextFile() throws FileParsingException, ParseException, IOException, NumberFormatException{
		List<Employees> employees = parser.getEmployeesFromTextFile(filePathForEmployees);
		assertTrue(employees.size()>0);
		assertEquals(new Integer(1002),employees.get(0).getEmployeeNumber());
	}
	
	@Test
	public void testGeOrdersFromTextFile() throws FileParsingException, ParseException, IOException{
		List<Orders> orders = parser.getOrdersFromTextFile(filePathForOrders);
		assertTrue(orders.size()>0);
		assertEquals(new Integer(363),orders.get(0).getCustomerNumber());
		for(Orders Ord: orders)
		{
			System.out.println(Ord);
		}
	}
	
	@Test
	public void testGetOfficesFromTextFile() throws FileParsingException, ParseException, IOException{
		List<Offices> offices = parser.getOfficesFromTextFile(filePathForOffices);
		assertTrue(offices.size()>0);
		for(Offices off: offices)
		{
			System.out.println(off);
		}
	}
	
	@Test
	public void testGetOrderDetailsFromTextFile() throws FileParsingException, ParseException, IOException{
		List<OrderDetails> orderdetails = parser.getOrderDetailsFromTextFile(filePathForOrderDetails);
		assertTrue(orderdetails.size()>0);
		for(OrderDetails od: orderdetails)
		{
			System.out.println(od);
		}
	}
	
	@Test
	public void testGetPaymentsFromTextFile() throws FileParsingException, ParseException, IOException{
		List<Payments> payments = parser.getPaymentsFromTextFile(filePathForPayments);
		assertTrue(payments.size()>0);
		for(Payments pay: payments)
		{
			System.out.println(pay);
		}
	}
	
	@Test
	public void testGetProductLinesFromTextFile() throws FileParsingException, ParseException, IOException{
		List<ProductLines> productLines = parser.getProductLinesFromTextFile(filePathForProductLines);
		assertTrue(productLines.size()>0);
		for(ProductLines pl: productLines)
		{
			System.out.println(pl);
		}
	}
	
	@Test
	public void testGetProductsFromTextFile() throws FileParsingException, ParseException, IOException{
		List<Products> products = parser.getProductsFromTextFile(filePathForProducts);
		assertTrue(products.size()>0);
		for(Products p: products)
		{
			System.out.println(p);
		}
	}
}
	
