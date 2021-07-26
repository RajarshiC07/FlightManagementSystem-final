package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Exceptions.BookingNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Repository.BookingDao;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	
	@Override
	public Booking addBooking(Booking booking) {
		
		if(Objects.nonNull(bookingDao.getById(booking.getBookingId())))
		{
			throw new RecordAlreadyPresentException("Booking already done.");
		}
		else
		return bookingDao.save(booking);
		
	}	
		
	@Override
	public Booking modifyBooking(Booking booking) {
		
		Booking book = bookingDao.findById(booking.getBookingId()).get();
		
		if(Objects.isNull(book)) {
			throw new BookingNotFoundException("Booking not available");
		}
		else
		{
			if(Objects.nonNull(booking.getUserId()))
			{
				book.setUserId(booking.getUserId());
			}
			if(Objects.nonNull(booking.getBookingDate()))
			{
				book.setBookingDate(booking.getBookingDate());
			}
			if(Objects.nonNull(booking.getPassengerList()))
			{
				book.setPassengerList(booking.getPassengerList());
			}
			if(Objects.nonNull(booking.getTicketCost()))
			{
				book.setTicketCost(booking.getTicketCost());
			}
			if(Objects.nonNull(booking.getScheduledFlight()))
			{
				book.setScheduledFlight(booking.getScheduledFlight());
			}
			if(Objects.nonNull(booking.getNoOfPassangers()))
			{
				book.setNoOfPassangers(booking.getNoOfPassangers());
			}
		}
		return bookingDao.save(book);
	}
	
	@Override
	public List<Booking> viewBooking(BigInteger userId) {
		// TODO Auto-generated method stub
		List<Booking> b =new ArrayList<Booking>();
	    b=bookingDao.findAll();
	    List<Booking> b1 =new ArrayList<Booking>();
	    for(int i=0; i<b.size();i++)
	    {
	    	if(b.get(i).getUserId().getUserId().compareTo(userId)==0)
	    	{
	    		b1.add(b.get(i));
	    	}
	    }
	    return b1;
	
	}	

	@Override
	public List<Booking> viewBookingList() {
		return bookingDao.findAll();
	}
	
	@Override
	public void deleteBooking(BigInteger bookingId)
	{
		if(Objects.isNull(bookingDao.getById(bookingId)))
		{
			throw new BookingNotFoundException("Booking not found");
		}
		else 
		bookingDao.deleteById(bookingId);
	}
	
	@Override
	public void validateBooking(Booking booking) {
		
		Date current = new Date();
        Date bookingdate = booking.getBookingDate();
        if(bookingdate.before(current)){
        	throw new BookingNotFoundException("Date passed");
        } 		
        if(booking.getNoOfPassangers()>booking.getScheduledFlight().getAvailableSeats())
        {
        	throw new BookingNotFoundException("No available seats");
        }
	}
	
	@Override
	public void validatePassenger(Passenger passenger) {
		
		String s= String.valueOf(passenger.getPassengerUIN());
		if(s.length()!=12)
		{
			throw new BookingNotFoundException("Invalid passenger UIN");
		}
	}
}
