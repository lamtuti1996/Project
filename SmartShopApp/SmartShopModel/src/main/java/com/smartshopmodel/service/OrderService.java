package com.smartshopmodel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartshopcommon.model.Orders;





public interface OrderService {
	void saveOrder(Orders o);

	Page<Orders> findAllOrder(String email, Pageable pageable);

	Orders findById(String id);
	
	Page<Orders> findAllOrderByOrderID(String id, Pageable pageable);
}
