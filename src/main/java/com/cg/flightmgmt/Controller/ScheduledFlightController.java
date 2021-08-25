package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.DTO.ScheduledFlightDTO;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Service.AirportService;
import com.cg.flightmgmt.Service.FlightService;
import com.cg.flightmgmt.Service.ScheduleFlightServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduledFlightController {
	@Autowired
	private ScheduleFlightServices scheduleFlightService;
	@Autowired
	private FlightService flightService; 
	@Autowired
	private AirportService airportService; 
	
	private ScheduledFlight scheduledFlightGenerator(ScheduledFlightDTO scheduledFlightDto)
	{
				ScheduledFlight scheduledFlight = new ScheduledFlight();
		
				Schedule schedule = new Schedule();
				schedule.setSourceAirport(airportService.viewAirport(scheduledFlightDto.getSourceAirportCode()));
				schedule.setDestinationAirport(airportService.viewAirport(scheduledFlightDto.getDestinationAirportCode()));
				schedule.setArrivalTime(LocalDateTime.parse(scheduledFlightDto.getArrivalTime()));
				schedule.setDepartureTime(LocalDateTime.parse(scheduledFlightDto.getDepartureTime()));
		
				scheduledFlight.setFlight(flightService.viewFlight(scheduledFlightDto.getFlightNumber()));
				scheduledFlight.setAvailableSeats(scheduledFlightDto.getAvailableSeats());
				scheduledFlight.setSchedule(schedule);
				scheduleFlightService.validateScheduledFlight(scheduledFlight);
				return scheduledFlight;
		
	}
	@PostMapping("/addScheduleFlights")
	public ScheduledFlight scheduleFlight(@RequestBody ScheduledFlightDTO scheduledFlightDto)
	{
	
		
				
				ScheduledFlight scheduledFlight = scheduledFlightGenerator(scheduledFlightDto);
				ScheduledFlight scheduleFlight=scheduleFlightService.scheduleFlight(scheduledFlight);
				return scheduleFlight;
			
	}
	
	@GetMapping("/viewScheduledFlightsByAirport/{sourceAirport}/{destinationAirport}/{date}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable("sourceAirport") String sourceAirport,@PathVariable("destinationAirport") String destinationAirport,@PathVariable("date") String date) {
	
		
			List<ScheduledFlight> list=scheduleFlightService.viewScheduledFlights(sourceAirport, destinationAirport, date);
			return list;
	
	}
	
	@GetMapping("/viewScheduledFlightsByFlightNumber/{scheduledFlightNumber}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable BigInteger scheduledFlightNumber) {
		
		
					List<ScheduledFlight>list1=scheduleFlightService.viewScheduledFlights(scheduledFlightNumber);
					return list1;
			
	}
	@GetMapping("/viewScheduledFlightsById/{scheduledFlightId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable Integer scheduledFlightId) {
		
		ScheduledFlight sf=scheduleFlightService.viewScheduledFlightById(scheduledFlightId);
		return sf;
			
	}
	
	
	
	
	@GetMapping("/ScheduledFlights")
	public List<ScheduledFlight> viewScheduledFlight() {
	
			List<ScheduledFlight>list2= scheduleFlightService.viewScheduledFlight();
			return list2;
		
	}
	
	@PutMapping("/modifyFlightsByFlightNumber")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
				
				ScheduledFlight scheduleFlight= scheduleFlightService.modifyScheduledFlight(scheduledFlight);
				return scheduleFlight;
				
	}
		
	
	@DeleteMapping("/deleteFlightsByScheduledFlightId/{scheduledFlightId}")
	public String deleteScheduledFlight(@PathVariable Integer scheduledFlightId) {
		
					scheduleFlightService.deleteScheduledFlight(scheduledFlightId);
					return "ScheduledFlight   "+ scheduledFlightId + "  deleted successfully";
		
	}
}