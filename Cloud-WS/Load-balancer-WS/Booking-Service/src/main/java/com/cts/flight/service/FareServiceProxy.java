package com.cts.flight.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Fare;

@FeignClient(name = "fare-service", url = "http://localhost:8081/api/fare")
public interface FareServiceProxy {

	@GetMapping("/{id}")
	Fare getFare(@PathVariable("id") int id);
}
