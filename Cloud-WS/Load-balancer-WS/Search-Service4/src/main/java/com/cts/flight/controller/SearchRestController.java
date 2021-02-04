package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.Flight;
import com.cts.flight.model.SearchQuery;
import com.cts.flight.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/api/search")
@RefreshScope
public class SearchRestController {

	@Autowired
	private SearchService searchService;
	
	@Value("${originairports.shutdown}")
	private String originAirportShutdownList;
	


	@PostMapping
	public List<Flight> findFlights(@RequestBody SearchQuery query) {
		return searchService.searchFlight(query);
	}
	
	@GetMapping("/{origin}/{destination}/{flightDate}/{numberofPassengers}")
	public List<Flight> findFlightsV1(@PathVariable("origin")String origin,@PathVariable("destination")String destination,@PathVariable("flightDate")@DateTimeFormat(iso = ISO.DATE) LocalDate flightDate,@PathVariable("numberofPassengers")int numberofPassengers){
		System.out.println(">>>>>>>>>>>>> Search Service-4 <<<<<<<<<<<<");

		System.out.println(">>>>>  originAirportShutdownList: "+originAirportShutdownList);

        if(Arrays.asList(originAirportShutdownList.split(",")).contains(origin)) {
        	
            System.out.println(">>>>>>>>>>> The origin airport is in shutdown state <<<<<<<<<<");
            
             return new ArrayList<Flight>();
         }

		
		return searchService.searchFlight(origin, destination, flightDate, numberofPassengers);
	}

	@GetMapping("/{id}")
	public Flight findFLightById(@PathVariable("id") int id) {
		System.out.println(">>>>>>>>>>>>> Search Service-4 <<<<<<<<<<<<");

		return searchService.findFlightById(id);
	}

}
