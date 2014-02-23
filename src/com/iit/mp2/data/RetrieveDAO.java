package com.iit.mp2.data;
/*
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.iit.mp2.domain.Customers;
import com.iit.mp2.exception.FileParsingException;
*/

public class RetrieveDAO {
	
	
	//private String dbUrl;
	//private String username;
	//private String password;
	/*private Connection conn = null;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;*/
    //public static String query = null;
	
	/*public RetrieveDAO(String dbUrl, String username, String password) {
		super();
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}
	*/
	
	/*public List<Customers> getCustomersFromDB(String filePath) throws FileParsingException 
	{
		
		List<Customers> customers = new ArrayList<>();
		try {
			conn = MySQLDBConnection.getInstance(dbUrl,username,password);	            
			statement = conn.createStatement();
			resultSet = statement.executeQuery("Select * from customers");
			//resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				Customers customer = new Customers(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11),
						resultSet.getInt(12),
						resultSet.getDouble(13)
						);
				customers.add(customer);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} 
		catch (IOException e) {
			//throw new FileParsingException("There was a problem parsing customer data file\n"+e.getMessage());
			System.out.println("There was a IOException, parsing customer data file\n"+e.getMessage());
		}

		return customers;
	
	}
	*/
}
