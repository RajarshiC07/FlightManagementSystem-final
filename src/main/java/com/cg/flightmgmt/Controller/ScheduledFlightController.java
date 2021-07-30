package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Service.AirportService;
import com.cg.flightmgmt.Service.ScheduleFlightServices;

@RestController
public class ScheduledFlightController {
	@Autowired
	private ScheduleFlightServices scheduleFlightService;
	
	@PostMapping("/ScheduleOfFlights")
	public ResponseEntity<?> scheduleFlight(ScheduledFlight scheduledFlight) {
		 ScheduledFlight scheduleFlight=scheduleFlightService.scheduleFlight(scheduledFlight);
		 return ResponseEntity.ok(scheduleFlight);
	}
	
	@GetMapping("/scheduledFlights/{sourceAirport}/{destinationAirport}/{date}")
	public ResponseEntity<?> viewScheduledFlight(@PathVariable("sourceAirport") Airport sourceAirport,@PathVariable("destinationAirport") Airport destinationAirport,@PathVariable("date") LocalDate date) {
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
	
	@PutMapping("/modifyFlightsByFlightNumber")
	public ResponseEntity<?> modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		ScheduledFlight scheduleFlight= scheduleFlightService.modifyScheduledFlight(scheduledFlight);
		return ResponseEntity.ok(scheduleFlight);
	}

	
	@DeleteMapping("/deleteFlightsByFlightNumber/{scheduledFlightId}")
	public ResponseEntity<?> deleteScheduledFlight(@PathVariable BigInteger scheduledFlightId) {
		scheduleFlightService.deleteScheduledFlight(scheduledFlightId);
		return ResponseEntity.ok("ScheduledFlight   "+ scheduledFlightId + "  deleted successfully");
	}
	@PostMapping("/validateScheduledFlight/{scheduledFlightId}")
	public ResponseEntity<?> validateScheduledFlight(ScheduledFlight scheduledFlight) {
		scheduleFlightService.validateScheduledFlight(scheduledFlight);
		return ResponseEntity.ok("ScheduledFlight deleted successfully");
	}
}