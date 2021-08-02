package com.cg.flightmgmt.Service;
import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.Entity.ScheduledFlight;


public interface ScheduleFlightServices {
	
public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight ) ;

public List<ScheduledFlight> viewScheduledFlights(String sourceAirport , String destinationAirport, String date);

public List<ScheduledFlight> viewScheduledFlights(BigInteger FlightId);

public List<ScheduledFlight> viewScheduledFlight();

public ScheduledFlight viewScheduledFlightById(Integer scheduledFlightId);

public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

public void deleteScheduledFlight(Integer scheduledFlightId);

public void validateScheduledFlight(ScheduledFlight scheduledFlight);
}
