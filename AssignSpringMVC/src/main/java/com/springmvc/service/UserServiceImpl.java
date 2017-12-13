package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.Users;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	

	public void saveUser(Users user) {
	dao.addUser(user);
		
	}

	
	public void updateUser(Users user) {
		dao.updateUser(user);
		
	}


	public void deleteUserByName(String userName) {
		dao.deleteUser(userName);
		
	}


	public List<Users> findAllUser() {
	
		return dao.getAllUsers();
	}

	public Users findUserByName(String userName) {
		return dao.getUSersByName(userName);
	}


}
