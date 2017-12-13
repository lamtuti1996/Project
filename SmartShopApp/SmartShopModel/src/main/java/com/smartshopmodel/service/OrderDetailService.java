package com.smartshopmodel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.model.OrderDetail;





public interface OrderDetailService {
       void saveOrderDetail(OrderDetail od);
       
       Page<Object> findAllByID(String id, Pageable pageable);
       
       long getCountAllOrderDetailByOrderID(String id);
       
      List<OrderCustomize> findAllOrderDetailByOrderID(String id, Integer firstResult, Integer maxResults);
}
