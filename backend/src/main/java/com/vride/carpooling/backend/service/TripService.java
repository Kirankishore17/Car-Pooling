package com.vride.carpooling.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vride.carpooling.backend.dao.DriverDao;
import com.vride.carpooling.backend.dao.EmployeeDao;
import com.vride.carpooling.backend.dao.TripDao;
import com.vride.carpooling.backend.dao.UserDao;
import com.vride.carpooling.backend.entity.Driver;
import com.vride.carpooling.backend.entity.Trip;
import com.vride.carpooling.backend.entity.User;
import com.vride.carpooling.backend.info.UserInfo;

@Service
public class TripService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	TripDao tripDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DriverDao driverDao;
	

	
	public List<UserInfo> allUsersInRide(Integer driverId, String dateTime) {
		List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
		for(Trip eachUser : tripDao.findAllUserInRoute(driverId, dateTime)){
			Integer userId = eachUser.getUserId();
			listUserInfo.add( new UserInfo(employeeDao.getOne(userId), userDao.getOne(userId)) );
		}
		return listUserInfo;
	}



	public void joinRide(Integer driverId, Integer userId, String dateTime) {
		
		Driver updateDriver = driverDao.getOne(driverId);
		updateDriver.setSeats(updateDriver.getSeats() - 1);
		driverDao.save(updateDriver);
		tripDao.save(new Trip(driverId, userId, dateTime));
	}

}
