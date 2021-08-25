package com.cg.flightmgmt.Controller;

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

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Service.AirportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AirportController {

	@Autowired
	private AirportService airportService;

	@GetMapping("/Airports")
	public List<Airport> viewAirports() {
		
				List<Airport> list = airportService.viewAirport();
				return list;
			
	}

	@GetMapping("/Airports/{airportCode}")
	public Airport viewAirport(@PathVariable String airportCode) {
		
				Airport airp = airportService.viewAirport(airportCode);
				return airp;
			
	}
	@PostMapping("/Airports")
	public Airport addAirports(@RequestBody Airport airport) {
		
			return airportService.addAirport(airport);
			
		}
	@DeleteMapping("/Airports/{airportCode}")
	public Airport removeAirport(@PathVariable String airportCode) {
		
			return airportService.removeAirport(airportCode);
			
	}

	@PutMapping("/Airports/{airportCode}")
	public Airport modifyAirports(@PathVariable String airportCode,@RequestBody Airport airport) {
		
			return airportService.modifyAirport(airportCode,airport);
			
	}

}