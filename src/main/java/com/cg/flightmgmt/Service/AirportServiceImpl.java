package com.cg.flightmgmt.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Exceptions.AirportNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Repository.AirportDao;

public class AirportServiceImpl implements AirportService{
	
	@Autowired
	AirportDao airportDao;
	/*
	 * List of all airports
	 */
	public List<Airport> viewAirport()
	{
		return airportDao.findAll();
	}
	
	/*
	 * single airport
	 */
	
	public Airport viewAirport(String airportCode)
	{
		Airport airport = airportDao.getById(airportCode);
		if(!Objects.isNull(airport))
			return airport;
		else
			throw new AirportNotFoundException("Airport with airport code "+airportCode+" does not exists");
	}
	
	/*
	 * add airport
	 */
	public ResponseEntity<?> addAirport(Airport airport)
	{
		if(Objects.nonNull(airportDao.getById(airport.getAirportCode())))
			throw new RecordAlreadyPresentException("The airport with airport code "+airport.getAirportCode()+" already exists");
		else
		{
			airportDao.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.CREATED);
		}
	}
	
	/*
	 * remove airport
	 */
	public ResponseEntity<?> removeAirport(String airportCode)
	{
		Airport airport = airportDao.getById(airportCode);
		if(Objects.isNull(airport))
			throw new AirportNotFoundException("Airport with airport code "+airportCode+" does not exists");
		else
		{
			airportDao.deleteById(airportCode);
			return ResponseEntity.ok("Airport with airport code "+airportCode+" has been deleted");			
		}
	}
	
	/*
	 * modify airport
	 */

	public ResponseEntity<?> modifyAirport(Airport airport)
	{
		Airport airportdb = airportDao.getById(airport.getAirportCode());
		if(Objects.isNull(airportdb))
			throw new AirportNotFoundException("Airport with airport code "+airport.getAirportCode()+" does not exists");
		else
		{
			if(Objects.nonNull(airport.getAirportLocation()))
				airportdb.setAirportLocation(airport.getAirportLocation());
			if(Objects.nonNull(airport.getAirportName()))
				airportdb.setAirportName(airport.getAirportName());
		}
		airportDao.save(airport);
		return ResponseEntity.ok(airport.getAirportCode()+" has been modified");
	}
}
