package com.cg.flightmgmt.Entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="schedule_Id")
	private int scheduleId;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="source_airport_Code",referencedColumnName="airport_Code")
	private  Airport sourceAirport;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="destination_airport_Code",referencedColumnName="airport_Code")
	private  Airport destinationAirport;
	
	@Column(name="arrival_Time")
	private  LocalDateTime arrivalTime;
	
	@Column(name="departure_Time")
	private LocalDateTime departureTime;
	
}
