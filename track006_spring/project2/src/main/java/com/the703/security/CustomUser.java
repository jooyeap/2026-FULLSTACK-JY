package com.the703.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.the703.dto.AuthUserDto;

import lombok.Getter;

@Getter 
public class CustomUser extends User{  
	private static final long serialVersionUID = 1L; 
	
	AuthUserDto dto;
 
	// 1. 유저 아이디와 비밀번호를 받아서 권한이 있는지 체크
	public CustomUser(String username, 
				      String password, 
				      Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities); 
	}
	
	// 2. username, password에 맞게 세팅
	public CustomUser(AuthUserDto dto) {
		super(
			dto.getEmail(),
			dto.getBpass(),
			dto.getAuthList() // 권한 리스트 가져옴
			.stream() // 리스트를 하나씩 데이터로 변환
			// auth객체에서 auth.getAuth()를 꺼낸뒤
			// spring security 가 알아먹을수 있게
			// new SimpleGrantedAuthority 로 변환
			.map( auth -> new SimpleGrantedAuthority(auth.getAuth()))
			// 변환된 객체들을 다시 리스트로 수집
			.collect( Collectors.toList() )
		);
			// 결과적으로 Spring Security가 요구하는 포맷의 권한 리스트
			// Collection<? extends GrantedAuthority>가 완성되어 super()에 전달
		this.dto = dto;
	}
}
