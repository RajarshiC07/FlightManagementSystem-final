package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class FlightController {
	
	@Autowired
	private FlightService flightService;

	@PostMapping("/flight")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				return ResponseEntity.ok(flightService.addFlight(flight));
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@PutMapping("/flight")
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {

		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				return ResponseEntity.ok(flightService.modifyFlight(flight));
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@GetMapping("/flight/{flightNumber}")
	public ResponseEntity<?> viewByFlightNumber(@PathVariable("flightNumber") BigInteger flightNumber) {

		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				return ResponseEntity.ok(flightService.viewFlight(flightNumber));
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@GetMapping("/flight")
	public ResponseEntity<?> viewAllFlightts() {
		
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				return ResponseEntity.ok(flightService.viewFlight());
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@DeleteMapping("/flight/{flightNumber}")
	public ResponseEntity<?> deleteById(@PathVariable("flightNumber") BigInteger flightNumber) {

		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				flightService.deleteFlight(flightNumber);
				return ResponseEntity.ok("flight - " + flightNumber + " deleted successfully");

			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

}
