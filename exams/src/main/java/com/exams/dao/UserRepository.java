package com.exams.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exams.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findUserByEmail(String email);
	
}
