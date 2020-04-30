package com.vride.carpooling.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vride.carpooling.backend.dao.EmployeeDao;
import com.vride.carpooling.backend.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {

		employeeDao.save(employee);
	}

	public List<Employee> returnAll() {
		return employeeDao.findAll();
	}

	public void deleteEmployee(Integer id) {
		
		employeeDao.deleteById(id);
	}

	public Integer checkLogin(String email, String password) {
		return employeeDao.checkLogin(email, password);
	}

	public Integer checkEmail(String email) {
		return employeeDao.checkEmail(email);
	}

	
}
