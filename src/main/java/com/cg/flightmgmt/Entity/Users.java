package com.cg.flightmgmt.Entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Column(name="user_Type")
	private String userType;
	
	@Id
	@Column(name="user_Id")
	private BigInteger userId;
	
	@Column(name="user_Name")
	private String userName;
	
	@Column(name="user_Password")
	private String userPassword;

	@Column(name="user_Phone")
	private BigInteger userPhone;
	
	@Column(name="user_Email")
	private String userEmail;
	
	@OneToMany(mappedBy="bookingId", targetEntity=Booking.class, cascade=CascadeType.ALL)
	private List <Booking>bookingList = new ArrayList<Booking>();
	
	public void addBooking(Booking bkg)
	{
		bookingList.add(bkg);
	}
	public List<Booking> getBookingList() {
		return bookingList;
	}
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public BigInteger getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Users(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone,
			String userEmail) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userType=" + userType + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	} 
	
	
}
