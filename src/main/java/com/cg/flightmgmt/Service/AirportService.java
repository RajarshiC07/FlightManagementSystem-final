package com.cg.flightmgmt.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.Entity.Airport;

public interface AirportService {
	
	public List<Airport> viewAirport();
	
	public Airport viewAirport(String airportCode);
	
	public ResponseEntity<?> addAirport(Airport airport);
	
	public ResponseEntity<?> modifyAirport(Airport airport);
	
	public ResponseEntity<?> removeAirport(String airportCode);
}
