package com.cg.flightmgmt.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Passenger {

	@Id
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
	
	@ManyToOne()
	@JoinColumn(name="booking_Id", referencedColumnName="booking_Id")
	private Booking booking;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(BigInteger pnrNumber, String passengerName, int passengerAge, BigInteger passengerUIN,
			Double luggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}
	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
	}
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
	
}
