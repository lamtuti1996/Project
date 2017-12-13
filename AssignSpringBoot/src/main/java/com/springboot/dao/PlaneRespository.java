package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Plane;

public interface PlaneRespository extends JpaRepository<Plane, String> {

}
