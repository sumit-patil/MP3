package com.iit.mp2.fileio;
/*
 * This file Deserializes the data from serialized file.
 * User need to provide file path of the serialized file. 
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Offices;
import com.iit.mp2.domain.OrderDetails;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.domain.Payments;
import com.iit.mp2.domain.ProductLines;
import com.iit.mp2.domain.Products;
import com.iit.mp2.exception.FileParsingException;

public class FileDeserializer {

	private TotalList totalList;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;

	public TotalList  getDataByDeserializingFileAtPath(String serializationFilePath) throws FileParsingException {
		this.totalList = new TotalList();
		
		try {
			this.fileInputStream = new FileInputStream(serializationFilePath);
			this.objectInputStream = new ObjectInputStream(fileInputStream);
			this.totalList=(TotalList)objectInputStream.readObject();
			this.objectInputStream.close();
			
			System.out.println("Total Object Deserialization done!\n");
			
			for(Customers customer: this.totalList.getCustomersList())
			{
				System.out.println(customer);
			}
			for(Employees employees: this.totalList.getEmployeesList())
			{
				System.out.println(employees);
			}
			for(Orders orders: this.totalList.getOrdersList())
			{
				System.out.println(orders);
			}
			for(Offices offices: this.totalList.getOfficesList())
			{
				System.out.println(offices);
			}
			for(ProductLines productLines: this.totalList.getProductLinesList())
			{
				System.out.println(productLines);
			}
			for(Payments payments: this.totalList.getPaymentsList())
			{
				System.out.println(payments);
			}
			for(Products products: this.totalList.getProductList())
			{
				System.out.println(products);
			}
			for(OrderDetails orderDetailsList: this.totalList.getOrderDetailsList())
			{
				System.out.println(orderDetailsList);
			}
			
		} catch (IOException e) {
			//throw new FileParsingException("problem reading serializationFilePath, IOException\n");
			System.out.println("problem reading serializationFilePath, IOException\n"+e.getMessage());
		}
		catch (ClassNotFoundException e) {
			//throw new FileParsingException("problem reading serializationFilePath, ClassNotFoundException\n");
			System.out.println("problem reading serializationFilePath, ClassNotFoundException\n"+e.getMessage());
		}

		return this.totalList;
	}

}
