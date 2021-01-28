package com.cts.flight.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingQuery {

	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private int numberofPassengers;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public int getNumberofPassengers() {
		return numberofPassengers;
	}

	public void setNumberofPassengers(int numberofPassengers) {
		this.numberofPassengers = numberofPassengers;
	}

}
