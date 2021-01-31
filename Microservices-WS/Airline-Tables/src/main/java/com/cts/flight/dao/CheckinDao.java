package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.CheckIn;

public interface CheckinDao extends JpaRepository<CheckIn, Integer>{

}
