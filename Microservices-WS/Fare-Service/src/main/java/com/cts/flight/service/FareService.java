package com.cts.flight.service;

import java.time.LocalDate;
import java.util.Optional;

import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

public interface FareService {

	Fare findFlightByFlightNumberAndFlightDateAndOriginAndDestination(String flightNumber, LocalDate flightDate,String origin,String destination);
	Fare getFareById(int id);

}