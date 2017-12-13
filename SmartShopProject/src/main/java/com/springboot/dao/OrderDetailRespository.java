package com.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.model.OrderDetail;

public interface OrderDetailRespository extends PagingAndSortingRepository<OrderDetail, Integer> {
    Page<OrderDetail> findByOrder(String id,Pageable pageable);
}
