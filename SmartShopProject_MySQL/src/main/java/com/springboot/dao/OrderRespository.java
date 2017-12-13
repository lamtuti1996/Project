package com.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.model.Orders;

public interface OrderRespository extends PagingAndSortingRepository<Orders, String> {
	Page<Orders> findAllByUserEmail(String email, Pageable pageable);
	 
	Page<Orders> findByOrderId(String id, Pageable pageable);
	
//	Orders findOneByOrderId(String id, Pageable pageable);
}
