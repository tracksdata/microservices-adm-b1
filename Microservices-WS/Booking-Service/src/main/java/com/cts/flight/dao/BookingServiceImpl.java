package com.cts.flight.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Passenger;

@Service
public class BookingServiceImpl {

	@Autowired
	private BookingRecordDao bookingRecordDao;

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate testRemplate() {
		return new RestTemplate();
	}

	private String findFlightUrl = "http://localhost:8082/api/search";
	private String fareUrl = "http://localhost:8081/api/fare/";

	public void bookFlight( int id, int numberofPassenger) {
		System.out.println(">>> ID:   "+id);

		Fare fare = null;
		Flight flight = null;
		System.out.println(">>>>>>>>");
		try {
			fare = restTemplate.getForObject(fareUrl + "/" + id, Fare.class);
			//flight = restTemplate.getForObject(findFlightUrl + "/" + id, Flight.class);

			System.out.println("Fare is " + fare.getFare());
			//System.out.println("Flight: " + flight.getFlightNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
