package com.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.persistence.model.Records;

public interface RecordsRespository  extends JpaRepository<Records, Integer>{

}
