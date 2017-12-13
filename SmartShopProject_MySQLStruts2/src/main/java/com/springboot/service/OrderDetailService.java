package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.model.OrderDetail;

public interface OrderDetailService {
       void saveOrderDetail(OrderDetail od);
       
       Page<OrderDetail> findAllByID(String id, Pageable pageable);
}
