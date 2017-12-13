package com.smartshopmodel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.smartshopcommon.model.OrderDetail;









public interface OrderDetailRespository extends PagingAndSortingRepository<OrderDetail, Integer> {
	
	
	
}
