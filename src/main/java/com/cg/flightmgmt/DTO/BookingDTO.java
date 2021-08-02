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
public class BookingDTO {
	
		//private BigInteger bookingId;
		private BigInteger userId;
		private String bookingDate;
		private int scheduledFlightId;
}
