package com.cg.flightmgmt.Sevice;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;





public interface ScheduleFlightServices {
public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight ) ;
public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport , Airport destinationAirport, LocalDate date);
public Flight viewScheduledFlights(BigInteger scheduledFlightId);
public List<ScheduledFlight> viewScheduledFlight();
public ScheduledFlight modifyScheduledFlight(Flight flight ,Schedule schedule , Integer availableSeats);
public void deleteScheduledFlight(BigInteger scheduledFlightId);
public void validateScheduledFlight(ScheduledFlight scheduledFlight);
}
