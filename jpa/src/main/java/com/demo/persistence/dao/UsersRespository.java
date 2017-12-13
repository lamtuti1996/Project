package com.demo.persistence.dao;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.demo.persistence.model.Users;

public interface UsersRespository extends CrudRepository<Users, String>{

}
