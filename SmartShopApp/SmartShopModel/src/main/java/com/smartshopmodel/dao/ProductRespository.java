package com.smartshopmodel.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.smartshopcommon.model.Products;




public interface ProductRespository extends PagingAndSortingRepository<Products, Integer> {
	
	Page<Products> findAllByCategoryProductCategoryID(int categoryID,Pageable pageable);

}
