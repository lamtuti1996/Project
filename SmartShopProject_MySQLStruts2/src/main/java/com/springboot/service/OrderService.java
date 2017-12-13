package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.entity.CartInfo;

import com.springboot.model.Orders;
import com.springboot.model.Products;
import com.springboot.model.Users;

public interface OrderService {
	void saveOrder(Orders o);

	Page<Orders> findAllOrder(String email, Pageable pageable);

	Orders findById(String id);
	
//	Orders findByID(String id, Pageable pageable);
}
