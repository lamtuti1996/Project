package com.dao;

import java.util.Set;

import com.bean.Role;
import com.bean.User;

public interface RoleDAO {
	public Set<Role> getRole(User student) ;
}
