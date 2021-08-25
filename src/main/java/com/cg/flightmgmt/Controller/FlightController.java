package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {
	
	@Autowired
	private FlightService flightService;

	@PostMapping("/flight")
	public Flight addFlight(@RequestBody Flight flight) {
		
				return flightService.addFlight(flight);
			
	}

	@PutMapping("/flight/{flightNumber}")
	public Flight modifyFlight(@PathVariable BigInteger flightNumber,@RequestBody Flight flight) {

		
				return flightService.modifyFlight(flightNumber,flight);
			
	}

	@GetMapping("/flight/{flightNumber}")
	public Flight viewByFlightNumber(@PathVariable("flightNumber") BigInteger flightNumber) {

		
				return flightService.viewFlight(flightNumber);
			
	}

	@GetMapping("/flight")
	public List<Flight> viewAllFlightts() {
			
			return flightService.viewFlight();
			
	}

	@DeleteMapping("/flight/{flightNumber}")
	public ResponseEntity<?> deleteById(@PathVariable("flightNumber") BigInteger flightNumber) {

		
				flightService.deleteFlight(flightNumber);
				return ResponseEntity.ok("flight - " + flightNumber + " deleted successfully");

	}

}
