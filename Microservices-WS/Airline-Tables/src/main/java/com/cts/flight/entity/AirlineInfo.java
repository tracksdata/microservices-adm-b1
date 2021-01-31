package com.cts.flight.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class AirlineInfo {

	@Id
	@GeneratedValue
	private int airlineId;
	private String airlineName;
	private String airlineLogo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "flightsInformation",joinColumns = {@JoinColumn(name="airlineId")},inverseJoinColumns = {@JoinColumn(name="flightInfoid")})
	private List<FlightInfo> flights = new ArrayList<>();

	public AirlineInfo() {
		// TODO Auto-generated constructor stub
	}

	public AirlineInfo(String airlineName, String airlineLogo) {
		this.airlineName = airlineName;
		this.airlineLogo = airlineLogo;
	}

	
	
	public List<FlightInfo> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightInfo> flights) {
		this.flights = flights;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

}
