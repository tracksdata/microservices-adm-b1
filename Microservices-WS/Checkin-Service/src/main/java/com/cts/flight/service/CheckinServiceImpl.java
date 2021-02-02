package com.cts.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cts.flight.controller.Sender;
import com.cts.flight.dao.CheckinDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.CheckIn;

@Service
public class CheckinServiceImpl implements CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Sender sender;
	private String bookingURL = "http://localhost:8083/api/booking"; // communicates with booking service and gets booking details

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public CheckIn checkIn(int bookingId) {
		CheckIn checkinObj = null;

		// call booking-service to get know whether booking was done or not
		BookingRecord bookingRecord = restTemplate.getForObject(bookingURL + "/" + bookingId, BookingRecord.class);

		if (bookingRecord != null) { // booking existed

			checkinObj = new CheckIn();
			checkinObj.setBookingRecord(bookingRecord);
			
			checkinObj.setCheckinTime(LocalDateTime.now());
			
			checkinObj.setSeatNumber("A3");

			checkinDao.save(checkinObj);
			
			// Send bookingId to Booking-Service Microservice via RabbitMQ to update the
			// status to CHECKEDIN from 'CONFIRMED'
			sender.send(bookingId);
		}

		return checkinObj;
	}

	public CheckIn getCheckInInfo(int bookingId) {

		CheckIn checkIn = checkinDao.findByBookingId(bookingId);
		if (checkIn == null) {
			return null; // Not yet checked in for this bookingId
		}
		return checkIn;
	}

	@Override
	public CheckIn findByCheckinId(int checkinId) {
		// TODO Auto-generated method stub
		return checkinDao.findById(checkinId).orElse(null);
	}

}
