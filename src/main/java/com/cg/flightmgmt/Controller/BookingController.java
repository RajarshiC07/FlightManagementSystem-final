

package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
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

import com.cg.flightmgmt.DTO.BookingDTO;
import com.cg.flightmgmt.DTO.PassengerDTO;
import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Service.BookingService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	
	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody BookingDTO bookingDto)
	{
		
				Booking bookingDb = bookingService.addBooking(bookingDto);
				return bookingDb;
	
	}
	@PostMapping("/addPassenger")
	public Booking addBooking(@RequestBody PassengerDTO passengerDto)
	{
		
			
			return bookingService.addPassenger(passengerDto);
		
	}
	@GetMapping("/ConfirmBooking/{bookingId}")
	public Booking confirmBooking(@PathVariable BigInteger bookingId)
	{
			Booking booking = bookingService.finaliseBooking(bookingId);
			return booking;	
	}

	
	@PutMapping("/modifyBooking")
	public Booking modifyBooking(@RequestBody Booking booking)
	{
		
		return bookingService.modifyBooking(booking);
			
	}
	@GetMapping("/viewAllBookings")
	public List<Booking> viewAllBookings()
	{
		
				return bookingService.viewBookingList();
			
	}
	@GetMapping("/viewBooking/{userId}")
	public List<Booking> viewBookingByUserId(@PathVariable("userId") BigInteger userId)
	{
	
			return bookingService.viewBooking(userId);
		
	}
	@DeleteMapping("/deleteBookingById/{bookingId}")
	public String deleteBookingById(@PathVariable("bookingId") BigInteger bookingId)
	{
	
			bookingService.deleteBooking(bookingId);
			return ("booking - "  + bookingId + " deleted successfully");
	}
	@GetMapping("/bookingById/{bookingId}")
	public Booking bookingById(@PathVariable("bookingId") BigInteger bookingId)
	{
		return bookingService.viewBookingById(bookingId);
	}
}
