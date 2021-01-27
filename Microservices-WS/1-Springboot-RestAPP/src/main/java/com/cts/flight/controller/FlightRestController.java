package com.cts.flight.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Flight;
import com.cts.flight.model.BookingQuery;

@RestController
@CrossOrigin
@RequestMapping("/api/pss")
public class FlightRestController {

	@Autowired
	private FlightDao flightDao;

	@GetMapping
	public List<Flight> findAllFlights() {
		return flightDao.findAll();
	}

	@GetMapping("/{id}")
	public Flight findFlightById(@PathVariable("id") int id) {
		System.out.println(">>>>>> GET <<<<<<<");
		return flightDao.findById(id).orElse(null);
	}

	@PostMapping
	public Flight bookFlightByOriginadnDestination(@RequestBody BookingQuery bookingQuery) {
		return flightDao.findFlightByFlightNumberAndOriginAndDestinationAndFlightDateAndFlightTime(bookingQuery.getFlightNumber(),bookingQuery.getOrigin(),bookingQuery.getDestination(),bookingQuery.getFlightDate(),bookingQuery.getFlightTime());
	}

}
