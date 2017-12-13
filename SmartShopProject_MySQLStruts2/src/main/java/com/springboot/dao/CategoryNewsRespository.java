package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.CategoriesNews;
import com.springboot.model.News;

public interface CategoryNewsRespository extends JpaRepository<CategoriesNews, Integer> {

}
