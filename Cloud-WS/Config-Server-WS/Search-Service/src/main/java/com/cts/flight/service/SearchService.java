package com.cts.flight.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.flight.entity.Flight;
import com.cts.flight.model.SearchQuery;

public interface SearchService {

	List<Flight> searchFlight(SearchQuery query);

	Flight findByFlightNumberABdFlightDate(String flightNumber, LocalDate flightDate);

	Flight findFlightById(int id);

	public void updateInventory(String flightNumber, LocalDate flightDate, int newInventory);
	public List<Flight> searchFlight(String origin,String destination,LocalDate flightDate,int numberofPassengers);

}