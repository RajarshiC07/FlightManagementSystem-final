package com.cg.flightmgmt.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Flight {
@Id
@Column(name="flight_Number")
private BigInteger flightNumber;
@Column(name="carrier_Name")
private String carrierName;
@Column(name="flight_Model")
private String flightModel;
@Column(name="seat_Capacity")
private Integer seatCapacity;
public Flight(BigInteger flightNumber, String carrierName, String flightModel, Integer seatCapacity) {
	super();
this.flightNumber = flightNumber;
this.carrierName = carrierName;
this.flightModel = flightModel;
this.seatCapacity = seatCapacity;
}
public Flight() {
	super();
	// TODO Auto-generated constructor stub
}
public BigInteger getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(BigInteger flightNumber) {
	this.flightNumber = flightNumber;
}
public String getCarrierName() {
	return carrierName;
}
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
public String getFlightModel() {
	return flightModel;
}
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
public Integer getSeatCapacity() {
	return seatCapacity;
}
public void setSeatCapacity(Integer seatCapacity) {
	this.seatCapacity = seatCapacity;
}
@Override
public String toString() {
	return "Flight [flightNumber=" + flightNumber + ", carrierName=" + carrierName + ", flightModel=" + flightModel
			+ ", seatCapacity=" + seatCapacity + "]";
}

}
