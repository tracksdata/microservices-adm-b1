package com.cts.flight.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {
	
	RabbitMessagingTemplate template;

	@Autowired
	Sender(RabbitMessagingTemplate template) {
		this.template = template;
	}

	@Bean
	Queue queue() {
		return new Queue("CheckinQ", false);
	}

	public void send(Object bookingId) {
		template.convertAndSend("CheckinQ", bookingId);
	}

}
