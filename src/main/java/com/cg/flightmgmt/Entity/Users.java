package com.cg.flightmgmt.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Column(name="user_Type")
	private String userType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}
