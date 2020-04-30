package com.vride.carpooling.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vride.carpooling.backend.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Query("select id from Employee where email = :email and password = :password")
	Integer checkLogin(@Param("email") String email, @Param("password") String password);

	@Query("select id from Employee where email = :email")
	Integer checkEmail(@Param("email") String email);

}
