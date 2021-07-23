package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Exceptions.FlightNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Repository.FlightDao;


public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		if(Objects.isNull(flight))
		{
			throw new RecordAlreadyPresentException("The Flight is already in the Database.");
		}
		else
		return flightDao.save(flight);
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight flightDb = flightDao.findById(flight.getFlightNumber()).get();

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
		Optional<Flight> flight = flightDao.findById(flightNumber);
	    if(!flight.isPresent())
	    		{
	    	throw new FlightNotFoundException("flight is not available");
	    		}
	    
	    return flight.get();
	
	}
	
	@Override
	public List<Flight> viewFlight() {
		// TODO Auto-generated method stub
		return flightDao.findAll();
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		// TODO Auto-generated method stub
		flightDao.deleteById(flightNumber);
	}

	@Override
	public void validateFlight(Flight flight) {
		// TODO Auto-generated method stub

	}

}
