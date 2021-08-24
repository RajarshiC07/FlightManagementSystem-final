package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.DTO.BookingDTO;
import com.cg.flightmgmt.DTO.PassengerDTO;
import com.cg.flightmgmt.Entity.Booking;

public interface BookingService {

	public Booking addBooking(BookingDTO bookingDto);
	
	public Booking addPassenger(PassengerDTO passengerDto);
	
	public Booking finaliseBooking(BigInteger bookingId);
	
	public Booking modifyBooking(Booking booking);	
	
	public List<Booking> viewBooking(BigInteger bookingId);
	
	public List<Booking> viewBookingList();
	
	public void deleteBooking(BigInteger bookingId);
	
	public void validateBooking(Booking booking);
	
	public void validatePassenger(PassengerDTO passengerDto);
	
	public Booking viewBookingById(BigInteger bookingId);
}