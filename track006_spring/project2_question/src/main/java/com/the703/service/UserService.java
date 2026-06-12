package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {

	public     AuthUserDto    readAuth( String email );
	
	public String findByEmail(String email);
	public UserDto findByNickname(String nickname);
	public int insert(UserDto dto);
	public int insertAuth(AuthDto dto);
	public int login (UserDto dto);
	
	public UserDto findByEmailUserInfo(String email);
}

