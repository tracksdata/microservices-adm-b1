package com.cts.flight.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.controller.Sender;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Passenger;

@Service
public class BookingServiceImpl implements BookingRecordService {

	@Autowired
	private BookingRecordDao bookingRecordDao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Sender sender;

	@Bean
	public RestTemplate testRemplate() {
		return new RestTemplate();
	}

	private String findFlightUrl = "http://localhost:8082/api/search";
	private String fareUrl = "http://localhost:8081/api/fare/";

	public BookingRecord bookFlight(Passenger passenger, int id, int numberofPassenger) {
		System.out.println(">>> ID:   " + id);

		Fare fare = null;
		Flight flight = null;

		BookingRecord bookingRecord = null;
		try {
			fare = restTemplate.getForObject(fareUrl + "/" + id, Fare.class);
			flight = restTemplate.getForObject(findFlightUrl + "/" + id, Flight.class);

			if (flight.getInventory().getCount() < numberofPassenger) {
				System.out.println(">>>>>>>>>>>>> No More Seats Available <<<<<<<<<<<<<<<<<");
			}

			if (flight != null) {
				bookingRecord = new BookingRecord(flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(),
						flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(),
						flight.getFare().getFare(), passenger, flight.getAirlineInfo(), "CONFIRMED");
				bookingRecord.setFare(fare.getFare() * numberofPassenger);
				if (passenger.getCopassengers().size() == numberofPassenger - 1) {
					bookingRecordDao.save(bookingRecord);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// SEND Booking Info to Search Microservice via RabbitMQ to update into DB

		Map<String, Object> bookingDetails = new HashMap<String, Object>();
		bookingDetails.put("FLIGHT_NUMBER", flight.getFlightNumber());
		bookingDetails.put("FLIGHTDATE", flight.getFlightDate());
		bookingDetails.put("NEW_INVENTORY", numberofPassenger);

		sender.sendInventoryData(bookingDetails);

		return bookingRecord;

	}

	public void updateStatus(String status, int bookingId) {

		BookingRecord br = bookingRecordDao.findById(bookingId).orElse(null);

		if (br != null) {
			System.out.println(">>>>>> Updating status from CONFIRMED to CHECKEDIN");
			br.setStatus("CHECKEDIN");
			bookingRecordDao.save(br);
		}

	}

	public BookingRecord getBookingData(int bookingId) {
		return bookingRecordDao.findById(bookingId).orElse(null);
	}

}
