package com.smartshopmodel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.Role;
import com.smartshopmodel.dao.RoleRespository;




@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRespository respository;



	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return respository.findByName(name);
	}

}
