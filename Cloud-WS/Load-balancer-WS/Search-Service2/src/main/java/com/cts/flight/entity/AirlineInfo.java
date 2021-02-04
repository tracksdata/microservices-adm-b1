package com.cts.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirlineInfo {

	@Id
	@GeneratedValue
	private int airlineId;
	private String airlineName;
	private String airlineLogo;

	

	public AirlineInfo() {
		// TODO Auto-generated constructor stub
	}

	public AirlineInfo(String airlineName, String airlineLogo) {
		this.airlineName = airlineName;
		this.airlineLogo = airlineLogo;
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
