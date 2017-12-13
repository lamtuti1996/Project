package com.demo.struts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.demo.struts.entity.Orders;
import com.demo.struts.hibernate.HibernateUtil;
import com.demo.struts.model.OrderCustomize;

public class OrderDetailDAO {
	public List<OrderCustomize> findAllOrderDetailByOrderID(String orderID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<OrderCustomize> list = new ArrayList<OrderCustomize>();
		List<Object[]> result = null;
		try {
			session.beginTransaction();
			String query = (" select o.orderID , od.quanity ,od.amount,p.productID,p.imageURL,p.productPrice,p.productName "
					+ " from OrderDetail od ,Orders o,Product p "
					+ " where o.orderID = od.orders and od.product = p.productID and  o.orderID = :id ");
			result = session.createQuery(query).setParameter("id", orderID).list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}

		for (Object[] obj : result) {
			OrderCustomize oc = new OrderCustomize();
			oc.setOrderId(String.valueOf(obj[0]));
			oc.setQuanity(Integer.parseInt(obj[1].toString()));
			oc.setTotalPrice(Double.parseDouble(obj[2].toString()));

			oc.setProductID(Integer.parseInt(obj[3].toString()));
			oc.setImageURL(String.valueOf(obj[4]));
			oc.setProductPrice(Double.parseDouble(obj[5].toString()));
			oc.setProductName(String.valueOf(obj[6]));

			list.add(oc);
		}

		return list;
	}
}
