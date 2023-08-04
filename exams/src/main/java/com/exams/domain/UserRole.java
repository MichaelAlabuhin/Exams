package com.exams.domain;

public enum UserRole {
	ROLE_ADMIN, ROLE_USER;
	
	public String getRoleName() {
		return name();
	}
}
