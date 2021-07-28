package com.cg.flightmgmt.Entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Booking {

	@Id
	@Column(name="booking_Id")
	private BigInteger bookingId;
	
	@ManyToOne()
	@JoinColumn(name="user_Id", referencedColumnName="user_Id")
	private Users userId;
	
	@Column(name="booking_Date")
	private Date bookingDate;
	
	@Builder.Default
	@OneToMany(mappedBy="pnrNumber", targetEntity=Passenger.class, cascade=CascadeType.ALL)
	private List <Passenger>passengerList = new ArrayList<Passenger>();
	
	@Column(name="ticket_Cost")
	private BigDecimal ticketCost;
	
	@OneToOne(targetEntity=ScheduledFlight.class,cascade=CascadeType.ALL)
	@JoinColumn(name="scheduled_FlightId",referencedColumnName="scheduled_FlightId")
	private ScheduledFlight scheduledFlight;
	
	@Column(name="noOf_Passangers")
	private int noOfPassangers;
	
	public void addPassenger(Passenger psngr)
	{
		passengerList.add(psngr);
	}
	
	
}
