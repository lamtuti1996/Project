package com.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.persistence.model.Departs;

public interface DepartsRespository  extends JpaRepository<Departs, String>{

}
