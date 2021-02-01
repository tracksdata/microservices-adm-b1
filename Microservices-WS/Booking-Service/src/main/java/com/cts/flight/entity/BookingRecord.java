package com.cts.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookingRecord {

	@Id
	@GeneratedValue
	private int bookingId;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private LocalDateTime bookingDate;
	private String flightNumber;
	private String origin;
	private String destination;
	private double fare;
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerId")
	private Passenger passenger;

	@OneToOne
	@JoinColumn(name = "airlineId")
	private AirlineInfo airlineInfo;

	public BookingRecord() {
		// TODO Auto-generated constructor stub
	}

	public BookingRecord(LocalDate flightDate, LocalTime flightTime, LocalDateTime bookingDate, String flightNumber,
			String origin, String destination, double fare, Passenger passenger, AirlineInfo airlineInfo,
			String status) {
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.bookingDate = bookingDate;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
		this.status = status;
		this.passenger = passenger;
		this.airlineInfo = airlineInfo;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}

	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

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

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
