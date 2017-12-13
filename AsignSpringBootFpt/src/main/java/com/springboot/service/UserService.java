package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.entity.UserStudent;
import com.springboot.model.Users;

public interface UserService {
     List<Users> findAll();
     
     Users findByName(String name);
     
     public Page<Users> pagingUser(Pageable pageable);
}
