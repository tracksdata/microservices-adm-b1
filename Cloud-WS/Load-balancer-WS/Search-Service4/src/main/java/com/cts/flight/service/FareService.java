package com.cts.flight.service;

import java.time.LocalDate;

import com.cts.flight.entity.Fare;

public interface FareService {

	Fare getFare(String flightNumber, LocalDate flightDate);

	Fare getFareById(int id);

}