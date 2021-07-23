package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.Entity.Flight;

@SpringBootTest
class FlightManagementSystemApplicationTests {
	Flight flight;
	@BeforeAll
	void contextLoads() {
		flight=new Flight(new BigInteger("123"),"AirIndia","A1111",200);
	}
	@Test
	void testing()
	{
		assertEquals("AirIndia",flight.getCarrierName());
		assertEquals("A1111",flight.getFlightModel());
		assertEquals(200,flight.getSeatCapacity().intValue());
	}

}
