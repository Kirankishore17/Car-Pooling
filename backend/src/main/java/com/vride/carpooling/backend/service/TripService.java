package com.vride.carpooling.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vride.carpooling.backend.dao.DriverDao;
import com.vride.carpooling.backend.dao.EmployeeDao;
import com.vride.carpooling.backend.dao.TripDao;
import com.vride.carpooling.backend.dao.UserDao;
import com.vride.carpooling.backend.entity.Driver;
import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.entity.Trip;
import com.vride.carpooling.backend.entity.User;
import com.vride.carpooling.backend.info.DriverInfo;
import com.vride.carpooling.backend.info.UserInfo;

@Service
public class TripService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	TripDao tripDao;
	
//	@Autowired
//	UserDao userDao;
	
	@Autowired
	DriverDao driverDao;
	

	
//	public List<UserInfo> allUsersInRide(Integer driverId, String dateTime) {
//		List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
//		for(Trip eachUser : tripDao.findAllUserInRoute(driverId, dateTime)){
//			Integer userId = eachUser.getUserId();
//			listUserInfo.add( new UserInfo(employeeDao.getOne(userId), userDao.getOne(userId)) );
//		}
//		return listUserInfo;
//	}



	public void joinRide(Integer driverId, Integer userId, String date, Integer key, String time) {
		
		Driver updateDriver = driverDao.getOne(key);
		System.out.println(updateDriver.toString());
		System.out.print(updateDriver.getSeats() + " --> ");
		updateDriver.setSeats(updateDriver.getSeats() - 1);
		driverDao.save(updateDriver);
		System.out.println(updateDriver.getSeats());
		tripDao.save(new Trip(driverId, userId, date, time));
	}



	public List<DriverInfo> getDriverDetails(Integer userId) {
		List<DriverInfo> list = new ArrayList<DriverInfo>();
		for(Trip eachUser : tripDao.findAllUserInRoute(userId)){
			String[] date = eachUser.getDate().split("/");
			int yyyy = Integer.parseInt(date[2]);
			int mm = Integer.parseInt(date[1]);
			int dd = Integer.parseInt(date[0]);
			LocalDate today = LocalDate.now();
			System.out.println("-------------- " + eachUser.getDriverId());

			if( !(LocalDate.of(yyyy, mm, dd)
			.isBefore(LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth()))) ) {
				System.out.println("today or tomorrow");
				list.add( new DriverInfo(employeeDao.getOne(eachUser.getDriverId()), driverDao.getOne(eachUser.getDriverId())) );
			}
		}
		return list;
	}



	public List<UserInfo> getRiderDetails(Integer driverId) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		for(Trip eachUser : tripDao.findAllRiders(driverId)){
			String[] date = eachUser.getDate().split("/");
			int yyyy = Integer.parseInt(date[2]);
			int mm = Integer.parseInt(date[1]);
			int dd = Integer.parseInt(date[0]);
			LocalDate today = LocalDate.now();

			if( !(LocalDate.of(yyyy, mm, dd)
			.isBefore(LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth()))) ) {
				System.out.println("today or tomorrow");
				Driver driver = driverDao.getDetails(eachUser.getDriverId(), eachUser.getDate(), eachUser.getTime()); 
				String source = driver.getSource();
				String destination = driver.getDestination();
				String rideDate = driver.getDate();
				String time = driver.getTime();
				list.add( new UserInfo(employeeDao.getOne(eachUser.getUserId()), source, destination, rideDate, time) );
			}
		}
		return list;
	}

}
