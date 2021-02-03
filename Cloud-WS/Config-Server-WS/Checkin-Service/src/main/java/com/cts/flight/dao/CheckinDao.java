package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.flight.entity.CheckIn;

public interface CheckinDao extends JpaRepository<CheckIn, Integer> {
	
	@Query("from CheckIn as c where c.bookingRecord.bookingId=:bookingId")
	CheckIn findByBookingId(int bookingId);

	//boolean existsByBookingId(int bookingId);
}
