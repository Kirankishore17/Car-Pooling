package com.vride.carpooling.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vride.carpooling.backend.dao.EmployeeDao;
import com.vride.carpooling.backend.dao.UserDao;
import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.entity.User;
import com.vride.carpooling.backend.info.UserInfo;

@Service
public class UserService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	UserDao userDao;
	
	public UserInfo getUserInfoById(Integer id) throws Exception{
		Employee employee = employeeDao.findById(id).orElseThrow(() -> new Exception());
		User user = userDao.findById(id).orElseThrow(() -> new Exception());
		return new UserInfo(employee, user);
	}

	public void saveUser(User user) {

		userDao.save(user);
	}

	
}
