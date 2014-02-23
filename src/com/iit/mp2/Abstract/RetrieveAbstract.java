package com.iit.mp2.Abstract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.iit.mp2.data.MySQLDBConnection;

public class RetrieveAbstract {	
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	String selectQuery=null;
	
	public RetrieveAbstract(String dbUrl, String username, String password) {
		conn = MySQLDBConnection.getInstance(dbUrl, username, password);
	}

	public ResultSet retrieveRecords(String selectQuery) 
	{	
		try {
			statement = conn.createStatement();
			this.selectQuery = selectQuery;
			this.resultSet = statement.executeQuery(this.selectQuery);
			//statement.close();
			//conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return resultSet;
	}
	
	

}
