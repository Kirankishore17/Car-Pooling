package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.entity.Driver;
import com.vride.carpooling.backend.info.DriverInfo;
import com.vride.carpooling.backend.service.DriverService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DriverController {
	
	
	@Autowired
	DriverService driverService;
	
	@RequestMapping("/driver/{id}")
	public DriverInfo returnDriverInfoById(@PathVariable("id") Integer id) throws Exception {
		
		DriverInfo driverInfo = driverService.getDriverInfoById(id);
		return driverInfo;
	}
	
	@PostMapping("/driver")
	public void saveDriver(@RequestBody Driver driver) {
		System.out.println("driver --> " + driver.toString());
		driverService.saveDriver(driver);
	}
	
	@PostMapping("/driver/route")
	public List<DriverInfo> findAllDrivers(@RequestParam("source") String source, @RequestParam("destination") String destination) {
		return driverService.findAllInRoute(source, destination);
	}
	
	@RequestMapping("/driver/delete/{id}")
	public void deleteDriverById(@PathVariable("id") Integer id) {
		
		driverService.deleteDriver(id);
	}
	
	@RequestMapping("/allrides")
	public List<DriverInfo> allRides(){
		return driverService.allRides();
	}

}
