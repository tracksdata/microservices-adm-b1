package com.cts.flight.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private int id;
	private String flightNumber;
	private String origin;
	private String destination;
	private String duration;
	private LocalDate flightDate;
	private LocalTime flightTime;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fareId")
	private Fare fare;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "invId")
	private Inventory inventory;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="airlineId")
	private AirlineInfo airlineInfo;
	
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public Flight(String flightNumber, String origin, String destination, String duration, LocalDate flightDate,
			LocalTime flightTime, Fare fare, Inventory inventory, AirlineInfo airlineInfo) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.fare = fare;
		this.inventory = inventory;
		this.airlineInfo = airlineInfo;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
