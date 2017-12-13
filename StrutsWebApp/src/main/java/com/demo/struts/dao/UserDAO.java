package com.demo.struts.dao;

import java.util.List;

import org.hibernate.Session;

import com.demo.struts.entity.User;
import com.demo.struts.hibernate.HibernateUtil;

public class UserDAO {

	public boolean createUser(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			session.save(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public User getUsers(String email, String pass) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User u = null;
		try {
			session.beginTransaction();
			u = (User) session.createQuery("from User where email = :email and password = :pass")
					.setParameter("email", email).setParameter("pass", pass).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return u;
	}
}
