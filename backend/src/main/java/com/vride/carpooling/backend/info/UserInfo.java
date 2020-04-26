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
			
	public UserInfo(Employee employee, User user) {
		this.name = employee.getName();
		this.number = employee.getNumber();
		this.gender = employee.getGender();
		this.time = user.getTime();
		this.source = user.getSource();
		this.destination = user.getDestination();
		this.date = user.getDate();
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
