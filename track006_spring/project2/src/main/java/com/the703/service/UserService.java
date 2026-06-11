package com.the703.service;

import com.the703.dto.AuthUserDto;

public interface UserService {
	public AuthUserDto readAuth(String email);
	public String emailCheck(String email);
}
