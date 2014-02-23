package com.iit.mp2.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

	private static Connection connection = null;
	//private String dbUrl ="jdbc:mysql://localhost:3306/MP3";
	//private String username = "root";
	//private String password = "password";
    
    public static Connection getInstance(String dbUrl, String username, String password)
    {
        if(connection == null)
        {
            try {
				connection = DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
         return connection;
    }
    
    public static void closeInstance(Connection conn)
    {
    	try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("There was a SQLException Closing the shared\n"+e.getMessage());
		}
    }


    private MySQLDBConnection()
    {
		//try {
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MP3","root", "password");
			//statement = connection.createStatement();
			//resultSet = statement.executeQuery("Select * from customers");
			//resultSet = statement.executeQuery(query);
			//while (resultSet.next()) {
			//	System.out.println(resultSet.getString(1));
			//}
			//resultSet.close();
			//statement.close();
			//connection.close();
		//} 
		//catch (SQLException e) {
		//	e.printStackTrace();
		//}
    }
    
}
