package com.cg.flightmgmt.Exceptions;

public class AirportNotFoundException extends RuntimeException{
	
	public AirportNotFoundException()
	{
		
	}
	public AirportNotFoundException(String message)
	{
		super(message);
	}

}
