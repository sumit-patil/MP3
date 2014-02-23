package com.iit.mp2.test.fileio;

import org.junit.Before;
import org.junit.Test;

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
import com.iit.mp2.fileio.TotalList;


public class FileDeserializerTest {
	
	private FileDeserializer fileDeserializer;
	private String serializationFilePath;
	private TotalList totalList;
	
	@Before
	public void setup() throws FileParsingException{
		try {
			this.serializationFilePath = getClass().getResource("/data/sumit1_45.ser").getPath();
		} catch (NullPointerException e) {
			//throw new FileParsingException(" FileNotFound at specified location");
			System.out.println("FileNotFound at specified location\n"+ e.getMessage());
		}
		this.totalList = new TotalList();
	}
	
	@Test
	public void testGetDataFromSerializedFileAtPath() throws FileParsingException {
		
		fileDeserializer = new FileDeserializer();
		this.totalList=fileDeserializer.getDataByDeserializingFileAtPath(serializationFilePath);
		
		for(Customers cust: this.totalList.getCustomersList())
		{
			System.out.println(cust);
		}
		for(Employees cust: this.totalList.getEmployeesList())
		{
			System.out.println(cust);
		}
		for(Orders cust: this.totalList.getOrdersList())
		{
			System.out.println(cust);
		}
		for(Offices cust: this.totalList.getOfficesList())
		{
			System.out.println(cust);
		}
		for(ProductLines cust: this.totalList.getProductLinesList())
		{
			System.out.println(cust);
		}
		for(Payments cust: this.totalList.getPaymentsList())
		{
			System.out.println(cust);
		}
		for(Products products: this.totalList.getProductList())
		{
			System.out.println(products);
		}
		for(OrderDetails orderDetailsList: this.totalList.getOrderDetailsList())
		{
			System.out.println(orderDetailsList);
		}
		
	}

}
