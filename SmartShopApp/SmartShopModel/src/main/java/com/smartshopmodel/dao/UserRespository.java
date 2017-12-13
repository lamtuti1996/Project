package com.smartshopmodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartshopcommon.model.Users;




public interface UserRespository extends JpaRepository<Users, String> {
          Users findByEmail(String email);
}
