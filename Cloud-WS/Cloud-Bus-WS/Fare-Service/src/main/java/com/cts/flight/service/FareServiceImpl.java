package com.cts.flight.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

@Service
public class FareServiceImpl implements FareService {

	@Autowired
	private FlightDao flightDao;
	private Fare fare;

	@Override
	public Fare findFlightByFlightNumberAndFlightDateAndOriginAndDestination(String flightNumber, LocalDate flightDate,
			String origin, String destination) {

		fare = flightDao.findFlightByFlightNumberAndFlightDateAndOriginAndDestination(flightNumber, flightDate, origin,
				destination).getFare();

		if (fare != null) {
			return fare;
		} else {
			return null;
		}

	}

	@Override
	public Fare getFareById(int id) {
		Flight flight = flightDao.findById(id).orElse(null);

		if (flight != null) {
			return flight.getFare();
		}

		return null;
	}

}
