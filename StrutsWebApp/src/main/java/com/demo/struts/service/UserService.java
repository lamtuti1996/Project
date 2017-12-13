package com.demo.struts.service;

import com.demo.struts.entity.User;

public interface UserService {
   User checkUser(String email ,String pass);
   boolean createUser(User u);
}
