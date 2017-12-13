package com.smartshopmodel.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.smartshopcommon.model.News;





public interface NewsRespository extends PagingAndSortingRepository<News, Integer>{
	
	//Page<News> findAll (Pageable pageable);
	

}
