package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ScheduledFlightController {
	@Autowired
	private ScheduleFlightServices scheduleFlightService;
	@Autowired
	private FlightService flightService; 
	@Autowired
	private AirportService airportService; 
	
	public ScheduledFlight scheduledFlightGenerator(ScheduledFlightDTO scheduledFlightDto)
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
	@PostMapping("/ScheduleOfFlights")
	public ResponseEntity<?> scheduleFlight(@RequestBody ScheduledFlightDTO scheduledFlightDto) {
	
		 ScheduledFlight scheduledFlight = scheduledFlightGenerator(scheduledFlightDto);
		 ScheduledFlight scheduleFlight=scheduleFlightService.scheduleFlight(scheduledFlight);
		 return ResponseEntity.ok(scheduleFlight);
	}
	
	@GetMapping("/scheduledFlights/{sourceAirport}/{destinationAirport}/{date}")
	public ResponseEntity<?> viewScheduledFlight(@PathVariable("sourceAirport") String sourceAirport,@PathVariable("destinationAirport") String destinationAirport,@PathVariable("date") String date) {
		List<ScheduledFlight> list=scheduleFlightService.viewScheduledFlights(sourceAirport, destinationAirport, date);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/viewFlightsByFlightNumber/{scheduledFlightId}")
	public ResponseEntity<?> viewScheduledFlight(@PathVariable BigInteger scheduledFlightId) {
		List<ScheduledFlight>list1=scheduleFlightService.viewScheduledFlights(scheduledFlightId);
		return ResponseEntity.ok(list1);
	}
	
	@GetMapping("/viewAllFlights")
	public ResponseEntity<?> viewScheduledFlight() {
		List<ScheduledFlight>list2= scheduleFlightService.viewScheduledFlight();
		return ResponseEntity.ok(list2);
	}
	
	@PutMapping("/modifyFlightsByScheduledFlightNumber")
	public ResponseEntity<?> modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		ScheduledFlight scheduleFlight= scheduleFlightService.modifyScheduledFlight(scheduledFlight);
		return ResponseEntity.ok(scheduleFlight);
	}

	
	@DeleteMapping("/deleteFlightsByFlightNumber/{scheduledFlightId}")
	public ResponseEntity<?> deleteScheduledFlight(@PathVariable Integer scheduledFlightId) {
		scheduleFlightService.deleteScheduledFlight(scheduledFlightId);
		return ResponseEntity.ok("ScheduledFlight   "+ scheduledFlightId + "  deleted successfully");
	}
}