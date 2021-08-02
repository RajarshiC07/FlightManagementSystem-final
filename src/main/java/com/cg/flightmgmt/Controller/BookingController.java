

package com.cg.flightmgmt.Controller;

import java.math.BigInteger;

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
import com.cg.flightmgmt.Service.BookingService;


@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	
	@PostMapping("/addBooking")
	public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDto)
	{
		if(UserServiceController.logValidator == 1)
		{
				Booking bookingDb = bookingService.addBooking(bookingDto);
				return ResponseEntity.ok("Your booking has been added with booking id "+bookingDb.getBookingId());
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	@PostMapping("/addPassenger")
	public ResponseEntity<?> addBooking(@RequestBody PassengerDTO passengerDto)
	{
		if(UserServiceController.logValidator == 1)
		{
			
			return bookingService.addPassenger(passengerDto);
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	@GetMapping("/ConfirmBooking/{bookingId}")
	public ResponseEntity<?> confirmBooking(@PathVariable BigInteger bookingId)
	{
		if(UserServiceController.logValidator == 1)
		{
			Booking booking = bookingService.finaliseBooking(bookingId);
			return ResponseEntity.ok("Your booking has been confirmed with booking id "+booking.getBookingId());
		}
			else
				return ResponseEntity.ok("You have not logged in yet");
	}

	
	@PutMapping("/modifyBooking")
	public ResponseEntity<?> modifyBooking(@RequestBody Booking booking)
	{
		if(UserServiceController.logValidator == 1)
		{
			if(UserServiceController.UserType.equalsIgnoreCase("admin"))
			{
				return ResponseEntity.ok(bookingService.modifyBooking(booking));
			}
			else
				return ResponseEntity.ok("You don't have admin privileges");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	@GetMapping("/viewAllBookings")
	public ResponseEntity<?> viewAllBookings()
	{
		if(UserServiceController.logValidator == 1)
		{
			if(UserServiceController.UserType.equalsIgnoreCase("admin"))
			{
				return ResponseEntity.ok(bookingService.viewBookingList());
			}
			else
				return ResponseEntity.ok("You don't have admin privileges");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	@GetMapping("/viewBooking/{userId}")
	public ResponseEntity<?> viewBookingByUserId(@PathVariable("userId") BigInteger userId)
	{
		if(UserServiceController.logValidator == 1)
		{
			return ResponseEntity.ok(bookingService.viewBooking(userId));
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
		
	}
	@DeleteMapping("/deleteBookingById/{bookingId}")
	public ResponseEntity<?> deleteBookingById(@PathVariable("bookingId") BigInteger bookingId)
	{
		if(UserServiceController.logValidator == 1)
		{
			bookingService.deleteBooking(bookingId);
			return  ResponseEntity.ok("booking - "  + bookingId + " deleted successfully");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
}
