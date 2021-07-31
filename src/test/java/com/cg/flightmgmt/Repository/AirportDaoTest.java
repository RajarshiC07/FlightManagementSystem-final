package com.cg.flightmgmt.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.*;
import com.cg.flightmgmt.Entity.Airport;




@DataJpaTest
public class AirportDaoTest {
	Airport airport;
	
	@Autowired
	private AirportDao airportDao;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception{
		
		airport = Airport.builder().airportCode("Kol").airportName("Bagdogra").airportLocation("Siliguri").build();
		entityManager.persist(airport);
	}
	
	
	@Test
	void saveAirportTest() {
		assertEquals(airport, airportDao.save(airport));
	}
	
	
	
	@Test
	public void	getAirportTest(){
		String airportCode=new String("Kol");
		Airport airport= airportDao.findById(airportCode).get();
		
		Assertions.assertThat(airport.getAirportCode()).isEqualTo(airportCode);
		}

	
	
	@Test
	public void getListOfAirports()
	{
		List<Airport> airport=airportDao.findAll();
		Assertions.assertThat(airport.size()).isGreaterThanOrEqualTo(0);
	}
	
	
		
	}