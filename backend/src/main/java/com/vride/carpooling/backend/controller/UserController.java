package com.vride.carpooling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vride.carpooling.backend.entity.User;
import com.vride.carpooling.backend.info.UserInfo;
import com.vride.carpooling.backend.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
//	@RequestMapping("/user/{id}")
//	public UserInfo returnUserInfoById(@PathVariable("id") Integer id) throws Exception {
//		
//		UserInfo userInfo = userService.getUserInfoById(id);
//		return userInfo;
//	}
	
	@PostMapping("/user/new")
	// public void saveDriver(@RequestParam("driver") Driver driver) {
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	/*
	
	@RequestMapping("/user/delete/{id}")
	public void deleteDriverById(@PathVariable("id") Integer id) {
		
		userService.deleteDriver(id);
	}
	*/
}
