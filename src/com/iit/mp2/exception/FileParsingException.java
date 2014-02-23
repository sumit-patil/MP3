package com.iit.mp2.exception;
/*
 * This file handles the custom exceptions thrown by the user
 */
public class FileParsingException extends Exception{

	private static final long serialVersionUID = -7880043388796942290L;

	public FileParsingException(String message) {
		super(message);
		//super("There was a problem parsing inout file: msg=> "+message);
		//System.out.println(message);
	}
}
