package com.smartshopmodel.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.Role;
import com.smartshopcommon.model.Users;
import com.smartshopmodel.dao.UserRespository;


@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRespository respository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u = respository.findByEmail(username);

		if (u == null) {
			throw new UsernameNotFoundException("User not found");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> roles = u.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(),
				grantedAuthorities);
	}



	@Override
	public Users findByEmail(String email) {
		return respository.findOne(email);
	}

	@Override
	public void updateLastAccess(Users u) {
		respository.save(u);

	}

	@Override
	public void saveUser(Users u) {
		respository.save(u);

	}

}
