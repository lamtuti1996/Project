package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	public Users findByName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByName(name);
	}

}
