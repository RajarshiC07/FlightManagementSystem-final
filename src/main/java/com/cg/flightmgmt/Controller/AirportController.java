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
	public ResponseEntity<?> viewAirports()
	{
		List<Airport>list= airportService.viewAirport();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/findAirport/{airportCode}")
	public ResponseEntity<?> viewAirport(@PathVariable String airportCode)
	{
		Airport airp= airportService.viewAirport(airportCode);
		return ResponseEntity.ok(airp);
	}
	
	@PostMapping("/addAirport")
	public ResponseEntity<?> addAirports(@RequestBody Airport airport)
	{
		 return airportService.addAirport(airport);
	    
	}
	
	@DeleteMapping("/removeAirport/{airportCode}")
	public ResponseEntity<?> removeAirport(@PathVariable String airportCode)
	{
		return airportService.removeAirport(airportCode);
		 
	}
	
	@PutMapping("/modifyAirport")
	public ResponseEntity<?> modifyAirports(@RequestBody Airport airport)
	{
		return airportService.modifyAirport(airport);
		 
	}
	
}