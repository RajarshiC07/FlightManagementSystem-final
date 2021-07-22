package com.cg.flightmgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.Entity.Airport;
@Repository("AirportDao")
public interface AirportDao extends JpaRepository<Airport,String>{

}
