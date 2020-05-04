package com.vride.carpooling.backend.info;

import com.vride.carpooling.backend.entity.Driver;
import com.vride.carpooling.backend.entity.Employee;

public class DriverInfo {
	
	private Integer id;
	private String name;
	private String number;
	private String time;
	private String source;
	private String destination;
	private String vehicleNumber;
	private String date;
	
	public DriverInfo() {
		
	}
	
	public DriverInfo(Employee employee, Driver driver) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.number = employee.getNumber();
		this.time = driver.getTime();
		this.source = driver.getSource();
		this.destination = driver.getDestination();
		this.vehicleNumber = driver.getVehicleNumber();
		this.date = driver.getDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
