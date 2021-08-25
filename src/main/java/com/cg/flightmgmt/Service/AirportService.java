package com.cg.flightmgmt.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.Entity.Airport;

public interface AirportService {
	
	public List<Airport> viewAirport();
	
	public Airport viewAirport(String airportCode);
	
	public Airport addAirport(Airport airport);
	
	public Airport modifyAirport(String airportCode,Airport airport);
	
	public Airport removeAirport(String airportCode);
}
