package com.vride.carpooling.backend.info;

import javax.persistence.Column;

import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.entity.User;

public class UserInfo {
	
	private String name;
	private String number;
	private String gender;
	private String time;
	private String source;
	private String destination;
	private String date;
	
	public UserInfo() {
		
	}
			
	public UserInfo(Employee employee, String source, String destination, String date, String time) {
		this.name = employee.getName();
		this.number = employee.getNumber();
		this.gender = employee.getGender();
		this.time = time;
		this.source = source;
		this.destination = destination;
		this.date = date;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
		
	

}
