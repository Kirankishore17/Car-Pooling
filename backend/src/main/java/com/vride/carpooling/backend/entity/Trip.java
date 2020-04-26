package com.vride.carpooling.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="driverid", nullable=false)
	private Integer driverId;
	
	@Column(name="userid", nullable=false)
	private Integer userId;
	
	@Column(name="date", nullable=false)
	private String date;

	public Trip() {
		
	}
	
	public Trip(Integer driverId, Integer userId, String date) {
		this.driverId = driverId;
		this.userId = userId;
		this.date = date;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Trip [driverId=" + driverId + ", userId=" + userId + ", date=" + date + "]";
	}
	
	

}
