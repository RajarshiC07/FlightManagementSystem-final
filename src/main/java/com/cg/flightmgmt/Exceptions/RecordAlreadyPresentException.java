package com.cg.flightmgmt.Exceptions;

public class RecordAlreadyPresentException extends RuntimeException{
	public RecordAlreadyPresentException(String message)
	{
		super(message);
	}
	public RecordAlreadyPresentException()
	{
		
	}
}
