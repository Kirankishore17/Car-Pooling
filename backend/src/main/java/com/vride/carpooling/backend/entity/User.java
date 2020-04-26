package com.vride.carpooling.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="time", nullable=false)
	private String time;
	
	@Column(name="sourcepoint", nullable=false)
	private String source;
	
	@Column(name="destinationpoint", nullable=false)
	private String destination;
	
	@Column(name="date", nullable=false)
	private String date;

	public User() {
		
	}
	
	public User(String time, String source, String destination, String date) {
		this.time = time;
		this.source = source;
		this.destination = destination;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", time=" + time + ", source=" + source + ", destination=" + destination + ", date="
				+ date + "]";
	}
	
	
}
