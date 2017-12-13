package com.smartshopmodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartshopcommon.model.Role;





public interface RoleRespository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
