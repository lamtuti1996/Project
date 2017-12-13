package com.smartshopmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.model.OrderDetail;
import com.smartshopmodel.dao.CustomizeOrder;
import com.smartshopmodel.dao.OrderDetailRespository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRespository respository;

	@Autowired
	CustomizeOrder customizeOrder;

	@Override
	public void saveOrderDetail(OrderDetail od) {
		respository.save(od);

	}

	@Override
	public Page<Object> findAllByID(String id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderCustomize> findAllOrderDetailByOrderID(String id, Integer firstResult, Integer maxResults) {
		// TODO Auto-generated method stub
		return customizeOrder.findAllOrderDetailByOrderID(id, firstResult, maxResults);
	}

	@Override
	public long getCountAllOrderDetailByOrderID(String id) {
		// TODO Auto-generated method stub
		return customizeOrder.getCountAllOrderDetailByOrderID(id);
	}

}
