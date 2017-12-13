package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.dao.UsersRespository;
import com.springboot.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRespository respository;

	@Override
	public void saveUser(Users user) {
		respository.save(user);

	}

	@Override
	public void updateUser(Users user) {
	

	}

	@Override
	public void deleteUserByName(String name) {
		

	}

	@Override
	public List<Users> findAllUser() {
		// TODO Auto-generated method stub
		return respository.findAll();
	}

	@Override
	public Users findUserByName(String name) {
		return respository.findOne(name);

	}

}
