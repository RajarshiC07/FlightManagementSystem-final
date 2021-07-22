package com.cg.flightmgmt.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
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

	public int getScheduledFlightId() {
		return scheduledFlightId;
	}

	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduledFlight(int scheduledFlightId, Flight flight, Integer availableSeats, Schedule schedule) {
		super();
		this.scheduledFlightId = scheduledFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", flight=" + flight + ", availableSeats="
				+ availableSeats + ", schedule=" + schedule + "]";
	}
	
}