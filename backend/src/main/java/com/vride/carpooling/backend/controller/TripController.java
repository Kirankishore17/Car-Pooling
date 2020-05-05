package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.info.DriverInfo;
import com.vride.carpooling.backend.info.UserInfo;
import com.vride.carpooling.backend.service.TripService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TripController {

	@Autowired
	TripService tripService;
	
//	@PostMapping("/ride")
//	public List<UserInfo> usersInRide(@RequestParam("id") Integer driverId, @RequestParam("dateTime") String dateTime ){
//		return tripService.allUsersInRide(driverId, dateTime);
//	}
	
	@RequestMapping("/joinride")
	public void joinRide(@RequestParam("driverid") Integer driverId, @RequestParam("userid") Integer userId,
			@RequestParam("date") String date, @RequestParam("key") Integer key, @RequestParam("time") String time ){
		System.out.println(driverId + " --- " + userId + " ==== " + date);
		
		tripService.joinRide(driverId, userId, date, key, time);
	}
	
	@RequestMapping("/driverdetails")
	public List<DriverInfo> getDriverDetails(@RequestParam("userId") Integer userId) {
		return tripService.getDriverDetails(userId);
	}
	
	@RequestMapping("/riderdetails")
	public List<UserInfo> getRiderDetails(@RequestParam("driverId") Integer driverId) {
		return tripService.getRiderDetails(driverId);
	}

}
