package com.cts.flight.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

public interface BookingService {


	BookingRecord bookFlight(Passenger passenger, int id, int numberofPassenger);

	void updateStatus(String status, int bookingId);

	BookingRecord getBookingData(int bookingId);

}