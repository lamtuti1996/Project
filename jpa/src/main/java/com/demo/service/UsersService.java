package com.demo.service;

import java.util.List;

import com.demo.persistence.model.Users;

public interface UsersService {
	
	public List<Users> findAll();
	
	public void SaveUser(Users user);
	
	public void DeleteUser(Users user);
	
	public Users findOne(String username);

}
