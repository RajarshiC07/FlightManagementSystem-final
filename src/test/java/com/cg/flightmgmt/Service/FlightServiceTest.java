package com.cg.flightmgmt.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import java.math.BigInteger;
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

import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Repository.FlightDao;
import com.cg.flightmgmt.Service.FlightService;


@SpringBootTest
class FlightServiceTest {

	@Autowired
	private FlightService flightService;
	
	@MockBean
	private FlightDao flightDao;
	
	Flight flight;
	
	@BeforeEach
    void setUp() throws Exception {
        
        flight = Flight.builder().carrierName("ABC").flightModel("AV-001").seatCapacity(100).flightNumber(BigInteger.valueOf(0L)).build();
        List<Flight> list = new ArrayList<Flight>(){ {add(flight);}};
        Mockito.when(flightDao.save(flight)).thenReturn(flight);
        Mockito.when(flightDao.findAll()).thenReturn(list);
        Mockito.when(flightDao.findById(BigInteger.valueOf(0L))).thenReturn(Optional.of(flight));
    }
	
	 @Test
	    @DisplayName("testing adding the flight")
	    void addFlightTest()
	    {
		 Mockito.when(flightDao.findById(BigInteger.valueOf(0L))).thenReturn(Optional.ofNullable(null));
	        assertEquals(flight,flightService.addFlight(flight));
	    }
	 
	 @Test
	    @DisplayName("testing modifying the flight")
	    void modifyFlightTest()
	    {
	       // assertEquals(flight,flightService.modifyFlight(flight));
	    }
	 
	 @Test
	    @DisplayName("testing viewing the Flight by flight_number")
	    void viewFlightTest() {
	        BigInteger flightNumber=BigInteger.valueOf(0L); 
	        Flight found = flightService.viewFlight(flightNumber);
	        assertEquals(flightNumber, found.getFlightNumber());    
	    }

	 @Test
	    @DisplayName("viewing all flights")
	    void viewAllFlightTest()
	    {
	        List<Flight> list = new ArrayList<Flight>(){ {add(flight);}};
	        assertEquals(list,flightService.viewFlight());
	    }

}
