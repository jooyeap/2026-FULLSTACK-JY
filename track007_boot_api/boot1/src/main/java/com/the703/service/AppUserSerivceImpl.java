package com.the703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.util.UtilUpload;

@Service
public class AppUserSerivceImpl implements AppUserService{
	
	@Autowired private AppUserDao dao;
	@Autowired private UtilUpload upload;
	@Autowired private PasswordEncoder encoder;

	@Transactional // sql 구문 실행할때 중간에서 오류나면 뒤 실행 안함
	@Override
	public int insert(MultipartFile file, AppUserDto dto) {
		
		// 이미지 업로드
		if(!file.isEmpty()) {
			try { 
				dto.setUfile(upload.fileUpload(file));
			} catch (IOException e) { e.printStackTrace(); }
		}
		else { dto.setUfile("the703.png"); }
		
		// 비밀번호 암호화
		dto.setProvider("the703");
		dto.setPassword(encoder.encode(dto.getPassword()));
		int result = dao.insertAppUser(dto); // #sql1
		
		// 권한 설정
		if(result > 0) {
			AuthDto adto = new AuthDto();
			adto.setEmail( dto.getEmail() );
			adto.setAuth("ROLE_MEMBER");
			dao.insertAuth(adto); // #sql2
		}
		return result;
	}

	@Transactional
	@Override
	public int update(MultipartFile file, AppUserDto dto) {
		
		// 비밀번호 확인
		if(!matchesPassword(dto.getEmail(),
							dto.getProvider(),
							dto.getPassword())){
			return 0;				
		}
		
		// 이미지 업로드
		if(file != null && !file.isEmpty()) {
			try {
				dto.setUfile( upload.fileUpload(file) );
			} catch (IOException e) { e.printStackTrace(); }
		}
		
		return dao.updateAppUser(dto);
	}

	@Transactional
	@Override
	public int delete(AppUserDto dto, boolean local) {
		
		AuthDto adto = new AuthDto();
		adto.setEmail(dto.getEmail());
		adto.setAuth("ROLE_MEMBER");
		
		// 비밀번호가 안맞으면 0
		if(!matchesPassword(dto.getEmail(),
							dto.getProvider(),
							dto.getPassword())) {
			return 0;
		}
		
		dao.deleteAuth(adto);
		return dao.deleteAppUser(dto);
	}

	// 로그인
	@Override
	public AppUserAuthDto readAuthByEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);

		return dao.readAuthByEmail(dto);
	}

	// 마이페이지
	@Override
	public AppUserDto selectEmail(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		
		return dao.findByEmail(dto);
	}

	// 이메일 중복
	@Override
	public int iddouble(String email, String provider) {
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		
		return dao.iddoubleByEmail(dto);
	}

	// 비밀번호 맞는지 확인
	@Override
	public boolean matchesPassword(String email, String provider, String rawPassword) {
		
		// 1. dbUser 찾기
		AppUserDto dto = new AppUserDto();
		dto.setEmail(email);
		AppUserDto user = dao.findByEmail(dto);
		
		// 2. 비밀번호 일치 확인

		// 사용자가 입력한 비밀번호와 db상의 비밀번호를 매칭
		return user != null && user.getPassword() != null &&
				encoder.matches(rawPassword, user.getPassword());
	}

}
