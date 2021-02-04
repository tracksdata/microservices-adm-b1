package com.cts.flight.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Flight;

@FeignClient(name = "search-service")//http://localhost:search-service/api/find
@RibbonClient(name="search-proxy") 
public interface SearchServiceProxy {
	
	@GetMapping("/api/search/{id}")
	Flight findFlight(@PathVariable("id") int id);


}
