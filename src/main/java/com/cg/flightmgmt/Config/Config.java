package com.cg.flightmgmt.Config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Entity.Users;

@Configuration
public class Config {
	@Bean("Users")
	public Users getUsers()
	{
		Users users = new Users();
		users.setUserId(new BigInteger("1"));
		users.setUserName("ravi");
		users.setUserEmail("abc@gmail");
		users.setUserPassword("aysuid");
		users.setUserType("acc");
		users.setUserPhone(new BigInteger("89575"));
		return users;
	}
	@Bean("Airport")
	public Airport getAirport()
	{
		Airport airport = new Airport();
		airport.setAirportCode("ap192");
		airport.setAirportName("delhi");
		airport.setAirportLocation("india");
		return airport;
	}
	@Bean("Flight")
	public Flight getFlight()
	{
		Flight flight = new Flight();
		flight.setFlightNumber(new BigInteger("1826"));
		flight.setCarrierName("plane");
		flight.setFlightModel("bxb");
		flight.setSeatCapacity(100);
		return flight;
	}
	@Bean("Passenger")
	public Passenger getPassenger()
	{
		Passenger passenger = new Passenger();
		passenger.setPnrNumber(new BigInteger("1"));
		passenger.setPassengerUIN(new BigInteger("111"));
		passenger.setPassengerName("abc");
		passenger.setLuggage(120.48);
		passenger.setPassengerAge(90);
		return passenger;
	}
	@Bean("Schedule")
	public Schedule getSchedule()
	{
		Schedule schedule = new Schedule();
		schedule.setArrivalTime(LocalDateTime.now());
		schedule.setDepartureTime(LocalDateTime.now());
		return schedule;
	}
	@Bean("ScheduleFlight")
	public ScheduledFlight getScheduledFlight()
	{
		ScheduledFlight scheduledFlight = new ScheduledFlight();
		scheduledFlight.setAvailableSeats(200);
		return scheduledFlight;
	}
	@Bean("Booking")
	public Booking getBooking()
	{
		Booking booking = new Booking();
		booking.setBookingId(new BigInteger("10"));
		booking.setBookingDate(LocalDate.now());
		booking.setNoOfPassangers(200);
		booking.setTicketCost(new BigDecimal("100.38"));
		return booking;
	}
}
