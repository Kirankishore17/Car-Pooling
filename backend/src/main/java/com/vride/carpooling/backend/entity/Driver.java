package com.vride.carpooling.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {
	@Id
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="time", nullable=false)
	private String time;

	@Column(name="seats", nullable=false)
	private Integer seats;
	
	@Column(name="sourcepoint", nullable=false)
	private String source;
	
	@Column(name="destinationpoint", nullable=false)
	private String destination;
	
	@Column(name="vehiclenumber", nullable=false)
	private String vehicleNumber;
	
	@Column(name="date", nullable=false)
	private String date;
	
	public Driver() {
		
	}

	public Driver(String time, Integer seats, String source, String destination, String vehicleNumber,
			String date) {
		this.time = time;
		this.seats = seats;
		this.source = source;
		this.destination = destination;
		this.vehicleNumber = vehicleNumber;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
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

	@Override
	public String toString() {
		return "Driver [id=" + id + ", time=" + time + ", seats=" + seats + ", source=" + source + ", destination="
				+ destination + ", vehicleNumber=" + vehicleNumber + ", date=" + date + "]";
	}
	
	
	
		
	
}
