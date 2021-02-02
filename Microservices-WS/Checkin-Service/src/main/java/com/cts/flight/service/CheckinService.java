package com.cts.flight.service;

import com.cts.flight.entity.CheckIn;

public interface CheckinService {

	CheckIn checkIn(int bookingId);

	CheckIn getCheckInInfo(int bookingId);
	CheckIn findByCheckinId(int checkinId);

}