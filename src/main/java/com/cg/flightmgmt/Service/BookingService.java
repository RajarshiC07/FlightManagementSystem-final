package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.DTO.PassengerDTO;
import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;

public interface BookingService {

	public Booking addBooking(Booking booking);
	
	public ResponseEntity<?> addPassenger(Passenger passenger,BigInteger bookingId);
	
	public Booking finaliseBooking(BigInteger bookingId);
	
	public Booking modifyBooking(Booking booking);	
	
	public List<Booking> viewBooking(BigInteger bookingId);
	
	public List<Booking> viewBookingList();
	
	public void deleteBooking(BigInteger bookingId);
	
	public void validateBooking(Booking booking);
	
	public void validatePassenger(PassengerDTO passengerDto);
}