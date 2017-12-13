package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	public boolean check(User s) {
		User s1 = new User("user1", "123456",1);
		User s2 = new User("user2", "123456",2);
		User s3 = new User("user3", "123456",3);
		User s4 = new User("user4", "123456",4);

		List<User> list = new ArrayList<User>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);  

		for (User user : list) {
			if (user.getName().equalsIgnoreCase(s.getName()) && user.getPassword().equals(s.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String name,String password) {
		
		User s1 = new User("user1", "123456",1);
		User s2 = new User("user2", "123456",2);
		User s3 = new User("user3", "123456",3);
		User s4 = new User("user4", "123456",4);

		List<User> list = new ArrayList<User>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		for (User user : list) {
			if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
