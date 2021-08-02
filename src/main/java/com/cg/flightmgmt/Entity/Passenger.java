package com.cg.flightmgmt.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pnr_Number")
	private BigInteger pnrNumber;
	@Column(name="passenger_Name")
	private String passengerName;
	@Column(name="passenger_Age")
	private int passengerAge;
	@Column(name="passenger_UIN")
	private BigInteger passengerUIN;
	@Column(name="luggage")
	private Double luggage;
}
