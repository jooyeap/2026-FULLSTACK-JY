package com.the703.service;

import com.the703.dto.UserDto;

public interface UserService {
	
	// 회원 가입
	public int join(UserDto dto);
	
	// 유저 조회 ( 내 정보 ) / 로그인 됐을때만
	public UserDto mypage(int uno);
	
	// 유저 로그인 폼 이게 sql구문이 필요한가..?
//	public void login();
	
	// 유저 로그인 기능
	public UserDto loginAction(String userId, String inputPw);
	
	//////////////////////////////// 선생님 주신 파일
	
	// 전체 리스트
	
	// 회원 탈퇴 
}
