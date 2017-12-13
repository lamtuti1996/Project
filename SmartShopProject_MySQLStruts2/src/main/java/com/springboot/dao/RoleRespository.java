package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Role;

public interface RoleRespository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
