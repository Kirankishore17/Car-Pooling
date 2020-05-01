package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.entity.Trip;
import com.vride.carpooling.backend.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/login")
	public Integer checkLogin(@RequestParam("email") String email, @RequestParam("password") String password){
		Integer id = 0;
		try {
		System.out.println(email + " : " + password);
		id = employeeService.checkLogin(email, password);
		System.out.println("\n\n" + id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
//	@GetMapping("/mail")
//	public Integer checkEmail(@RequestParam("email") String email) {
//		Integer resp =  employeeService.checkEmail(email);
//		System.out.println("\n\nresp:-  " + resp);
//		return resp;
//	}
	
	@PostMapping("/employee/new")
	public Integer saveEmployee(@RequestBody Employee employee) {
		Integer resp =  employeeService.checkEmail(employee.getEmail());
		if(resp == null)
			System.out.println("\n\nnew user->> " + employee.toString());
		else
		System.out.println("\n___already exist____");
		// employeeService.saveEmployee(employee);
		return resp;
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
