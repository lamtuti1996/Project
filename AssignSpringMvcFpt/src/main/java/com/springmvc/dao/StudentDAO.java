package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Student;
import com.springmvc.model.Users;

@Repository
@Transactional
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Student> listPaginatedProductsUsingQuery(Integer firstResult, Integer maxResults) {
		int paginatedCount = 0;
		Session session = this.sessionFactory.openSession();
		List<Student> studentList = null;
		try {
			Query query = session.createQuery("From Student");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults != null ? maxResults : 5);
			studentList = (List<Student>) query.list();

			if (studentList != null) {
				paginatedCount = studentList.size();
				System.out.println("Total Results: " + paginatedCount);
				for (Student items : studentList) {
					System.out.println("Retrieved Product using Query. Name: " + items.getId());
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return studentList;
	}
	

/**
 * 
 * @param offset
 * @param maxResults
 * @param username
 * @return
 */
	@SuppressWarnings("unchecked")
	public List<Student> list(Integer offset, Integer maxResults,String username) {
		 
		
		Session session = this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(Users.class,"u");
				   cr.setFetchMode("Student", FetchMode.JOIN);
	
		
		cr.add(Restrictions.eq("u.username", username));
		
		cr.setFirstResult(offset != null ? offset : 0);
		cr.setMaxResults(maxResults != null ? maxResults : 5);
		List<Users> u=  cr.list();
		List<Student> results=u.get(1).getStudentList();
		/*return sessionFactory.openSession().createCriteria(Student.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 5).list();*/
		return results;
	}

	public Long count() {
		return (Long) sessionFactory.openSession().createCriteria(Student.class).setProjection(Projections.rowCount())
				.uniqueResult();
	}
}
