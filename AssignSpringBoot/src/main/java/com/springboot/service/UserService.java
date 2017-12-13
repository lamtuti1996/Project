package com.springboot.service;

import java.util.List;

import com.springboot.model.Users;




public interface UserService {


	void saveUser(Users user);

	void updateUser(Users user);

	void deleteUserByName(String name);

	List<Users> findAllUser();

	Users findUserByName(String name);

	
}
