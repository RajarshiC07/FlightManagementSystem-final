package com.cg.flightmgmt.Entity;

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

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="schedule_Id")
	private int scheduleId;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="airport_Code",referencedColumnName="airport_Code")
	@Column(name="source_Airport")
	private  Airport sourceAirport;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="airport_Code",referencedColumnName="airport_Code")
	@Column(name="destination_Airport")
	private  Airport destinationAirport;
	
	@Column(name="arrival_Time")
	private  LocalDateTime arrivalTime;
	
	@Column(name="departure_Time")
	private LocalDateTime departureTime;
	
	
	
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Schedule [sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	} 
	
	
}
