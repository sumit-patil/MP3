package com.iit.mp2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/*
 * This is the utility class which checks for Integer, Double, String and Date values.
 * If no values is provided for any field, it sets it to null and converts into respective object data types like Integer,Double,String or Date
 */
public class Utility {

    public static Integer checkInteger(String value)
    {
    	Integer integerVal = null;
 
    	if ((!"NULL".equalsIgnoreCase(value)) && (!value.isEmpty())) {
    		integerVal = Integer.valueOf(value);
			return integerVal;
		}
		return integerVal;
	}
    
    public static String checkString(String value) 
    {
    	String stringVal = null;
		if(!"NULL".equalsIgnoreCase(value))
		{
			stringVal = value;
		}
		if(value=="") {
		 stringVal = "NULL";
		}
		return stringVal;
	}

    public static Date getDateFromString(String value) throws ParseException{
	   	 	Date dateVal = null;
	   	 	if((!"NULL".equalsIgnoreCase(value)) && (!value.isEmpty()))
	   	 	{
	   	 		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	   	 		dateVal= (Date)formatter.parse(value);
	   	 	}
	   	 
	    return dateVal;
    }
    
    public static Double checkDouble(String value){
   	 	Double doubleVal = null;
   	 	if(!"NULL".equalsIgnoreCase(value))
   	 	{
	   	 	doubleVal = Double.valueOf(value);
			return doubleVal;
   	 	}
   	 			
   	 	return doubleVal;
    }
	
}
