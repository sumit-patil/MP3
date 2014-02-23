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
import com.iit.mp2.domain.Employees;

public class EmployeesDAO {

	private String dbUrl;
	private String username;
	private String password;
	
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    public static String query = null;
	
	public EmployeesDAO(String dbUrl, String username, String password)
	{	
		this.dbUrl=dbUrl;
		this.username=username;
		this.password=password;
	}
	
	public List<Employees> getAllEmployeesFromDatabase() 
	{
		List<Employees> employees = new ArrayList<Employees>();
		try {
			String selectQuery = "Select * from employees";
			RetrieveAbstract crudAbstract = new RetrieveAbstract(this.dbUrl,this.username,this.password);
			resultSet = crudAbstract.retrieveRecords(selectQuery);
			
			//conn = MySQLDBConnection.getInstance(this.dbUrl, this.username, this.password);
			//statement = conn.createStatement();
			//resultSet = statement.executeQuery("Select * from employees");
			while (resultSet.next()) {
				Employees employee = new Employees(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getString(8)
						);
				employees.add(employee);
			}
			resultSet.close();
			//statement.close();
			//conn.close();
		} 
		catch (SQLException e) {
			//throw new FileParsingException("There was a problem parsing customer data file\n"+e.getMessage());
			System.out.println("There was a SQLException (Employees SELECT)\n"+e.getMessage());
		}
		return employees;
	}

	public void insertEmployeeIntoDatabase(Integer employeeNumber,
			String lastName, String firstName, String extension, String email,
			String officeCode, Integer reportsTo, String jobTitle) 
	{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String insertQuery= "Insert into Employees values (?,?,?,?,?,?,?,?)";
		try {
			statement = conn.createStatement();
			preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setInt(1,employeeNumber);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,firstName);
			preparedStatement.setString(4,extension);
			preparedStatement.setString(5,email);
			preparedStatement.setString(6,officeCode);
			preparedStatement.setInt(7,reportsTo);
			preparedStatement.setString(8,jobTitle);
			preparedStatement.executeUpdate(); 
			System.out.println("Record is inserted into Employees table!");
		} 
		catch (SQLException e) {
			System.out.println("There was a SQLException (Employees INSERT)\n"+e.getMessage());
		}
		finally {	 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("There was a SQLException (Employees INSERT) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
	}

	public void deleteEmployeeFromDatabase(Integer employeeNumber) 
	{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String deleteQuery= "delete from employees where employeeNumber = ?";
		int countReturn =this.retieveRecordByEmployeeNumber(employeeNumber).size();
		try{
			if (countReturn>0)
				{
				preparedStatement = conn.prepareStatement(deleteQuery);
				preparedStatement.setInt(1, employeeNumber);
				preparedStatement.executeUpdate();
				System.out.println("Record is deleted!");
				}
		} catch (SQLException e) {
			System.out.println("There was a SQLException (DELETE)\n"+e.getMessage());  
		}
		finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("There was a SQLException (DELETE) in closing preparedStatement\n"+e.getMessage());
				}
			}
 
		}
	
	}

	public void updateEmployeeRecordInDatabase(Integer employeeNumber,
			String firstName) 
	{
		
		System.out.println(employeeNumber);
		System.out.println(firstName);

		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String updateQuery="update employees set firstName=? where employeeNumber = ?";
		
		try {
			preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setString(1, firstName);
			preparedStatement.setInt(2, employeeNumber);
			preparedStatement.executeUpdate();
 
			System.out.println("Record is Updated!");
 
		} 
		catch (SQLException e) 
		{
			System.out.println("There was a SQLException (UPDATE)\n"+e.getMessage()); 
		} finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("There was a SQLException (UPDATE) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
		
	}

	public List<Employees> retieveRecordByEmployeeNumber(Integer employeeNumber) 
	{
		List<Employees> employees = new ArrayList<Employees>();
		try
		{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		statement = conn.createStatement();
		resultSet = statement.executeQuery("Select * from employees where employeeNumber="+employeeNumber+";");
		while (resultSet.next()) {
			Employees employee = new Employees(
					resultSet.getInt(1),
					resultSet.getString(2),
					resultSet.getString(3),
					resultSet.getString(4),
					resultSet.getString(5),
					resultSet.getString(6),
					resultSet.getInt(7),
					resultSet.getString(8)
					);
			employees.add(employee);
		}
		
		if (employees.size()==0)
		{
			System.out.println("No employee with the given ID\n");
		}
		resultSet.close();
		statement.close();
		}
		catch (SQLException e) {
			//throw new FileParsingException("There was a problem parsing customer data file\n"+e.getMessage());
			System.out.println("There was a SQLException (Employees Retrieve by ID)\n"+e.getMessage());
		}

		return employees;
	}

	
}
