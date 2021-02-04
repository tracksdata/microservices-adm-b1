package com.cts.flight.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FlightInfo {

	@Id
	@GeneratedValue
	private int flightInfoid;
	private String flightNumber;
	private String flightType;
	private int seatCapacity;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="airlineId")
	private AirlineInfo airlineInfo;
	
	public FlightInfo() {
		// TODO Auto-generated constructor stub
	}

	

	public FlightInfo(String flightNumber, String flightType, int seatCapacity,AirlineInfo airlineInfo) {
		super();
		this.flightNumber = flightNumber;
		this.flightType = flightType;
		this.seatCapacity = seatCapacity;
		this.airlineInfo=airlineInfo;
	}



	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}



	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}



	public int getFlightInfoid() {
		return flightInfoid;
	}

	public void setFlightInfoid(int flightInfoid) {
		this.flightInfoid = flightInfoid;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

}
