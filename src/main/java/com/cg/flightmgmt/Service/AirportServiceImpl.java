package com.cg.flightmgmt.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Exceptions.AirportNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Repository.AirportDao;

@Service
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
		Airport airport = airportDao.findById(airportCode).orElse(null);
		if(!Objects.isNull(airport))
			return airport;
		else
			throw new AirportNotFoundException("Airport with airport code "+airportCode+" does not exists");
	}
	
	public Airport addAirport(Airport airport)
	{
		if(Objects.nonNull(airportDao.findById(airport.getAirportCode()).orElse(null)))
			throw new RecordAlreadyPresentException("The airport with airport code "+airport.getAirportCode()+" already exists");
		else
		{
			return airportDao.save(airport);		
		}
	}
	
	/*
	 * remove airport
	 */
	public Airport removeAirport(String airportCode)
	{
		Airport airport = airportDao.getById(airportCode);
		if(Objects.isNull(airport))
			throw new AirportNotFoundException("Airport with airport code "+airportCode+" does not exists");
		else
		{
			 airportDao.deleteById(airportCode);		
			 return airport;
		}
	}
	
	/*
	 * modify airport
	 */

	public Airport modifyAirport(String airportCode,Airport airport)
	{
		Airport airportdb = airportDao.findById(airport.getAirportCode()).orElse(null);
		if(Objects.isNull(airportdb))
			throw new AirportNotFoundException("Airport with airport code "+airport.getAirportCode()+" does not exists");
		else
		{
			if(Objects.nonNull(airport.getAirportLocation()))
				airportdb.setAirportLocation(airport.getAirportLocation());
			if(Objects.nonNull(airport.getAirportName()))
				airportdb.setAirportName(airport.getAirportName());
		}
		return airportDao.save(airportdb);
	}
}
