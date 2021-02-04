package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.cts.flight.service.SearchService;

@Controller
public class Receiver {

	@Autowired
	private SearchService searchService;

	@Bean
	public Queue myQueue() {
		return new Queue("InventoryQ", false);
	}

	// Listener
	@RabbitListener(queues = "InventoryQ")
	public void processMessage(Map<String, Object> inventory) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>> UPDATING NEW INVENTORY <<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("----------------------------------------");
		System.out.println(inventory.get("FLIGHT_NUMBER"));
		System.out.println( (LocalDate) inventory.get("FLIGHTDATE"));
		System.out.println((int) inventory.get("NEW_INVENTORY"));
		System.out.println("----------------------------------------");

		searchService.updateInventory((String) inventory.get("FLIGHT_NUMBER"), (LocalDate) inventory.get("FLIGHTDATE"),
				(int) inventory.get("NEW_INVENTORY"));
		
		
		System.out.println(">>>>>>>>>>>>>> UPDATED <<<<<<<<<<<<<<<<<<<");

	}

}
