package com.cg.flightmgmt.DTO;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduledFlightDTO {

	private BigInteger flightNumber;
	private Integer availableSeats;
	private String sourceAirportCode;
	private String destinationAirportCode;
	private String arrivalTime;
	private String departureTime;

}
