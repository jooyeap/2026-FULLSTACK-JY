package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper dao;
	
	@Override // 회원가입
	public int join(UserDto dto) {
		return dao.insert(dto);
	}

	@Override // 유저 조회
	public UserDto mypage(int uno) {
		return dao.select(uno);
	}

//	@Override // 로그인 폼 이거 일단 보류
//	public void login() {
//		
//	}

	@Override // 로그인 기능
	public UserDto loginAction(String nickname, String inputPw) {
		UserDto dto = dao.selectLogin(nickname);
		
		if(dto == null) {
			// null 예외 발생 대비
			return null;
		}
		if(dto.getBpass().equals(inputPw)) {
			return dto;
		}
		
		return null;
	}

}
