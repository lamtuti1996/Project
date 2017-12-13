package com.smartshopmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.News;
import com.smartshopmodel.dao.NewsRespository;



@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsRespository respository;

	@Override
	public Page<News> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		PageRequest p = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.DESC,
				"createDate");
		return  respository.findAll(p);
	}

	@Override
	public void saveNews(News n) {
		respository.save(n);
		
	}

	@Override
	public News findByID(int id) {
		// TODO Auto-generated method stub
		return respository.findOne(id);
	}

}
