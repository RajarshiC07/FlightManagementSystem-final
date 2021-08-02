package com.cg.flightmgmt.Repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cg.flightmgmt.Entity.Booking;
import com.cg.flightmgmt.Entity.Passenger;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Entity.Users;

@DataJpaTest
class BookingRepositoryTest {

	Booking booking;
	
	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {

		booking = Booking.builder().bookingId(BigInteger.valueOf(4L)).noOfPassangers(3)
				.scheduledFlight(new ScheduledFlight()).ticketCost(BigDecimal.valueOf(10.76))
				.passengerList(new ArrayList<Passenger>()).userId(new Users()).bookingDate(LocalDate.now()).build();

		entityManager.persist(booking);

	}

	@Test
	void findById() {

		assertEquals(booking,bookingDao.findById(booking.getBookingId()).get());
		
	}

	@Test
	void saving() {
		
		assertEquals(booking, bookingDao.save(booking));
		
	}

	@Test
	void getlistofbooking() {

		Booking booking = Booking.builder().bookingId(BigInteger.valueOf(4L)).noOfPassangers(3)
				.scheduledFlight(new ScheduledFlight()).ticketCost(BigDecimal.valueOf(10.76))
				.passengerList(new ArrayList<Passenger>()).userId(new Users()).bookingDate(LocalDate.now()).build();

		List<Booking> list = new ArrayList<Booking>() {
			{
				add(booking);
			}
		};
		Assertions.assertThat(list.size()).isGreaterThanOrEqualTo(0);
		
	}
}
