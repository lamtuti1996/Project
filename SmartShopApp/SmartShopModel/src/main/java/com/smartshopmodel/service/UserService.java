package com.smartshopmodel.service;

import com.smartshopcommon.model.Users;

public interface UserService {
   
     
     Users findByEmail(String email);
     
     void updateLastAccess (Users u);
     
     void saveUser(Users u);
}
