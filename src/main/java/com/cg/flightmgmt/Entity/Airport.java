package com.cg.flightmgmt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Airport {
	@Id
	@Column(name="airport_Code")
	private String airportCode;
	@Column(name="airport_Name")
	private String airportName;
	@Column(name="airport_Location")
	private String airportLocation;

}
