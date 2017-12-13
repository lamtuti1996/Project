package com.demo.struts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.demo.struts.entity.Orders;
import com.demo.struts.entity.Product;
import com.demo.struts.hibernate.HibernateUtil;


public class OrderDAO {
	public List<Orders> getAllOrder() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Orders> list = new ArrayList<Orders>();
		try {
			session.beginTransaction();
			list = session.createQuery("from Orders").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return list;
	}
}
