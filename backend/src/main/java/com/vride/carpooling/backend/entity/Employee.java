package com.vride.carpooling.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;

	@Column(name="number", nullable=false)
	private String number;
	
	@Column(name="gender", nullable=false)
	private String gender;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;

	public Employee() {
		
	}
	
	public Employee(String name, String number, String gender, String email, String password) {
		this.name = name;
		this.number = number;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	*/
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", number=" + number + ", gender=" + gender + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
}
