package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.CategoriesProduct;
import com.springboot.model.Products;

public interface CategoryProductRespository extends JpaRepository<CategoriesProduct, Integer>{

}
