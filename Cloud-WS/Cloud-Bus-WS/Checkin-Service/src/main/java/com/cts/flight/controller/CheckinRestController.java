package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RefreshScope
public class CheckinRestController {
	
	
	@Autowired
	private CheckinService checkinService;
	
	@PostMapping("/{bookingId}")
	public ResponseEntity<Object> checkIn(@PathVariable("bookingId")int bookingId) {
		
		CheckIn checkInInfo = checkinService.getCheckInInfo(bookingId);
		
		if(checkInInfo!=null && checkInInfo.getBookingRecord().getBookingId()==bookingId) {
			
			return new ResponseEntity<Object>("Booking Id "+bookingId+" is already checkedIn. Cannot Checkin again. Checkin id is "+checkInInfo.getCheckinId(),HttpStatus.OK);
		}
		
		return  new ResponseEntity<Object>(checkinService.checkIn(bookingId),HttpStatus.OK);
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
