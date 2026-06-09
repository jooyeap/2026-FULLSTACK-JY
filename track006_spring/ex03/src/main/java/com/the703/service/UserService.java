package com.the703.service;

import java.util.List;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

public interface UserService {
	
	// join 회원가입
	public int insert(UserDto dto);
	
	// 로그인	
	public int findLogin(UserDto dto);
	
	// 마이페이지
	public UserDto findByUno(int uno);
	
	// email 중복확인
	public String findByEmail(String email);
	
	// 로그인 이후 유저 데이터 가져오기
	public UserDto findUser(String email);
	
	public int insertAuth(AuthDto dto);
	
	public AuthListDto readAuth (AuthDto dto);
}
