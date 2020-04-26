package com.vride.carpooling.backend.service;

import java.util.ArrayList;
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
	
	
}
