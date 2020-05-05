package com.vride.carpooling.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vride.carpooling.backend.entity.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {

	@Query("SELECT a from Driver a where sourcepoint =:source and destinationpoint =:destination and seats > 0")
	public List<Driver> findAllInRoute(@Param("source") String source, @Param("destination") String destination);

	@Query("SELECT a from Driver a where seats > 0")
	public List<Driver> allRides();

	@Query("SELECT a from Driver a where date = :date and time = :time")
	public Driver getDetails(@Param("date") String date, @Param("time") String time);

}
