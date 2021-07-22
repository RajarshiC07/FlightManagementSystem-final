package com.cg.flightmgmt.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.Entity.Booking;
@Repository("BookingDao")
public interface BookingDao extends JpaRepository<Booking,BigInteger>{

}
