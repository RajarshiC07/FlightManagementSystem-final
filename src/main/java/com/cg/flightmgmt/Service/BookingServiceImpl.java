package com.cg.flightmgmt.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.DTO.BookingDTO;
import com.cg.flightmgmt.DTO.PassengerDTO;
import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Exceptions.BookingNotFoundException;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Exceptions.ScheduledFlightNotFoundException;
import com.cg.flightmgmt.Repository.BookingDao;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	ScheduleFlightServices scheduleFlightService;
	
	@Autowired
	UserService userService;
	
	@Override
	public Booking addBooking(BookingDTO bookingDto) {
		ScheduledFlight scheduledFlight = scheduleFlightService.viewScheduledFlightById(bookingDto.getScheduledFlightId());
		Users user = userService.viewUser(bookingDto.getUserId()); 
		if(!LocalDate.parse(bookingDto.getBookingDate()).equals(scheduledFlight.getSchedule().getArrivalTime().toLocalDate()))
			throw new  ScheduledFlightNotFoundException("Date is not available for this schedule");
		else
		{
			Booking booking  = new Booking();
			booking.setBookingId(BigInteger.valueOf(10));
			booking.setBookingDate(LocalDate.parse(bookingDto.getBookingDate()));
			booking.setScheduledFlight(scheduledFlight);
			booking.setUserId(user);
			if(Objects.nonNull(bookingDao.findById(booking.getBookingId()).orElse(null)))
			{
				throw new RecordAlreadyPresentException("Booking already done.");
			}
			else
				return bookingDao.save(booking);
		}
		
	}	
	public Booking addPassenger(PassengerDTO passengerDto)
	{
		validatePassenger(passengerDto);
		Booking bookingDb = bookingDao.findById(passengerDto.getBookingId()).orElse(null);
		if(Objects.isNull(bookingDb))
			throw new BookingNotFoundException("Booking not available");
		else if(bookingDb.getTicketCost() != null)
			throw new BookingNotFoundException("No Passengers");
	
		else
		{
			validateBooking(bookingDb);
			Passenger passenger = new Passenger();
			passenger.setPnrNumber(BigInteger.valueOf(10));
			passenger.setPassengerName(passengerDto.getPassengerName());
			passenger.setPassengerAge(passengerDto.getPassengerAge());
			passenger.setPassengerUIN(passengerDto.getPassengerUIN());
			passenger.setLuggage(Double.parseDouble((passengerDto.getLuggage().trim())));
			bookingDb.addPassenger(passenger,bookingDb.getPassengerList());
			bookingDb.setNoOfPassangers(bookingDb.getPassengerList().size());
			return bookingDao.save(bookingDb);
		}
			
	}

	public Booking viewBookingById(BigInteger BookingId)
	{
		return bookingDao.findById(BookingId).orElse(null);
	}
	
	public Booking finaliseBooking(BigInteger bookingId)
	{
		Booking bookingDb = bookingDao.findById(bookingId).orElse(null);
		if(Objects.isNull(bookingDb))
			throw new BookingNotFoundException("Booking not available");
		else if(bookingDb.getNoOfPassangers() == 0)
			throw new BookingNotFoundException("Booking cannot be confirmed as there are no passengers");
		else if(bookingDb.getTicketCost()!=null)
			throw new BookingNotFoundException("this booking has already been confirmed");
		else
		{
			ScheduledFlight scheduledFlight = bookingDb.getScheduledFlight();
			scheduledFlight.setAvailableSeats(scheduledFlight.getAvailableSeats()-bookingDb.getNoOfPassangers());
			scheduleFlightService.modifyScheduledFlight(scheduledFlight);
			bookingDb.setTicketCost(BigDecimal.valueOf(100.00*bookingDb.getNoOfPassangers()));
			return bookingDao.save(bookingDb);
		}
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		
		Booking book = bookingDao.findById(booking.getBookingId()).orElse(null);
		
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
	   
	    System.out.print(b1);
	    return b1;
	
	}	

	@Override
	public List<Booking> viewBookingList() {
		return bookingDao.findAll();
	}
	
	@Override
	public void deleteBooking(BigInteger bookingId)
	{
		Booking booking = bookingDao.findById(bookingId).orElse(null);
		if(Objects.isNull(booking))
		{
			throw new BookingNotFoundException("Booking not found");
		}
		else 
		{
			
			ScheduledFlight scheduledFlight = booking.getScheduledFlight();
			scheduledFlight.setAvailableSeats(scheduledFlight.getAvailableSeats()+booking.getNoOfPassangers());
			scheduleFlightService.modifyScheduledFlight(scheduledFlight);
			
			booking.setUserId(null);
			booking.setPassengerList(null);
			booking.setScheduledFlight(null);
			
			bookingDao.save(booking);
			bookingDao.deleteById(bookingId);
		}
	}
	
	@Override
	public void validateBooking(Booking booking) {
		
		LocalDate current = LocalDate.now();
        LocalDate bookingdate = booking.getBookingDate();
        if(bookingdate.isBefore(current)){
        	throw new BookingNotFoundException("Date passed");
        } 		
        if(booking.getNoOfPassangers()>booking.getScheduledFlight().getAvailableSeats())
        {
        	throw new BookingNotFoundException("No available seats");
        }
	}
	
	@Override
	public void validatePassenger(PassengerDTO passengerDto) {
		
		String s= String.valueOf(passengerDto.getPassengerUIN());
		if(s.length()!=12)
		{
			throw new BookingNotFoundException("Invalid passenger UIN");
		}
	}
}
