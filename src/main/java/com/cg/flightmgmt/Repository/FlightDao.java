package com.cg.flightmgmt.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.Entity.Flight;
@Repository("FlightDao")
public interface FlightDao extends JpaRepository<Flight,BigInteger>{

}
