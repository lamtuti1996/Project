package com.dao;

import com.bean.User;

public interface UserDAO {
	
	public boolean check(User s);
	public User getUser(String name,String password) ;
}
