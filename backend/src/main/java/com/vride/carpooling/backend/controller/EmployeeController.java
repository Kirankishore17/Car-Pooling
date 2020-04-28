package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.entity.Trip;
import com.vride.carpooling.backend.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public Trip method(){
		return new Trip(1,2,"3");
	}
	
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
