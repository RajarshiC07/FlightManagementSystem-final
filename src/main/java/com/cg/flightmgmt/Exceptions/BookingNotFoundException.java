package com.cg.flightmgmt.Exceptions;

public class BookingNotFoundException extends RuntimeException{
	public  BookingNotFoundException(String message)
	{
		super(message);
	}
	public  BookingNotFoundException()
	{
	
	}
}
