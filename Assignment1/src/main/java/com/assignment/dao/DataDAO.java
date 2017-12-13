package com.assignment.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.model.Addresses;
import com.assignment.model.AmazonBooks;
import com.assignment.model.Authors;
import com.assignment.model.Books;
import com.assignment.model.Categories;
import com.assignment.model.Libraries;
import com.assignment.model.MemberRequests;
import com.assignment.model.Members;
import com.mysql.fabric.xmlrpc.base.Member;

@Repository
@Transactional
public class DataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Object> getMemberByDatePublication(Date date) {
		List<Object> list = null;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		StringBuilder qs = new StringBuilder();

		try {
			tx = session.beginTransaction();

			qs.append(" SELECT m.memberID , m.emailAddress , m.gender , m.memberFirstName , m.memberLastName ,  ");
			qs.append("  m.phoneNumber , mr.requestID , mr.dateLocated , mr.dateRequested , b.bookTitle ");
			qs.append(" FROM Members m , MemberRequests mr , Books b ");
			qs.append(" WHERE m.memberID =mr.members and mr.books = b.isbn and b.dateOfPublication = :date");

			String hql = qs.toString();
			Query q = session.createQuery(hql);
			q.setParameter("date", date);
			list = q.list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
 				tx.rollback();
			System.out.println("Error get members:"+e.toString());
		} finally {
			session.close();

		}
		return list;
	}

	public void addAmazonBook(AmazonBooks ab) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(ab);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public List<AmazonBooks> getAllAmazonBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AmazonBooks> listAmazonBook = session.createQuery(" from AmazonBooks ").list();

		return listAmazonBook;
	}

	public void addCategory(Categories c) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(c);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addAuthors(Authors a) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(a);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addBook(Books b) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(b);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addAddresses(Addresses a) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(a);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addMember(Members m) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(m);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addMemberRequest(MemberRequests mr) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(mr);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public void addLibrary(Libraries l) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(l);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

	public List<MemberRequests> getMemberRequestByMemberID(int memberID) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		List<MemberRequests> listMemberRequest = null;

		try {
			tx = session.beginTransaction();
			Members m = session.get(Members.class, new Integer(memberID));
			listMemberRequest = m.getMemberRequestList();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

		return listMemberRequest;
	}

	public List<Integer> getAllIdAmazonBook() {
		List<AmazonBooks> list = null;
		List<Integer> result=new ArrayList<>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		StringBuilder qs = new StringBuilder();

		try {
			tx = session.beginTransaction();

			qs.append(" FROM AmazonBooks ab ");

			String hql = qs.toString();
			Query q = session.createQuery(hql);
			list = q.list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		
		for (int i = 0; i < list.size(); i++) {
			int a=list.get(i).getIsbn();
			result.add(a);
		}
		return result;
	}

	public Integer deleteAllAmazonBook(List<Integer> idList) {
		int counter = 0;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			for (int i = 0; i <idList.size() ; i++) {
				AmazonBooks ab = (AmazonBooks) session.get(AmazonBooks.class, (Serializable) idList.get(i));
				session.delete(ab);
				counter++;
			}
			

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return counter;
	}



	public Addresses updateAddressById(Addresses a) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Addresses address = null;
		try {
			tx = session.beginTransaction();
			address = (Addresses) session.merge(a);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return address;
	}

	public Addresses getAddressByID(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Addresses a = null;

		try {
			tx = session.beginTransaction();

			a = session.get(Addresses.class, new Integer(id));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return a;
	}

	public Books getBookByID(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Books b = null;

		try {
			tx = session.beginTransaction();

			b = session.get(Books.class, new Integer(id));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return b;
	}

	public Members getMemberID(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Members m = null;

		try {
			tx = session.beginTransaction();

			m = session.get(Members.class, new Integer(id));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return m;
	}

	public Categories getCategoryByID(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Categories c = null;

		try {
			tx = session.beginTransaction();

			c = session.get(Categories.class, new Integer(id));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return c;
	}

	public Authors getAuthorByID(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		Authors a = null;

		try {
			tx = session.beginTransaction();

			a = session.get(Authors.class, new Integer(id));

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return a;
	}
	
	

}
