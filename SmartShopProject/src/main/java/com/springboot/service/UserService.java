package com.springboot.service;

import com.springboot.model.Users;

public interface UserService {
     Users findByEmailAndPass(String email,String pass);
     
     Users findByEmail(String email);
     
     void updateLastAccess (Users u);
     
     void saveUser(Users u);
}
