package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.dao.OrderDetailRespository;
import com.springboot.model.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRespository respository;

	@Override
	public void saveOrderDetail(OrderDetail od) {
		respository.save(od);

	}



	@Override
	public Page<OrderDetail> findAllByID(String id, Pageable pageable) {
		// TODO Auto-generated method stub
	//	return respository.findByOrder(id, pageable);
		return null;
	}

}
