package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Cities;

public interface CityRespository extends JpaRepository<Cities, Integer> {

}
