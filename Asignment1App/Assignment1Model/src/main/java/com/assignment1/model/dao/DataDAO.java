package com.assignment1.model.dao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment1common.entity.MemberMemberRequestBook;
import com.assignment1common.model.Addresses;
import com.assignment1common.model.AmazonBooks;
import com.assignment1common.model.Authors;
import com.assignment1common.model.Books;
import com.assignment1common.model.Categories;
import com.assignment1common.model.Libraries;
import com.assignment1common.model.MemberRequests;
import com.assignment1common.model.Members;

@Repository
@Transactional
public class DataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<MemberMemberRequestBook> getMemberByDatePublication(Date date) {
		List<Object> list = null;
		List<MemberMemberRequestBook> listSearch = new ArrayList<>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		StringBuilder qs = new StringBuilder();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Date date = dateFormat.parse("2017-10-01");

		try {
			tx = session.beginTransaction();

			qs.append(" SELECT m.memberID , m.emailAddress , m.gender , m.memberFirstName , m.memberLastName ,  ");
			qs.append("  m.phoneNumber , mr.requestID ,  b.bookTitle ");
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
			System.out.println("Error get members:" + e.toString());
		} finally {
			session.close();

		}

		for (Iterator<Object> it = list.iterator(); it.hasNext();) {
			Object[] object = (Object[]) it.next();

			int memberID = Integer.parseInt(object[0].toString());
			String emailAddress = (String) object[1];
			String gender = (String) object[2];
			String memberFirstName = (String) object[3];
			String memberLastName = (String) object[4];
			String phoneNumber = (String) object[5];

			int requestID = Integer.parseInt(object[6].toString());
		

				String bookTitle = (String) object[7];

				MemberMemberRequestBook mmrb = new MemberMemberRequestBook(memberID, gender, memberFirstName,
						memberLastName, phoneNumber, emailAddress, requestID, bookTitle);
				listSearch.add(mmrb);
		
		}
		return listSearch;
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

	public List<Addresses> getAddress() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Addresses> listAddresses = session.createQuery(" from Addresses ").list();

		return listAddresses;
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

	public MemberRequests getMemberRequestByMemberID(int memberID) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		MemberRequests mr = null;

		try {
			tx = session.beginTransaction();
			mr = session.get(MemberRequests.class, new Integer(memberID));

			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

		return mr;
	}

	public List<Integer> getAllIdAmazonBook() {
		List<AmazonBooks> list = null;
		List<Integer> result = new ArrayList<>();
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
			int a = list.get(i).getIsbn();
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
			for (int i = 0; i < idList.size(); i++) {
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

	public void deleteMember(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Members m = (Members) session.get(Members.class, (Serializable) id);

			List<MemberRequests> list = m.getMemberRequestList();
			for (int i = 0; i < list.size(); i++) {
				session.delete(list.get(i));
			}

			session.delete(m);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}

	}

	public void deleteAddress(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Addresses a = (Addresses) session.get(Addresses.class, (Serializable) id);

			List<Members> listMember = a.getMemberList();
			List<Libraries> listLibrary = a.getLibraryList();

			if (listLibrary.size() != 0) {
				for (int i = 0; i < listLibrary.size(); i++) {
					session.delete(listLibrary.get(i));
				}

			}

			if (listMember.size() != 0) {
				for (int i = 0; i < listMember.size(); i++) {

					List<MemberRequests> listMemberRequest = listMember.get(i).getMemberRequestList();

					if (listMemberRequest.size() != 0) {
						for (int j = 0; j < listMemberRequest.size(); j++) {
							session.delete(listMemberRequest.get(j));
						}

					}

					session.delete(listMember.get(i));
				}

			}

			session.delete(a);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}

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

	public List<Authors> getAllAuthor() {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		List<Authors> listAuthors = null;
		try {
			tx = session.beginTransaction();

			listAuthors = session.createQuery(" from Authors ").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return listAuthors;
	}

	public List<Categories> getAllCategory() {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		List<Categories> listCategory = null;
		try {
			tx = session.beginTransaction();

			listCategory = session.createQuery(" from Categories ").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();

		}
		return listCategory;
	}
}
