package com.springmvc.dao;

import java.io.Serializable;
import java.util.List;

import org.h2.engine.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Users;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Users update(Users u) {
		Users result = null;
		Session session = this.sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		try {

			result = (Users) session.merge(u);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		} finally {
			session.close();

		}
		return result;
	}

	public List<Users> findBy(String table, Object value, String sortExpession, String sortDirection) {
		List<Users> list = null;
		Session session = this.sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		try {
			StringBuilder sb = new StringBuilder(" from ");
			sb.append(User.class);
			if (table != null && value != null) {
				sb.append(" where ").append(table).append("= :value");
			}
			if (sortExpession != null && sortDirection != null) {
				sb.append(" order by ").append(sortExpession);
				sb.append(" " + (sortDirection.equals("ASC") ? "asc" : "desc"));
			}

			Query hql = session.createQuery(sb.toString());
			hql.setParameter("value", value);
			list = hql.list();

			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		} finally {
			session.close();

		}
		return list;
	}

	public Integer deleteAll(List<Integer> id) {
		int counter = 0;
		Session session = this.sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		try {
			for (Integer item : id) {
				Users u = (Users) session.get(Users.class, (Serializable) id);
				session.delete(u);
				counter++;
			}

			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		} finally {
			session.close();

		}
		return counter;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Users> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> userList = session.createQuery("from Users").list();

		return userList;
	}

	public Users getUSersByName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Users user = (Users) session.get(Users.class, new String(userName));

		return user;
	}

	public void addUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);

	}

	public void updateUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Users user = (Users) session.load(Users.class, new String(userName));
		if (user != null) {
			session.delete(user);
		}
	}

}
