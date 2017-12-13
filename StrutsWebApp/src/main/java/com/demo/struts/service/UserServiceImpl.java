package com.demo.struts.service;

import com.demo.struts.dao.UserDAO;
import com.demo.struts.entity.User;

public class UserServiceImpl implements UserService {

UserDAO user=new UserDAO();
	
	public User checkUser(String email, String pass) {
		// TODO Auto-generated method stub
		return user.getUsers(email, pass);
	}

	public boolean createUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
