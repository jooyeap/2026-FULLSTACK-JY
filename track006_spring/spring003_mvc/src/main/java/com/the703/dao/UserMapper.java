package com.the703.dao;

import java.util.List;

import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public int insert(UserDto dto);
	public List<UserDto> selectAll();
	public UserDto select(int no);
	public int update(UserDto dto);
	public int delete(int no);
	public UserDto selectLogin(String nickname);
}
