package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.persistence.dao.UsersRespository;
import com.demo.persistence.model.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRespository repository;

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return (List<Users>) repository.findAll();
	}

	@Override
	public void SaveUser(Users user) {
		repository.save(user);
		
	}

	@Override
	public void DeleteUser(Users user) {
		repository.delete(user);
		
	}

	@Override
	public Users findOne(String username) {
		// TODO Auto-generated method stub
		return repository.findOne(username);
	}

}
