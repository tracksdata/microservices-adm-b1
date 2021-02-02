package com.cts.flight.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cts.flight.service.BookingService;

@Controller
public class Receiver {

	@Autowired
	private BookingService bookingSerice;



	@RabbitListener(queues = "CheckinQ")
	public void processMessage(int bookingId) {
		bookingSerice.updateStatus("CHECKEDIN", bookingId);

	}

}
