package com.smartshopmodel.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.smartshopcommon.model.Orders;





public interface OrderRespository extends PagingAndSortingRepository<Orders, String> {
	Page<Orders> findAllByUserEmail(String email, Pageable pageable);
	 
	Page<Orders> findByOrderId(String id, Pageable pageable);
	

}
