package com.vride.carpooling.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vride.carpooling.backend.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
