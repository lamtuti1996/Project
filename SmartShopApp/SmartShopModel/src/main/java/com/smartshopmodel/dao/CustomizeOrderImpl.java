package com.smartshopmodel.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.xml.transform.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.entity.RestResponsePage;

@Repository
@Transactional
public class CustomizeOrderImpl implements CustomizeOrder {

	@Autowired
	private EntityManagerFactory managerFatory;

	public CustomizeOrderImpl(EntityManagerFactory managerFatory) {
		super();
		this.managerFatory = managerFatory;
	}

	// @PersistenceContext
	// @Autowired
	// private EntityManager manager;

	@Override
	public List<OrderCustomize> findAllOrderDetailByOrderID(String id, int firstResult, int maxResults) {
		List<OrderCustomize> list = new ArrayList<OrderCustomize>();
		EntityManager manager = managerFatory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Object[]> result = null;
		try {
			transaction.begin();

			String query = (" select o.orderId , od.quanity ,od.amount,p.productID,p.imageURL,p.price,p.productName "
					+ " from OrderDetail od ,Orders o,Products p "
					+ " where o.orderId = od.order and od.product=p.productID and  o.orderId = :id ");

			result = manager.createQuery(query, Object[].class).setParameter("id", id).setFirstResult(firstResult)
					.setMaxResults(maxResults).getResultList();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
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

	public long getCountAllOrderDetailByOrderID(String id) {

		EntityManager manager = managerFatory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		long result = 0;
		try {
			transaction.begin();

			String query = (" select count(*) " + " from OrderDetail od ,Orders o,Products p "
					+ " where o.orderId = od.order and od.product=p.productID and  o.orderId = :id ");

			result = manager.createQuery(query, Long.class).setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}

		return result;

	}

}
