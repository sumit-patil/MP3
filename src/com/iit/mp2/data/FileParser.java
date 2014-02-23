package com.iit.mp2.data;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.domain.Employees;
import com.iit.mp2.domain.Offices;
import com.iit.mp2.domain.OrderDetails;
import com.iit.mp2.domain.Orders;
import com.iit.mp2.domain.Payments;
import com.iit.mp2.domain.ProductLines;
import com.iit.mp2.domain.Products;
import com.iit.mp2.exception.FileParsingException;
/*
 * 
 * This file parses the all the data file using googles open CSVReader
 * It contains 8 methods for extracting respective list from data files
 * 
 */
public class FileParser {
	private CSVReader reader = null;
	private String[] values = null;
	
	public List<Customers> getCustomersFromTextFile(String filePath) throws FileParsingException 
	{		
		List<Customers> customers = new ArrayList<>();
		try {
			reader = new CSVReader(new FileReader(filePath));	            
			values = reader.readNext();
			while ( values != null ) 
			{
				customers.add(new Customers(values));
				values = reader.readNext();
			}
		} 
		catch (IOException e) {
			//throw new FileParsingException("There was a problem parsing customer data file\n"+e.getMessage());
			System.out.println("There was a IOException, parsing customer data file\n"+e.getMessage());
		}

		return customers;
	}
	
	public List<Employees> getEmployeesFromTextFile(String filePath) throws FileParsingException 
	{
		List<Employees> employees = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                 
			values = reader.readNext();
			while ( values != null ) 
			{
				employees.add(new Employees(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException e){
			//throw new FileParsingException("There was a problem parsing employee data file (IOException|NumberFormatException|NullPointerException)\n"+e.getMessage());
			System.out.println("There was a problem parsing employee data file (IOException|NumberFormatException|NullPointerException)\n"+e.getMessage());
		}
		finally {
			try {
				reader.close();
			} 
			catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The Employees file does not exist\n"+e.getMessage());
				System.out.println("The Employees file does not exist\n"+e.getMessage());
			}
		}
		return employees;
	}

	public List<Orders> getOrdersFromTextFile(String filePath) throws FileParsingException 
	{
		List<Orders> orders = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				orders.add(new Orders(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|ParseException |NullPointerException e) 
		{
			//throw new FileParsingException("IOException occured in getOrderFromFileText");
			System.out.println("IOException occured in getOrderFromFileText"+e.getMessage());
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The Orders file does not exist\n");
				System.out.println("The Orders file does not exist\n");
			}
		}
		return orders;
	}
	
	public List<Offices> getOfficesFromTextFile(String filePath) throws FileParsingException 
	{
		List<Offices> offices = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				offices.add(new Offices(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException e) 
		{
			//throw new FileParsingException("IOException occured in getOfficesFromFileText");
			System.out.println("IOException occured in getOfficesFromFileText");
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The Offices file does not exist\n");
				System.out.println("IOException occured in getOfficesFromFileText");
			}
		}
		return offices;
	}
	
	public List<OrderDetails> getOrderDetailsFromTextFile(String filePath) throws FileParsingException 
	{
		List<OrderDetails> orderdetails = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				orderdetails.add(new OrderDetails(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException e) 
		{
			//throw new FileParsingException("IOException occured in getOrderDetailsFromFileText");
			System.out.println("IOException occured in getOrderDetailsFromFileText\n"+e.getMessage());
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The OrderDetails file does not exist\n");
				System.out.println("The OrderDetails file does not exist\n"+e.getMessage());
			}
		}
		return orderdetails;
	}
	
	public List<Payments> getPaymentsFromTextFile(String filePath) throws FileParsingException//, ParseException, IOException 
	{
		List<Payments> payments = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				payments.add(new Payments(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException|ParseException e) 
		{
			//throw new FileParsingException("IOException occured in getPaymentsFromFileText");
			System.out.println("IOException occured in getPaymentsFromFileText"+e.getMessage());
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The Payments file does not exist\n");
				System.out.println("The Payments file does not exist\n"+e.getMessage());
			}
		}
		return payments;
	}
	
	
	public List<ProductLines> getProductLinesFromTextFile(String filePath) throws FileParsingException//, ParseException, IOException 
	{
		List<ProductLines> productLines = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				productLines.add(new ProductLines(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException e) 
		{
			//throw new FileParsingException("IOException occured in getProductLinesFromFileText");
			System.out.println("IOException occured in getProductLinesFromFileText"+e.getMessage());
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The ProductLines file does not exist\n");
				System.out.println("The ProductLines file does not exist\n"+e.getMessage());
			}
		}
		return productLines;
	}
	
	public List<Products> getProductsFromTextFile(String filePath) throws FileParsingException//, ParseException, IOException 
	{
		List<Products> products = new ArrayList<>();	
		try {
			reader = new CSVReader(new FileReader(filePath));                  
			values = reader.readNext();
			while ( values != null ) 
			{
				products.add(new Products(values));
				values = reader.readNext();
			}
		} 
		catch (IOException|NumberFormatException|NullPointerException e) 
		{
			//throw new FileParsingException("IOException occured in getProductsFromFileText");
			System.out.println("IOException occured in getProductsFromFileText"+e.getMessage());
		} 
		finally 
		{
			try {
				reader.close();
			} catch (IOException | NullPointerException e) {
				//throw new FileParsingException("The Products file does not exist\n");
				System.out.println("The Products file does not exist\n"+e.getMessage());
			}
		}
		return products;
	}
}