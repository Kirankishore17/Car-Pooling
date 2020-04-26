package com.vride.carpooling.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vride.carpooling.backend.entity.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {

	@Query("SELECT a from Driver a where sourcepoint =:source and destinationpoint =:destination and seats > 0")
	public List<Driver> findAllInRoute(@Param("source") String source, @Param("destination") String destination);

}
