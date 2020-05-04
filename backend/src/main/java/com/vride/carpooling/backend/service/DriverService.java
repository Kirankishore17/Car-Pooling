package com.vride.carpooling.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vride.carpooling.backend.dao.DriverDao;
import com.vride.carpooling.backend.dao.EmployeeDao;
import com.vride.carpooling.backend.entity.Driver;
import com.vride.carpooling.backend.entity.Employee;
import com.vride.carpooling.backend.info.DriverInfo;

@Service
public class DriverService {

	@Autowired
	DriverDao driverDao;
	
	@Autowired
	EmployeeDao employeeDao;
		

	public DriverInfo getDriverInfoById(Integer id) throws Exception {
		Employee employee = employeeDao.findById(id).orElseThrow(() -> new Exception());
		Driver driver = driverDao.findById(id).orElseThrow(() -> new Exception());
				//driverDao.getOne(id);
		return new DriverInfo(employee, driver);
	}


	public void saveDriver(Driver driver) {
		driverDao.save(driver);
	}

	public List<DriverInfo> findAllInRoute(String source, String destination) {
		List<DriverInfo> listDriverInfo = new ArrayList<DriverInfo>();
		for(Driver eachDriver : driverDao.findAllInRoute(source, destination)){
			listDriverInfo.add(new DriverInfo(employeeDao.getOne(eachDriver.getId()), eachDriver));
		}
		return listDriverInfo;
	}


	public void deleteDriver(Integer id) {
		try{
			driverDao.deleteById(id);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}


	public List<DriverInfo> allRides() {
		List<DriverInfo> list = new ArrayList<DriverInfo>();
		String date[];
		for(Driver info :driverDao.allRides()) {
			date = info.getDate().split("/");
			int yyyy = Integer.parseInt(date[2]);
			int mm = Integer.parseInt(date[1]);
			int dd = Integer.parseInt(date[0]);
			LocalDate today = LocalDate.now();
//			System.out.println(info.toString());
			System.out.println("\nfrom db -->" + LocalDate.of(yyyy, mm, dd));
			System.out.println("today -->" + LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth()));
			System.out.println("output:=====>" + LocalDate.of(yyyy, mm, dd).getMonth());
//			.isBefore(LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth())) + "\n\n");
			
			if( !(LocalDate.of(yyyy, mm, dd)
			.isBefore(LocalDate.of(today.getYear(), today.getMonth(), today.getDayOfMonth()))) ) {
				list.add(new DriverInfo(employeeDao.getOne(info.getId()), info));
			}
		}
		return list;
	}
	
	
}
