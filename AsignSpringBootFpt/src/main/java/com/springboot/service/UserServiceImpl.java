package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserRespository;
import com.springboot.entity.StudentDTO;
import com.springboot.entity.UserStudent;
import com.springboot.model.Student;
import com.springboot.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository respository;

	@Override
	public List<Users> findAll() {

		return (List<Users>) respository.findAll();
	}

	@Override
	public Users findByName(String name) {
		Users u = respository.findOne(name);

		return u;
	}

	@Override
	public Page<Users> pagingUser(Pageable pageable) {

		return respository.findAll(pageable);
	}

}
