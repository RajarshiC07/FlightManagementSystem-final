package com.cg.flightmgmt.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Repository.BookingDao;

@SpringBootTest
class BookingServiceTest {

	@Autowired
	private BookingService bookingService;

	@MockBean
	private BookingDao bookingDao;

	Booking booking;

	@BeforeEach
	void setUp() throws Exception {

		booking = Booking.builder().bookingId(BigInteger.valueOf(4L)).noOfPassangers(3)
				.scheduledFlight(new ScheduledFlight()).ticketCost(BigDecimal.valueOf(10.76))
				.passengerList(new ArrayList<Passenger>()).userId(new Users()).bookingDate(LocalDate.now()).build();
		List<Booking> list = new ArrayList<Booking>() {
			{
				add(booking);
			}
		};
		Mockito.when(bookingDao.save(booking)).thenReturn(booking);
		Mockito.when(bookingDao.save(booking)).thenReturn(booking);
		Mockito.when(bookingDao.findAll()).thenReturn(list);
		Mockito.when(bookingDao.findById(BigInteger.valueOf(4L))).thenReturn(Optional.of(booking));
		doNothing().when(bookingDao).deleteById(BigInteger.valueOf(4L));

	}

	@Test
	@DisplayName("testing updated booking")
	void updateBooking() {
		assertEquals(booking , bookingService.modifyBooking(booking));
	}

	
	@Test
	@DisplayName("testing fetch all booking")
	void viewAllBooking() {
		
		List<Booking> list = new ArrayList<Booking>() {
			{
				add(booking);
			}
		};
		assertEquals(list, bookingService.viewBookingList());
		
	}
	}
	

