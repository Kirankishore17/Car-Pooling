package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vride.carpooling.backend.info.UserInfo;
import com.vride.carpooling.backend.service.TripService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TripController {

	@Autowired
	TripService tripService;
	
	@PostMapping("/ride")
	public List<UserInfo> usersInRide(@RequestParam("id") Integer driverId, @RequestParam("dateTime") String dateTime ){
		return tripService.allUsersInRide(driverId, dateTime);
	}
	
	@RequestMapping("/joinride")
	public void joinRide(@RequestParam("driverid") Integer driverId, @RequestParam("userid") Integer userId, @RequestParam("date") String dateTime ){
		System.out.println(driverId + " --- " + userId + " ==== " + dateTime);
		tripService.joinRide(driverId, userId, dateTime);
	}
}
