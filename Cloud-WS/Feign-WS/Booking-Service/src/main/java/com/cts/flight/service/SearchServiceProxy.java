package com.cts.flight.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Flight;

@FeignClient(name="search-service",url="http://localhost:8082/api/search")
public interface SearchServiceProxy {
	
	@GetMapping("/{id}")
	Flight findFlight(@PathVariable("id") int id);


}
