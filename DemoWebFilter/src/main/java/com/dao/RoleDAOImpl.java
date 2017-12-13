package com.dao;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import org.springframework.stereotype.Repository;

import com.bean.Role;
import com.bean.RoleUser;
import com.bean.User;


@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	public String ABC = "3";
	
	@Override
	public Set<Role> getRole(User user) {
		

		// Fake data Role
		Role r1 = new Role(1, "Student");
		Role r2 = new Role(2, "Teacher");
		Role r3 = new Role(3, "Admin");

		Set<Role> listRole = new HashSet<Role>();
		listRole.add(r1);
		listRole.add(r2);
		listRole.add(r3);
		
		// Fake data RoleUser
		RoleUser ru1 = new RoleUser(1, 1, 1);
		RoleUser ru2 = new RoleUser(2, 2, 1);
		RoleUser ru3 = new RoleUser(3, 3, 1);
		RoleUser ru4 = new RoleUser(4, 2, 2);
		RoleUser ru5 = new RoleUser(5, 3, 3);

		Set<RoleUser> listRoleUser = new HashSet<RoleUser>();
		listRoleUser.add(ru1);
		listRoleUser.add(ru2);
		listRoleUser.add(ru3);
		listRoleUser.add(ru4);
		listRoleUser.add(ru5);

		// Search and return Role[]
		Set<Role> listRoleReturn = new HashSet<Role>();
		for (RoleUser roleUser : listRoleUser) {
			if (user.getUserId() == roleUser.getUserId()) {
				for (Role role : listRole) {
					if (roleUser.getRoleId() == role.getRoleId()) {
						listRoleReturn.add(role);
					}
				}
			}
		}
		
		
		JButton btn = new JButton();
//		btn.addActionListener();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return listRoleReturn;
	}

}
