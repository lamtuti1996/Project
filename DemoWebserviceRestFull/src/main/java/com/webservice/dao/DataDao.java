package com.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservice.model.Users;

@Repository
@Transactional
public class DataDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Users> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> userList = session.createQuery("from Users").list();

		return userList;

	}

}
