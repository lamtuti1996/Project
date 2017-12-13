package com.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.model.Users;

public interface UserRespository extends PagingAndSortingRepository<Users, String>{
	
    Page<Users> findByUsername(String name, Pageable pageable);
    
    
    
}
