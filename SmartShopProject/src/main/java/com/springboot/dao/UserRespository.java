package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Users;

public interface UserRespository extends JpaRepository<Users, String> {
	Users findByEmailAndPassword(String email, String password);
}
