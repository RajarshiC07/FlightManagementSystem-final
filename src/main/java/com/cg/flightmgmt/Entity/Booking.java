package com.cg.flightmgmt.Entity;

import java.math.BigDecimal;
import java.math.BigInteger;
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

@Entity
public class Booking {

	@Id
	@Column(name="booking_Id")
	private BigInteger bookingId;
	
	@ManyToOne()
	@JoinColumn(name="user_Id", referencedColumnName="user_Id")
	private User userId;
	
	@Column(name="booking_Date")
	private Date bookingDate;
	
	@OneToMany(mappedBy="pnr_Number", targetEntity=Passenger.class, cascade=CascadeType.ALL)
	private List <Passenger>passengerList;
	
	@Column(name="ticket_Cost")
	private BigDecimal ticketCost;
	
	@OneToOne(targetEntity=ScheduledFlight.class,cascade=CascadeType.ALL)
	@JoinColumn(name="scheduled_FlightId",referencedColumnName="scheduled_FlightId")
	private ScheduledFlight scheduledFlight;
	
	@Column(name="noOf_Passangers")
	private int noOfPassangers;
	
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public BigDecimal getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(BigDecimal ticketCost) {
		this.ticketCost = ticketCost;
	}
	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}
	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}
	public int getNoOfPassangers() {
		return noOfPassangers;
	}
	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", scheduledFlight=" + scheduledFlight
				+ ", noOfPassangers=" + noOfPassangers + "]";
	}
	public Booking(BigInteger bookingId, User userId, Date bookingDate, List<Passenger> passengerList,
			BigDecimal ticketCost, ScheduledFlight scheduledFlight, int noOfPassangers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.scheduledFlight = scheduledFlight;
		this.noOfPassangers = noOfPassangers;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
