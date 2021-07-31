package com.cg.flightmgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Service.AirportService;

@RestController
public class AirportController {

	@Autowired
	private AirportService airportService;

	@GetMapping("/viewAllAirports")
	public ResponseEntity<?> viewAirports() {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				List<Airport> list = airportService.viewAirport();
				return ResponseEntity.ok(list);
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@GetMapping("/findAirport/{airportCode}")
	public ResponseEntity<?> viewAirport(@PathVariable String airportCode) {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) {
				Airport airp = airportService.viewAirport(airportCode);
				return ResponseEntity.ok(airp);
			} else
				return ResponseEntity.ok("You don't have admin privileges");
		} else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@PostMapping("/addAirport")
	public ResponseEntity<?> addAirports(@RequestBody Airport airport) {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) 
			{
				return airportService.addAirport(airport);
			} 
			else
				return ResponseEntity.ok("You don't have admin privileges");
		} 
		else
			return ResponseEntity.ok("You have not logged in yet");
		}
	@DeleteMapping("/removeAirport/{airportCode}")
	public ResponseEntity<?> removeAirport(@PathVariable String airportCode) {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) 
			{
				return airportService.removeAirport(airportCode);
			} 
			else
				return ResponseEntity.ok("You don't have admin privileges");
		} 
		else
			return ResponseEntity.ok("You have not logged in yet");
	}

	@PutMapping("/modifyAirport")
	public ResponseEntity<?> modifyAirports(@RequestBody Airport airport) {
		if (UserServiceController.logValidator == 1) {
			if (UserServiceController.UserType.equalsIgnoreCase("admin")) 
			{
				return airportService.modifyAirport(airport);
			} 
			else
				return ResponseEntity.ok("You don't have admin privileges");
		} 
		else
			return ResponseEntity.ok("You have not logged in yet");
	}

}