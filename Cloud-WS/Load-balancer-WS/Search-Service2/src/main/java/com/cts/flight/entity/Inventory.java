package com.cts.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue
	private int invId;
	private int count;

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(int count) {
		this.count = count;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
