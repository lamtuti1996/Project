package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Users;


public interface UserService {
     List<Users> findAll();
     
     Users findByName(String name);
     

}
