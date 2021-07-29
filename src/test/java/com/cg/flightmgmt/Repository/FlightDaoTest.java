package com.cg.flightmgmt.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cg.flightmgmt.Entity.Flight;

@DataJpaTest
class FlightDaoTest {

 Flight flight;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setup()
	{
		flight=Flight.builder().carrierName("ABC").flightModel("XYZ").flightNumber(BigInteger.valueOf(0L)).build();
		entityManager.persist(flight);
	}
	
	@Test
	public void saveFlightTest()
	{
	
	  assertEquals(flight, flightDao.save(flight));   
	}
	
	
	
	@Test
	public void	getFlightTest(){
		BigInteger flightNumber=BigInteger.valueOf(0L);
		Flight flight= flightDao.findById(flightNumber).get();
		
		Assertions.assertThat(flight.getFlightNumber()).isEqualTo(flightNumber);
		}

	
	
	@Test
	public void getListOfFlights()
	{
		List<Flight> flight=flightDao.findAll();
		assertThat(flight.size()).isGreaterThanOrEqualTo(0);
	}
	
	
}
