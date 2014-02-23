package com.iit.mp2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iit.mp2.Abstract.RetrieveAbstract;
import com.iit.mp2.data.MySQLDBConnection;
import com.iit.mp2.domain.Orders;

public class OrdersDAO {

	private String dbUrl;
	private String username;
	private String password;
	
	private Connection conn = null;
	//private Statement statement = null;
	private ResultSet resultSet = null;
    public static String query = null;
	
	public OrdersDAO(String dbUrl, String username, String password) 
	{
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}
	
	public List<Orders> getAllOrdersFromDatabase()
	{
		List<Orders> orders = new ArrayList<Orders>();
		try {
			//conn = MySQLDBConnection.getInstance(dbUrl, username, password);
			//statement = conn.createStatement();
			//resultSet = statement.executeQuery("Select * from orders");
			
			String selectQuery = "Select * from orders";
			RetrieveAbstract crudAbstract = new RetrieveAbstract(this.dbUrl,this.username,this.password);
			resultSet = crudAbstract.retrieveRecords(selectQuery);
			
			while (resultSet.next()) {
				Orders order = new Orders(
						resultSet.getInt(1),
						resultSet.getDate(2),
						resultSet.getDate(3),
						resultSet.getDate(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(7)
						);
				orders.add(order);
			}
			resultSet.close();
		} 
		catch (SQLException e) {
			System.out.println("There was a SQLException (SELECT)\n"+e.getMessage());
		}
		return orders;
	}


	
	public void insertOrderIntoDatabase(Integer orderNumber, java.sql.Timestamp orderDate,
			java.sql.Timestamp requiredDate, java.sql.Timestamp shippedDate, String status,
			String comments, Integer customerNumber) 
	{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String insertQuery= "Insert into Orders values (?,?,?,?,?,?,?)";
		try {
			//statement = conn.createStatement();
			preparedStatement = conn.prepareStatement(insertQuery);
			preparedStatement.setInt(1,orderNumber);
			preparedStatement.setTimestamp(2, orderDate);
			preparedStatement.setTimestamp(3,requiredDate);
			preparedStatement.setTimestamp(4,shippedDate);
			preparedStatement.setString(5,status);
			preparedStatement.setString(6,comments);
			preparedStatement.setInt(7,customerNumber);
			
			preparedStatement.executeUpdate();
			 
			System.out.println("Record is inserted into Order table!");
		} 

		catch (SQLException e) {
			System.out.println("There was a SQLException (INSERT)\n"+e.getMessage());
		}
		finally {	 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("There was a SQLException (INSERT) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
		
	}

	public void deleteOrdersFromDatabase(Integer orderNumber) 
	{
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String deleteQuery= "Delete from orders where orderNumber = ?";
		
		try {
			preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, orderNumber);
			preparedStatement.executeUpdate();
			System.out.println("Record is deleted!");
		} catch (SQLException e) {
			System.out.println("There was a SQLException (DELETE)\n"+e.getMessage()); 
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("There was a SQLException (DELETE) in closing preparedStatement\n"+e.getMessage());
				}
			}
		}
	}

	public void updateOrderRecordInDatabase(Integer orderNumber, String status) {
		System.out.println(orderNumber);
		System.out.println(status);

		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
		PreparedStatement preparedStatement = null;
		String updateQuery="update orders set status=? where orderNumber = ?";
		
		try {
			preparedStatement = conn.prepareStatement(updateQuery);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, orderNumber);
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

}
