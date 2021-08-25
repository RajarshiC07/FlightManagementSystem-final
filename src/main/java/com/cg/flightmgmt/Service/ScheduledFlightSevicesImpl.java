package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Exceptions.ScheduledFlightNotFoundException;
import com.cg.flightmgmt.Repository.ScheduleDao;
import com.cg.flightmgmt.Repository.ScheduledFlightDao;

@Service
public class ScheduledFlightSevicesImpl implements ScheduleFlightServices{
@Autowired
ScheduledFlightDao scheduledFlightDao;

@Autowired
ScheduleDao scheduleDao;

@Override
public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
	if(Objects.isNull(scheduledFlightDao.findById(scheduledFlight.getScheduledFlightId()).orElse(null)))
		return scheduledFlightDao.save(scheduledFlight);
		
	else
	{	
		throw new RecordAlreadyPresentException("The scheduledFlight with scheduledFlight id "+scheduledFlight.getScheduledFlightId()+" already exists");
	}
		
}



public ScheduledFlight viewScheduledFlightById(Integer scheduledFlightId)
{
	ScheduledFlight scheduledFlightDb = scheduledFlightDao.findById(scheduledFlightId).orElse(null); 
	if(Objects.isNull(scheduledFlightDb))
		throw new ScheduledFlightNotFoundException("The scheduled Flight with scheduled Flight id "+scheduledFlightId+" does not exists");
	else
		return scheduledFlightDb;
}

@Override
public List<ScheduledFlight> viewScheduledFlights(String sourceAirport,String destinationAirport,String date) {
	List<ScheduledFlight> list = new ArrayList<ScheduledFlight>();
	List<ScheduledFlight> scheduledFlightList = new ArrayList<ScheduledFlight>();
	list  = scheduledFlightDao.findAll();
	for(int i = 0;i<list.size();i++)
	{
		if(list.get(i).getSchedule().getSourceAirport().getAirportCode().compareTo(sourceAirport) == 0 && list.get(i).getSchedule().getDestinationAirport().getAirportCode().compareTo(destinationAirport) == 0 && list.get(i).getSchedule().getDepartureTime().toLocalDate().equals(LocalDate.parse(date)))
			scheduledFlightList.add(list.get(i));
	}
	return scheduledFlightList;
}

@Override
public List<ScheduledFlight> viewScheduledFlights(BigInteger FlightId) {
	List<ScheduledFlight> list = new ArrayList<ScheduledFlight>();
	List<ScheduledFlight> scheduledFlightList = new ArrayList<ScheduledFlight>();
	list  = scheduledFlightDao.findAll();
	for(int i = 0;i<list.size();i++)
	{
		if(list.get(i).getFlight().getFlightNumber().compareTo(FlightId) == 0)
			scheduledFlightList.add(list.get(i));
	}
	return scheduledFlightList;
}

@Override
public List<ScheduledFlight> viewScheduledFlight() {
	
	return scheduledFlightDao.findAll();
}

@Override
public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight)
{
	ScheduledFlight scheduledFlightDb = scheduledFlightDao.findById(scheduledFlight.getScheduledFlightId()).orElse(null); 
	if(Objects.isNull(scheduledFlightDb))
		throw new ScheduledFlightNotFoundException("The scheduled Flight with scheduled Flight id "+scheduledFlight.getScheduledFlightId()+" does not exists");
	else
	{
		if(Objects.nonNull(scheduledFlight.getFlight()))
			scheduledFlightDb.setFlight(scheduledFlight.getFlight());
		if(Objects.nonNull(scheduledFlight.getSchedule()))
			scheduledFlightDb.setSchedule(scheduledFlight.getSchedule());
		if(Objects.nonNull(scheduledFlight.getAvailableSeats()))
			scheduledFlightDb.setAvailableSeats(scheduledFlight.getAvailableSeats());
	}
	System.out.println("inside scheduled flight");
	scheduledFlightDao.save(scheduledFlightDb);
	return scheduledFlight;
}

@Override
public void deleteScheduledFlight(Integer scheduledFlightId) {
	ScheduledFlight scheduledFlightDb = scheduledFlightDao.findById(scheduledFlightId.intValue()).orElse(null); 
	System.out.println(scheduledFlightDb);
	if(Objects.isNull(scheduledFlightDb))
		throw new ScheduledFlightNotFoundException("The scheduled Flight with scheduled Flight id "+scheduledFlightId+" does not exists");
	else
		{
			scheduledFlightDb.setSchedule(null);
			scheduledFlightDb.setFlight(null);
			scheduledFlightDb.setAvailableSeats(null);
			ScheduledFlight scheduledFlightDb2 = scheduledFlightDao.save(scheduledFlightDb);
			System.out.println(scheduledFlightDb2);
			
			scheduledFlightDao.delete(scheduledFlightDb2);
		}
}

@Override
public void validateScheduledFlight(ScheduledFlight scheduledFlight) {
	LocalDateTime currentTime = LocalDateTime.now();
	LocalDateTime arrivalTime = scheduledFlight.getSchedule().getArrivalTime();
	LocalDateTime departureTime =  scheduledFlight.getSchedule().getDepartureTime();
	if(arrivalTime.isBefore(departureTime))
		throw new ScheduledFlightNotFoundException("Invalid arrival and departure time");
	if(arrivalTime.isBefore(currentTime) || departureTime.isBefore(currentTime))
		throw new ScheduledFlightNotFoundException("Invalid arrival and departure time");	
	}
}