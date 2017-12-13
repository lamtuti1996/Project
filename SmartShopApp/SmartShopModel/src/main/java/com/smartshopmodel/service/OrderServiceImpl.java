package com.smartshopmodel.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.Orders;
import com.smartshopmodel.dao.OrderRespository;




@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRespository respository;

	@Override
	public Page<Orders> findAllOrder(String email, Pageable pageable) {
		// TODO Auto-generated method stub
		return respository.findAllByUserEmail(email, pageable);
	}

	@Override
	public void saveOrder(Orders o) {
		respository.save(o);

	}

	@Override
	public Orders findById(String id) {
		// TODO Auto-generated method stub
		return respository.findOne(id);
	}

	@Override
	public Page<Orders> findAllOrderByOrderID(String id, Pageable pageable) {
		// TODO Auto-generated method stub
		return respository.findByOrderId(id, pageable);
	}



}
