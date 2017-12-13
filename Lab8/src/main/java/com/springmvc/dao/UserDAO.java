package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Users;




@Repository
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Users> getAllUsers(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> userList =session.createQuery("from Users").list();
		
		return userList;
	}
	
	
	public Users getUSersById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		Users user =(Users) session.get(Users.class,new Integer(id));
		return user;
	}
	
	
	public void addUser(Users user) {
		Session session =this.sessionFactory.getCurrentSession();
		session.persist(user);
		
	}
	
	public void updateUser(Users user) {
		Session session =this.sessionFactory.getCurrentSession();
		session.update(user);
	}
	
	public void deleteUser(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		Users user =(Users) session.load(Users.class,new Integer(id));
		if(user != null) {
			session.delete(user);
		}
	}
	
	
	
	
}
