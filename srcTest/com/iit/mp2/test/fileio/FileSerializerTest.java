package com.iit.mp2.test.fileio;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iit.mp2.domain.*;
import com.iit.mp2.exception.FileParsingException;
import com.iit.mp2.fileio.FileInputRunner;
import com.iit.mp2.fileio.FileSerializer;
import com.iit.mp2.fileio.TotalList;

public class FileSerializerTest {

	private FileSerializer fileSerializer;
	private String filePathForCustomers;
	private String filePathForEmployees;
	private String filePathForOrders;	
	private String filePathForOffices;
	private String filePathForOrderDetails;
	private String filePathForPayments;
	private String filePathForProductLines;
	private String filePathForProducts;
	private List<Customers> customers;
	private List<Employees> employees;
	private List<Orders> orders;
	private List<Offices> offices;
	private List<OrderDetails> orderDetails;
	private List<Payments> payments;
	private List<ProductLines> productLines;
	private List<Products> products;
	
	private String serializationFilePath;
	private FileInputRunner fileInputRunner;

	@Before
	public void setup() throws FileParsingException, ParseException, IOException
	{
		this.serializationFilePath = getClass().getResource("/data").getPath();
		
		this.filePathForCustomers = getClass().getResource("/data/Customers.txt").getPath();
		this.filePathForEmployees = getClass().getResource("/data/Employees.txt").getPath();
		this.filePathForOrders = getClass().getResource("/data/Orders.txt").getPath();
		this.filePathForOffices = getClass().getResource("/data/Offices.txt").getPath();
		this.filePathForOrderDetails = getClass().getResource("/data/OrderDetails.txt").getPath();
		this.filePathForPayments = getClass().getResource("/data/Payments.txt").getPath();
		this.filePathForProductLines = getClass().getResource("/data/ProductLines.txt").getPath();
		this.filePathForProducts = getClass().getResource("/data/Products.txt").getPath();
		
		this.fileInputRunner = new FileInputRunner(filePathForCustomers, filePathForEmployees, filePathForOrders, filePathForOffices, filePathForOrderDetails, filePathForPayments, filePathForProductLines, filePathForProducts);
		this.fileInputRunner.run();
		
		this.customers = fileInputRunner.getListForCustomers();
		this.employees = fileInputRunner.getListForEmployees();
		this.orders = fileInputRunner.getListForOrders();
		this.offices = fileInputRunner.getListForOffices();
		this.productLines = fileInputRunner.getListForProductLines();
		this.payments = fileInputRunner.getListForPayments();
		this.productLines = fileInputRunner.getListForProductLines();
		this.products = fileInputRunner.getListForProducts();
		this.orderDetails = fileInputRunner.getListForOrderDetails();

	}
	
	@Test
	public void testGetDataFromTextFiles() throws FileParsingException {
		
		TotalList totalList = new TotalList();
		totalList.addCustomersList(customers);
		totalList.addEmployeesList(employees);
		totalList.addOrdersList(orders);
		totalList.addOfficesList(offices);
		totalList.addOrderDetailsList(orderDetails);
		totalList.addPaymentsList(payments);
		totalList.addProductLinesList(productLines);
		totalList.addProductsList(products);
		
		fileSerializer = new FileSerializer(totalList);
		fileSerializer.saveTotalListTo(serializationFilePath+"/sumit1_45.ser");
		
	}

}
