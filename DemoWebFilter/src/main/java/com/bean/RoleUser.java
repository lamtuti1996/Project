package com.bean;

public class RoleUser {

	private int roleUserId;
	private int roleId;
	private int userId;

	public int getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(int roleUserId) {
		this.roleUserId = roleUserId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setStudentId(int userId) {
		this.userId = userId;
	}

	public RoleUser() {
	}

	public RoleUser(int roleUserId, int roleId, int userId) {
		super();
		this.roleUserId = roleUserId;
		this.roleId = roleId;
		this.userId = userId;
	}

}
