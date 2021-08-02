package com.cg.flightmgmt.Entity;

import java.math.BigInteger;

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
}
