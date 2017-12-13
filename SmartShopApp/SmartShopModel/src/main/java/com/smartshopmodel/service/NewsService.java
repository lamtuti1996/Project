package com.smartshopmodel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartshopcommon.model.News;




public interface NewsService {
     Page<News> findAll(Pageable pageable);
     
     void saveNews(News n);
     
     News findByID(int id);
}
