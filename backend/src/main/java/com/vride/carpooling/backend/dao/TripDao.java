package com.vride.carpooling.backend.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vride.carpooling.backend.entity.Trip;

public interface TripDao extends JpaRepository<Trip, Integer> {

	@Query("SELECT a from Trip a where driverid =:driverId and date =:dateTime")
	public List<Trip> findAllUserInRoute(@Param("driverId") Integer driverId, @Param("dateTime") String dateTime);

	@Query("SELECT a from Trip a where userid = :userId")
	public List<Trip> findAllUserInRoute(@Param("userId")Integer userId);

	@Query("SELECT a from Trip a where driverid = :driverId")
	public List<Trip> findAllRiders(@Param("driverId")Integer driverId);

}
