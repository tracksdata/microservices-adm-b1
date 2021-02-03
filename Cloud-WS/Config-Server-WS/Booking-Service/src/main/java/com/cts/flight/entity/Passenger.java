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
import javax.persistence.OneToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private int passengerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String gender;
	private long mobileNumber;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "copassengers", joinColumns = { @JoinColumn(name = "passengerId") }, inverseJoinColumns = {
			@JoinColumn(name = "copassengerId") })
	private List<CoPassenger> copassengers = new ArrayList<>();

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String firstName, String lastName, String emailAddress, String gender, long mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

	public List<CoPassenger> getCopassengers() {
		return copassengers;
	}

	public void setCopassengers(List<CoPassenger> copassengers) {
		this.copassengers = copassengers;
	}

}
