package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.BookingServiceImpl;
import com.cts.flight.entity.Passenger;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingRestController {

	@Autowired
	private BookingServiceImpl bs;

	@GetMapping("/{id}/{numberofPassengers}")
	public String test(@PathVariable("id") int id,@PathVariable("numberofPassengers")int numberofPassengers) {
		
		 bs.bookFlight( id, numberofPassengers);
		 
		 return "Hello";
	}

}
