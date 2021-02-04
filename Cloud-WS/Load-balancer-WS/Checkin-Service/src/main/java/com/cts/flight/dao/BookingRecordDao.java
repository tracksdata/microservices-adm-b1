package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.BookingRecord;

public interface BookingRecordDao extends JpaRepository<BookingRecord, Integer>{
	
	//BookingRecord findByBookingId(int bookingId);

}
