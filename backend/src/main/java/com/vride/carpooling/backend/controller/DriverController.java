package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class DriverController {
	
	
	@Autowired
	DriverService driverService;
	
	@RequestMapping("/driver/{id}")
	public DriverInfo returnDriverInfoById(@PathVariable("id") Integer id) throws Exception {
		
		DriverInfo driverInfo = driverService.getDriverInfoById(id);
		return driverInfo;
	}
	
	@PostMapping("/driver")
	// public void saveDriver(@RequestParam("driver") Driver driver) {
	public void saveDriver(@RequestBody Driver driver) {
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
	
	
	/*
	@Autowired
	DriverDao driverDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping("/")
	// public List<Driver> home() {
	public Driver home() {
		Driver obj = new Driver("8:00", 4, "adyar", "mylapore", "tn07-3317", "dec 12");
		obj.setId(1);
		driverDao.save(obj);
		// List<Driver> list = driverDao.findAll();
		// return list;
		obj = driverDao.getOne(1);
		return obj;
	}

	@RequestMapping("/kk")
	public Driver mapping() {
		Employee ob = new Employee("kishore","5555","male","@mail.com","password");
		employeeDao.save(ob);
		ob = employeeDao.getOne(1);
		Driver obj = new Driver("8:00", 4, "adyar", "mylapore", "tn07-3317", "dec 12");
		obj.setId(ob.getId());
		System.out.println("\n\n" + ob.toString());
		System.out.println("\n\n" + obj.toString());
		return obj;
	}
	*/
}
