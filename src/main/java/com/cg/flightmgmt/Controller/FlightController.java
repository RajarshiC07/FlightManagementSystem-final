package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Service.FlightService;

@RestController
public class FlightController {
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightService flightService;

	@PostMapping("/flight")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight)
	{
		return ResponseEntity.ok(flightService.addFlight(flight));
	}
	
@PutMapping("/flight")
public ResponseEntity<?> modifyFlight(@RequestBody Flight flight)
{
	  return ResponseEntity.ok(flightService.modifyFlight(flight));
}
@GetMapping("/flight/{flightNumber}")
public ResponseEntity<?> viewByFlightNumber(@PathVariable("flightNumber") BigInteger flightNumber)
{
	return ResponseEntity.ok(flightService.viewFlight(flightNumber));
	
}
@GetMapping("/flight")
public ResponseEntity<?> viewAllFlightts()
{
	logger.info("inside fetchAllFlights() of FlightController");
	return ResponseEntity.ok(flightService.viewFlight());
}

@DeleteMapping("/flight/{flightNumber}")
public ResponseEntity<?> deleteById(@PathVariable("flightNumber") BigInteger flightNumber)
{
	flightService.deleteFlight(flightNumber);
	return  ResponseEntity.ok("flight - "  + flightNumber + " deleted successfully");
}

	
}

