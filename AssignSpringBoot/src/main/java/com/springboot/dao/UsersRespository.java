package com.springboot.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Users;

public interface UsersRespository extends JpaRepository<Users, String> {
	Users findByUsername(String name);
	


}
