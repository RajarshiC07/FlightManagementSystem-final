package com.cg.flightmgmt.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBookingNotFoundException(BookingNotFoundException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFlightNotFoundException(FlightNotFoundException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleScheduledFlightNotFoundException(ScheduledFlightNotFoundException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	@ExceptionHandler(AirportNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleAirportNotFoundException(AirportNotFoundException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<ErrorMessage> handleRecordAlreadyPresentException(RecordAlreadyPresentException ex,WebRequest req)
	{
		ErrorMessage msg=new ErrorMessage(HttpStatus.ALREADY_REPORTED,ex.getMessage());
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(msg);
	}

}
