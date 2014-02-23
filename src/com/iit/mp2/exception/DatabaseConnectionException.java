package com.iit.mp2.exception;

public class DatabaseConnectionException extends Exception
{
	
	private static final long serialVersionUID = 1174968666866309101L;

	public DatabaseConnectionException(String message) {
		super(message);
		//super("There was a problem parsing database: msg=> "+message);
		System.out.println(message);
	}
	
}
