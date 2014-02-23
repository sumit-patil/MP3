package com.iit.mp2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iit.mp2.Abstract.RetrieveAbstract;
import com.iit.mp2.data.MySQLDBConnection;
import com.iit.mp2.domain.Customers;
import com.iit.mp2.exception.DatabaseConnectionException;


public class CustomersDAO {

	private String dbUrl;
	private String username;
	private String password;
	
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    public static String query = null;
	
	public CustomersDAO(String dbUrl, String username, String password) {
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}

	public List<Customers> getAllCustomersfromDatabase() throws DatabaseConnectionException {
		List<Customers> customers = new ArrayList<Customers>();
		try {
			String selectQuery = "Select * from customers";
			RetrieveAbstract crudAbstract = new RetrieveAbstract(this.dbUrl,this.username,this.password);
			resultSet = crudAbstract.retrieveRecords(selectQuery);
			while (resultSet.next()) {
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
		} 
		catch (SQLException e) {
			throw new DatabaseConnectionException("There was a problem parsing customer data file\n"+e.getMessage());
		}

		return customers;
	}

	public void insertCustomerIntoDatabase(
			Integer customerNumber,
			String customerName,
			String contactLastName,
			String contactFirstName,
			String phone,
			String addressLine1,
			String addressLine2,
			String city,
			String state,
			String postalCode,
			String country,
			Integer salesRepEmployeeNumber,
			Double creditLimit) throws DatabaseConnectionException 
		{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String insertQuery= "Insert into Customers values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			statement = conn.createStatement();
			preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setInt(1,customerNumber);
			preparedStatement.setString(2,customerName);
			preparedStatement.setString(3,contactLastName);
			preparedStatement.setString(4,contactFirstName);
			preparedStatement.setString(5,phone);
			preparedStatement.setString(6,addressLine1);
			preparedStatement.setString(7,addressLine2);
			preparedStatement.setString(8,city);
			preparedStatement.setString(9,state);
			preparedStatement.setString(10,postalCode);
			preparedStatement.setString(11,country);
			preparedStatement.setInt(12,salesRepEmployeeNumber);
			preparedStatement.setDouble(13,creditLimit);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Record is inserted into Customer table!");
		} 

		catch (SQLException e) {
			throw new DatabaseConnectionException("There was a SQLException (INSERT)\n"+e.getMessage());
			//System.out.println("There was a SQLException (INSERT)\n"+e.getMessage());
		}
		finally {
			 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new DatabaseConnectionException("There was a SQLException (INSERT) in closing preparedStatement\n"+e.getMessage());
					//System.out.println("There was a SQLException (INSERT) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
	}

	public void deleteCustomerFromDatabase(Integer customerNumber) throws DatabaseConnectionException 
	{	
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String deleteQuery= "Delete from customers where customerNumber = ?";
		int countReturn =this.retieveRecordByCustomerNumber(customerNumber).size();
		try {
			if (countReturn>0)
			{
			preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, customerNumber);
			preparedStatement.executeUpdate();
			System.out.println("Record is deleted!");
			}
 
		} catch (SQLException e) {
			throw new DatabaseConnectionException("There was a SQLException (DELETE)\n"+e.getMessage());
			//System.out.println("There was a SQLException (DELETE)\n"+e.getMessage()); 
 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new DatabaseConnectionException("There was a SQLException (DELETE) in closing preparedStatement\n"+e.getMessage());
					//System.out.println("There was a SQLException (DELETE) in closing preparedStatement\n"+e.getMessage());
				}
			}
 
		}
	}

	public void updateCustomerRecordInDatabase(Integer customerNumber,
			String customerName) throws DatabaseConnectionException 
	{
		System.out.println(customerNumber);
		System.out.println(customerName);

		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String updateQuery="update customers set customerName=? where customerNumber = ?";
		
		try {
			preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setString(1, customerName);
			preparedStatement.setInt(2, customerNumber);
			preparedStatement.executeUpdate();
 
			System.out.println("Record is Updated!");
 
		} 
		catch (SQLException e) 
		{
			throw new DatabaseConnectionException("There was a SQLException (INSERT)\n"+e.getMessage());
			//System.out.println("There was a SQLException (UPDATE)\n"+e.getMessage()); 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new DatabaseConnectionException("There was a SQLException (INSERT)\n"+e.getMessage());
					//System.out.println("There was a SQLException (UPDATE) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
	}	
	
	public List<Customers> retieveRecordByCustomerNumber(Integer customerNumber) throws DatabaseConnectionException 
	{
		List<Customers> customers = new ArrayList<Customers>();
		try
		{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		statement = conn.createStatement();
		resultSet = statement.executeQuery("Select * from customers where customerNumber="+customerNumber+";");
		while (resultSet.next()) {

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
		if (customers.size()==0)
		{
			System.out.println("No customer with the given ID\n");
		}
		
		//System.out.println(customers.size());
		resultSet.close();
		statement.close();
		//conn.close();
	} 
	catch (SQLException e) {
		throw new DatabaseConnectionException("There was a SQLException (SELECT)\n"+e.getMessage());
		//System.out.println("There was a SQLException (SELECT)\n"+e.getMessage());
	}

	return customers;
	}
}
