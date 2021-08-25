package com.cg.flightmgmt.Service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Repository.AirportDao;
import com.cg.flightmgmt.Service.AirportService;


@SpringBootTest
public class AirportServiceTest {
	
	
	    @Autowired
	    private AirportService airportService;
	    
	    @MockBean
	    private AirportDao airportDao;
	    
	    Airport airport;
	    

	    @BeforeEach
	    void setUp() throws Exception {
	        
	        airport = Airport.builder().airportCode("Kol").airportName("Bagdogra").airportLocation("Siliguri").build();
	        List<Airport> list = new ArrayList<Airport>(){ {add(airport);}};
	    
	        Mockito.when(airportDao.save(airport)).thenReturn(airport);
	        Mockito.when(airportDao.findAll()).thenReturn(list);
	        Mockito.when(airportDao.findById("Kol")).thenReturn(Optional.of(airport));
	        doNothing().when(airportDao).deleteById("Kol");
	    }

	    @Test
	    @DisplayName("testing view all airports")
	    void viewAllAirportTest()
	    {
	        List<Airport> list = new ArrayList<Airport>(){ {add(airport);}};
	        assertEquals(list,airportService.viewAirport());
	    }

	    @Test
	    @DisplayName("testing adding the Airport")
	    void addAirportTest()
	    {
	    	ResponseEntity ar=new ResponseEntity<Airport>(airport,HttpStatus.CREATED);
	    	Mockito.when(airportDao.findById("Kol")).thenReturn(Optional.ofNullable(null));
	        assertEquals(ar,airportService.addAirport(airport));
	    }
	    
	    @Test
	    @DisplayName("testing viewing the airport  by airport_Code")
	    void viewAirporttByCodeTest() {
	       // String airportCode = "Kol";
	      //Airport found = airportService.viewAirport(airportCode);
	        assertEquals(airport.getAirportName(), airportService.viewAirport("Kol").getAirportName());    
	    }
	    
	    @Test
	    @DisplayName("testing modifying the Airport")
	    void modifyAirportTest()
	    {
	    	
	      //  assertEquals(ResponseEntity.ok(airport.getAirportCode()+" has been modified"),airportService.modifyAirport(airport));
	    }
	    
}