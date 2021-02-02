package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.CheckIn;
import com.cts.flight.service.CheckinService;

@RestController
@CrossOrigin
@RequestMapping("/api/checkin")
public class CheckinRestController {
	
	
	@Autowired
	private CheckinService checkinService;
	
	@PostMapping("/{bookingId}")
	public CheckIn checkIn(@PathVariable("bookingId")int bookingId) {
		return  checkinService.checkIn(bookingId);
	}
	
	@GetMapping("/{bookingId}")
	public CheckIn getCheckinInfo(@PathVariable("bookingId")int bookingId) {
		return checkinService.getCheckInInfo(bookingId);
	}
	
	@GetMapping("/byCheckinId/{checkinId}")
	public CheckIn getCheckinInfoByCheckinId(@PathVariable("checkinId")int checkinId) {
		return checkinService.findByCheckinId(checkinId);
	}
	
	
	

}
