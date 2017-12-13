package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Bookings;
import com.springmvc.model.Users;

@Repository
@Transactional
public class BookingsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addBooking(Bookings booking) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(booking);
	}

	public List<Bookings> searchBookings(String code, String userName, boolean condition) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder qs = new StringBuilder();
		Query q = null;
		String hql = "";
		if (condition == true) {

		/*	qs.append("select b from Bookings as b ");
			qs.append("left join fetch b.user u ");
			qs.append("where u.Username=:userName");*/

			// String hql = qs.toString();
			hql = " select b.ReservationCode,b.Email,b.PlaneID,b.BookingDate,b.BookingTime,u.FullName,p.FlightID,p.Fare,p.DepartureDate,p.DepartureTime,f.FromCity,f.ToCity,f.Duration "
					+ " from Flight f join Plane p  join Bookings b  join User u "
					+ " where  p.FlightID=f.FlightID and p.PlaneID = b.PlaneID and b.UserName=u.UserName  and u.UserName =:userName ";
			q = session.createQuery(hql);

			q.setParameter("userName", userName);
		} else {
			/*qs.append("select b from Bookings as b ");
			qs.append("left join fetch b.user u ");
			qs.append("where b.bookingID=:code");*/

			// String hql = qs.toString();
			hql = " select b.ReservationCode,b.Email,b.PlaneID,b.BookingDate,b.BookingTime,u.FullName,p.FlightID,p.Fare,p.DepartureDate,p.DepartureTime,f.FromCity,f.ToCity,f.Duration "
					+ " from Flight f join Plane p  join Bookings b  join User u "
					+ " where  p.FlightID=f.FlightID and p.PlaneID = b.PlaneID and b.UserName=u.UserName  and b.ReservationCode =:code ";
			q = session.createQuery(hql);
			q.setParameter("code", code);

		}

		@SuppressWarnings("unchecked")
		List<Bookings> results = q.list();
		return results;
	}
}
