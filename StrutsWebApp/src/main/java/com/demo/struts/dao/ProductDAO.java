package com.demo.struts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.struts.entity.Product;
import com.demo.struts.entity.User;
import com.demo.struts.hibernate.HibernateUtil;

public class ProductDAO {

	public List<Product> getAllProduct(int startingIndex, int endingIndex) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Product> list = new ArrayList<Product>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Product ");
			query.setFirstResult(startingIndex);
			query.setMaxResults(endingIndex);

			list = query.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return list;
	}

	public long getCountProduct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		long count = -1;
		try {
			session.beginTransaction();
			Query query = session.createQuery(" select count(*) from Product ");

			count =  (Long) query.uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return count;
	}

}
