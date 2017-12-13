package com.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.persistence.model.Staffs;

public interface StaffsRespository  extends JpaRepository<Staffs, String>{

}
