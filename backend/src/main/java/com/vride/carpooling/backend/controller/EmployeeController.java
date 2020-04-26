package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee/new")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/employee/all")
	public List<Employee> returnAllEmployee() {
		return employeeService.returnAll();
	}
	
	@RequestMapping("/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}
}
