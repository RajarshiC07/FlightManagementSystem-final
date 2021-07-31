

package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.DTO.BookingDTO;
import com.cg.flightmgmt.DTO.PassengerDTO;
import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Exceptions.ScheduledFlightNotFoundException;
import com.cg.flightmgmt.Repository.ScheduledFlightDao;
import com.cg.flightmgmt.Service.BookingService;
import com.cg.flightmgmt.Service.UserService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	@Autowired
	private ScheduledFlightDao scheduledFlightDao;
	@Autowired
	private UserService userService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDto)
	{
		ScheduledFlight scheduledFlight = scheduledFlightDao.findById(bookingDto.getScheduledFlightId()).orElse(null);
		Users user = userService.viewUser(bookingDto.getUserId()); 
		if(Objects.isNull(scheduledFlight))
			throw new ScheduledFlightNotFoundException("No such scheduled flight present");
		else if(!LocalDate.parse(bookingDto.getBookingDate()).equals(scheduledFlight.getSchedule().getArrivalTime().toLocalDate()))
				return ResponseEntity.ok("Date is not available for this schedule");
		else
		{
			Booking booking  = new Booking();
			booking.setBookingId(BigInteger.valueOf(10));
			booking.setBookingDate(LocalDate.parse(bookingDto.getBookingDate()));
			booking.setScheduledFlight(scheduledFlight);
			booking.setUserId(user);
			return ResponseEntity.ok(bookingService.addBooking(booking));
		}
	}
	@PostMapping("/addPassenger")
	public ResponseEntity<?> addBooking(@RequestBody PassengerDTO passengerDto)
	{
		bookingService.validatePassenger(passengerDto);
		Passenger passenger = new Passenger();
		passenger.setPnrNumber(BigInteger.valueOf(10));
		passenger.setPassengerName(passengerDto.getPassengerName());
		passenger.setPassengerAge(passengerDto.getPassengerAge());
		passenger.setPassengerUIN(passengerDto.getPassengerUIN());
		passenger.setLuggage(Double.parseDouble((passengerDto.getLuggage().trim())));
		return bookingService.addPassenger(passenger, passengerDto.getBookingId());
	}
	@GetMapping("/ConfirmBooking/{bookingId}")
	public ResponseEntity<?> confirmBooking(@PathVariable BigInteger bookingId)
	{
		Booking booking = bookingService.finaliseBooking(bookingId);
		return ResponseEntity.ok(booking);
	}

	
	@PutMapping("/modifyBooking")
	public ResponseEntity<?> modifyBooking(@RequestBody Booking booking)
	{
		  return ResponseEntity.ok(bookingService.modifyBooking(booking));
	}
	@GetMapping("/viewAllBookings")
	public ResponseEntity<?> viewAllBookings()
	{
		return ResponseEntity.ok(bookingService.viewBookingList());
	}
	@GetMapping("/viewBooking/{userId}")
	public ResponseEntity<?> viewBookingByUserId(@PathVariable("userId") BigInteger userId)
	{
		return ResponseEntity.ok(bookingService.viewBooking(userId));
		
	}
	@DeleteMapping("/deleteBookingById/{bookingId}")
	public ResponseEntity<?> deleteBookingById(@PathVariable("bookingId") BigInteger bookingId)
	{
		bookingService.deleteBooking(bookingId);
		return  ResponseEntity.ok("booking - "  + bookingId + " deleted successfully");
	}
}
