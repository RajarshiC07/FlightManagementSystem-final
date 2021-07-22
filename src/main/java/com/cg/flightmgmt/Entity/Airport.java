package com.cg.flightmgmt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {
	@Id
	@Column(name="airport_Code")
	private String airportCode;
	@Column(name="airport_Name")
	private String airportName;
	@Column(name="airport_Location")
	private String airportLocation;
	
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
	public Airport()
	{
		
	}
	public Airport(String airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
	
}
