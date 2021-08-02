package com.cg.flightmgmt.DTO;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDTO {
	private BigInteger bookingId;
	private String passengerName;
	private int passengerAge;
	private BigInteger passengerUIN;
	private String luggage;

}
