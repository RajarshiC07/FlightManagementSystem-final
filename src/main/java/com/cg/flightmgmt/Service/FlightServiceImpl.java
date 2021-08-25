package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Exceptions.FlightNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Repository.FlightDao;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight flightDb = flightDao.findById(flight.getFlightNumber()).orElse(null);
		
		if(Objects.nonNull(flightDb))
		{
			throw new RecordAlreadyPresentException("The Flight is already in the Database.");
		}
		else {
			System.out.println("Flight Added;");
			return flightDao.save(flight);
			
		}
		
	}

	@Override
	public Flight modifyFlight(BigInteger flightNumber,Flight flight) {
		// TODO Auto-generated method stub
		Flight flightDb = flightDao.findById(flightNumber).orElse(null);

		if(Objects.isNull(flightDb)) {
			throw new FlightNotFoundException("Flight is not avialable");
		}
		else
		{
		if (Objects.nonNull(flight.getCarrierName()) && !"".equalsIgnoreCase(flight.getCarrierName())) {
			flightDb.setCarrierName(flight.getCarrierName());
		}

		if (Objects.nonNull(flight.getFlightModel()) && !"".equalsIgnoreCase(flight.getFlightModel())) {
			flightDb.setFlightModel(flight.getFlightModel());
		}
		if (Objects.nonNull(flight.getSeatCapacity())) {
			flightDb.setSeatCapacity(flight.getSeatCapacity());
		}
		}
		return flightDao.save(flightDb);
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		// TODO Auto-generated method stub
		Flight flight = flightDao.findById(flightNumber).orElse(null);
	    if(Objects.isNull(flight))
	    		{
	    	throw new FlightNotFoundException("flight is not available");
	    		}
	    else
	    	return flight;
	
	}
	
	@Override
	public List<Flight> viewFlight() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		// TODO Auto-generated method stub
		
		if(Objects.isNull(flightDao.findById(flightNumber).orElse(null)))
		{
			throw new FlightNotFoundException("The Flight Number entered is not present.");
		}
		flightDao.deleteById(flightNumber);
	}
	
}
