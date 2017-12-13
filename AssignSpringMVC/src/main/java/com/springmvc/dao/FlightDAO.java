package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dto.FlightPlane;
import com.springmvc.model.Bookings;
import com.springmvc.model.Users;

@Repository
@Transactional
public class FlightDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Users> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> userList = session.createQuery("from Users").list(); 

		return userList;
	}

	public List<FlightPlane> searchFlight(String fromCity, String toCity, String date) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder qs = new StringBuilder();
		/*
		
		 * Hql : "from User u where u.role.roleID= :roleID" lấy tất cả user có roleID = ? tận dụng đc khóa ngoại
		 * "select f.flightID, f.fromCity, f.toCity, f.duration, p.planeID, p.fare, p.departureTime "
			+ "  from Flight f join f.plane p"
			+ " where f.fromCity = :fromCity and f.toCity = :toCity and p.departureTime = :time"
		 * */
		Query q = null;
		
			qs.append(" select f.flightID,f.fromCity,f.toCity,f.duration, p.planeID ,p.fare,p.departureDate ");
		qs.append(" from Flight f , Plane p    ");
		qs.append(" where f.flightID = p.flight and  f.fromCity = :fromCity and f.toCity = :toCity and p.departureTime = :time ");

	 String hql = qs.toString();

		/*String sql = " select f.FlightID,f.FromCity,f.ToCity,f.Duration, p.PlaneID ,p.Fare,p.DepartureDate  "
				+ "	from Flight f left outer join Plane p on f.FlightID = p.FlightID  "
				+ " where f.FromCity = :fromCity and f.ToCity = :toCity and p.DepartureTime = :time  ";*/
		q = session.createQuery(hql);

		q.setParameter("fromCity", fromCity);
		q.setParameter("toCity", toCity);
		q.setParameter("time", date);

		@SuppressWarnings("unchecked")
		List<FlightPlane> results = q.list();
		System.out.println("araySize:" + results.size());
		return results;
	}

}
