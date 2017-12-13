package com.smartshopmodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartshopcommon.model.CategoriesProduct;



public interface CategoryProductRespository extends JpaRepository<CategoriesProduct, Integer>{

}
