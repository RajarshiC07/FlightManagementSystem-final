package com.cg.flightmgmt.Exceptions;

public class ScheduledFlightNotFoundException extends RuntimeException{

	public ScheduledFlightNotFoundException(String message)
	{
		super(message);
	}
	public ScheduledFlightNotFoundException() {}
}