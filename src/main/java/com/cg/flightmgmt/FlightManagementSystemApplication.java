package com.cg.flightmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.flightmgmt.Repository.AirportDao;


@SpringBootApplication
public class FlightManagementSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(FlightManagementSystemApplication.class, args);

	}
}