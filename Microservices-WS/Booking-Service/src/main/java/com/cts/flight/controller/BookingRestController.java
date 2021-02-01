package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.BookingRecordService;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingRestController {

	@Autowired
	private BookingRecordService bs;

	@PostMapping("/{id}/{numberofPassengers}")
	public BookingRecord test(@RequestBody Passenger passenger, @PathVariable("id") int id,
			@PathVariable("numberofPassengers") int numberofPassengers) {

		return bs.bookFlight(passenger, id, numberofPassengers);
	}

	@GetMapping("/{bookingId}")
	public BookingRecord getBookingInfo(@PathVariable("bookingId") int bookingId) {

		return bs.getBookingData(bookingId);
	}

}
