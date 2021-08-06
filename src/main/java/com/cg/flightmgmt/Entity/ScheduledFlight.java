package com.cg.flightmgmt.Entity;

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
public class ScheduledFlight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="scheduled_FlightId")
	private int scheduledFlightId;
	
	@OneToOne(targetEntity=Flight.class,cascade=CascadeType.ALL)
	@JoinColumn(name="flight_Number",referencedColumnName="flight_Number")
	private Flight flight;
	
	@Column(name="available_Seats")
	private Integer availableSeats;
	
	@OneToOne(targetEntity=Schedule.class,cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_Id",referencedColumnName="schedule_Id")
	private Schedule schedule;

}