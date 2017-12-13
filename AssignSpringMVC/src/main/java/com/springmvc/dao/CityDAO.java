package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Cities;
import com.springmvc.model.Users;

@Repository
@Transactional
public class CityDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	public List<Cities> getAllCity(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Cities> cityList =session.createQuery(" from Cities").list();
		
		return cityList;
	}
	
	public void addCity(Cities city) {
		//Session session = sessionFactory.openSession();
		Session session = this.sessionFactory.getCurrentSession();
		session.save(city);
		
	}
	
	
}
