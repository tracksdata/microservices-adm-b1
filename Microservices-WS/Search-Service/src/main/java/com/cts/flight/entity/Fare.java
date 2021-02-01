package com.cts.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fare {
	@Id
	@GeneratedValue
	private int fareId;
	private double fare;
	private String currency;

	public Fare() {
		// TODO Auto-generated constructor stub
	}

	public Fare(double fare, String currency) {
		this.fare = fare;
		this.currency = currency;
	}

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
