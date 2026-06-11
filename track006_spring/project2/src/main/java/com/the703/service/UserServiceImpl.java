package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dto.AuthUserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserService user;
	
	@Override
	public AuthUserDto readAuth(String email) {
		return user.readAuth(email);
	}

	@Override
	public String emailCheck(String email) {
		return user.emailCheck(email);
	}
	
}

