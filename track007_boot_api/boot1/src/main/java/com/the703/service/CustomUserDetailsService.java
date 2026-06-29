package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired AppUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1. username "1@1:local" / "2@2:kakao"
		String [] parts = username.split(":"); // : 을 기준으로 1@1, local 로 나눔
		String email = parts[0];
		// local - 회원가입한 사람
		String provider = parts.length > 1 ? parts[1] : "local";
		
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		dto.setProvider(provider);
		
		// username, password, List<AuthDto>
		AppUserAuthDto authDto =  dao.readAuthByEmail(dto);
		
		// 사용자 정보들
		AppUserDto appUserDto =  dao.findByEmail(dto);
		
		// 사용자 정보, 사용자 로그인정보
		return new CustomUserDetails(appUserDto, authDto);
	}
}
