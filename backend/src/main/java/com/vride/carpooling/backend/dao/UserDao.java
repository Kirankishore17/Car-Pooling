package com.vride.carpooling.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vride.carpooling.backend.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
