package com.exams.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exams.dao.UserRepository;
import com.exams.domain.User;
import com.exams.domain.UserRole;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
	public void saveUser(User user) {
		logger.info("Register new user {} : " + user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER.getRoleName());
        userRepository.save(user);
    }
	
	public User findUserByEmail(String email) {
		logger.info("Get user {} by email: " + email);
		return userRepository.findUserByEmail(email).get();
	}
	
}
