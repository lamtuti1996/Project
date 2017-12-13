package com.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.model.OrderDetail;

public interface OrderDetailRespository extends PagingAndSortingRepository<OrderDetail, Integer> {
	/*public final static String QUERY ="select od.orderDetailID, od.quanity ,od.price,od.amount from OrderDetail od ,Orders o , od.product where o.orderId = od.order and o.orderId = :id ";
	
	
	@Query(QUERY)
	public Page<OrderDetail> getAll(@Param("id") String id,Pageable pageable);*/
	
//    Page<OrderDetail> findAllByOrders
	
}
