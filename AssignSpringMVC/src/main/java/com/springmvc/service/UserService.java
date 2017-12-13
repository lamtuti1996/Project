package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Users;


public interface UserService {


	void saveUser(Users user);

	void updateUser(Users user);

	void deleteUserByName(String userName);

	List<Users> findAllUser();

	Users findUserByName(String userName);

	
}
