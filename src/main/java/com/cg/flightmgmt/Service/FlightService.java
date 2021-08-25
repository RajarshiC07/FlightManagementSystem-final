package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.Entity.Flight;

public interface FlightService {
	
	public Flight addFlight(Flight flight); 
	
	public  Flight modifyFlight(BigInteger flightNumber,Flight flight);
	
	public Flight viewFlight(BigInteger flightNumber);
	
	public List<Flight> viewFlight();
	
	public void deleteFlight(BigInteger flightNumber);
}
