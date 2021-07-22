package com.cg.flightmgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.Entity.ScheduledFlight;
@Repository("ScheduledFlightDao")
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight,Integer>{

}
