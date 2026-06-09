package com.the703.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper dao;

	@Override
	public int insert(UserDto dto) {
		int result = dao.insert(dto);
		AuthDto auth = new AuthDto();
		auth.setEmail(dto.getEmail());
		auth.setAuth("ROLE_MEMBER");
		dao.insertAuth(auth);
		return result;
	}

	@Override
	public int findLogin(UserDto dto) {
		return dao.findLogin(dto);
	}

	@Override
	public UserDto findByUno(int uno) {
		return dao.findByUno(uno);
	}

	@Override
	public String findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public UserDto findUser(String email) {
		return dao.findUser(email);
	}

	@Override
	public int insertAuth(AuthDto dto) {
		return dao.insertAuth(dto);
	}

	@Override
	public AuthListDto readAuth(AuthDto dto) {
		return dao.readAuth(dto);
	}

}
