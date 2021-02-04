package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.Fare;

public interface FareDao extends JpaRepository<Fare, Integer>{
	
	

}
