package com.cg.flightmgmt.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.cg.flightmgmt.Entity.Airport;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;
import com.cg.flightmgmt.Repository.ScheduledFlightDao;

@DataJpaTest
class ScheduledFlightServiceTest {
	FlightService flightservice;
ScheduledFlight scheduledflight;
Flight flight;
Schedule schedule;

	@Autowired
	private ScheduleFlightServices scheduledflightservice;
	
	@MockBean
	private ScheduledFlightDao scheduledflightDao;
	
	
	@BeforeEach
    void setUp() throws Exception {
        
        scheduledflight = 	ScheduledFlight.builder().availableSeats(5).flight(flight).schedule(schedule).scheduledFlightId(101).build();
        List<ScheduledFlight> list = new ArrayList<ScheduledFlight>(){ {add(scheduledflight);}};
        Mockito.when(scheduledflightDao.save(scheduledflight)).thenReturn(scheduledflight);
        Mockito.when(scheduledflightDao.findAll()).thenReturn(list);
        Mockito.when(scheduledflightDao.findById(101)).thenReturn(Optional.of(scheduledflight));
    }
	
	@Test
    @DisplayName("testing adding the scheduledflight")
    void addFlightTest()
    {
        Assertions.assertEquals(scheduledflight,scheduledflightservice.scheduleFlight(scheduledflight));
    }
 
 @Test
    @DisplayName("testing modifying the scheduledflight")
    void modifyFlightTest()
    {
	 Assertions.assertEquals(scheduledflight, scheduledflightservice.modifyScheduledFlight(scheduledflight));
    }
 
 

 @Test
    @DisplayName("viewing all scheduled flights")
    void viewAllFlightTest()
    {
        List<ScheduledFlight> list = new ArrayList<ScheduledFlight>(){ {add(scheduledflight);}};
        Assertions.assertEquals(list,scheduledflightservice.viewScheduledFlight());
    }


}