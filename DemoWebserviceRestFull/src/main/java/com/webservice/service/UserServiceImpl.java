package com.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dao.DataDao;
import com.webservice.model.Users;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	DataDao dao;
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
