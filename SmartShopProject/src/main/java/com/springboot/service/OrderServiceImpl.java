package com.springboot.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.common.Common;
import com.springboot.dao.OrderRespository;
import com.springboot.entity.CartInfo;
import com.springboot.entity.CartLineInfo;

import com.springboot.model.Orders;
import com.springboot.model.Products;
import com.springboot.model.Users;

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

}
