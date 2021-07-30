package com.cg.flightmgmt.Service;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;


public interface ScheduleFlightServices {
	
public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight ) ;

public List<ScheduledFlight> viewScheduledFlights(String sourceAirport , String destinationAirport, String date);

public List<ScheduledFlight> viewScheduledFlights(BigInteger FlightId);

public List<ScheduledFlight> viewScheduledFlight();


public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

public void deleteScheduledFlight(BigInteger scheduledFlightId);

public void validateScheduledFlight(ScheduledFlight scheduledFlight);
}
