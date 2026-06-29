package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.service.AppUserService;

@SpringBootTest
class Boot1ApplicationTests2 {
	
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	// 삭제
	@Disabled
	@Test
	public void delete_Serivce() {
		AppUserDto user = new AppUserDto();
		
		user.setAppUserId(61);
		user.setEmail("2@2");
		user.setPassword("2");
		user.setProvider("local");
		
		assertEquals(1, service.delete(user, false));
	}
	
	// 수정
	@Disabled
	@Test
	public void update_Service() {
		AppUserDto user = new AppUserDto();
		
		user.setAppUserId(61);
		user.setEmail("2@2");
		user.setPassword("2");
		user.setMbtiTypeId(2);
		user.setNickname("2test");
		user.setProvider("local");
		user.setProviderId("local_002");
		
		assertEquals(1, service.update(null, user));
		
	}
	
	// 아이디중복
	@Disabled
	@Test
	public void iddouble_Service() {
		assertEquals(1, service.iddouble("2@2", null));
	}
	
	// 마이페이지
	@Disabled
	@Test
	public void mypage_Service() {
		assertEquals("2@2", service.selectEmail("2@2", null).getEmail());
	}
	
	// 로그인
	@Disabled
	@Test
	public void login_Service() {
		AppUserAuthDto login = service.readAuthByEmail("2@2", "local"); 
		assertNotNull(login);
		assertEquals("2@2", login.getEmail());
		assertTrue(login.getAuthList().stream().anyMatch(a -> "ROLE_MEMBER".equals(a.getAuth())));
	}
	
	@Disabled
	@Test
	public void insert_Service() {
		
		AppUserDto user = new AppUserDto();
		
		user.setEmail("2@2");
		user.setPassword("2");
		user.setMbtiTypeId(2);
		user.setUfile("2.png");
		user.setMobile("000-2222-2222");
		user.setNickname("2");
		user.setProvider("local");
		user.setProviderId("local_002");
		
		MockMultipartFile file = new MockMultipartFile("file", "test.text", "text/plain", "data".getBytes());
		
		int result = service.insert(file, user);
		assertEquals(1, result);
	}
	
	
	
	//////////////////////////////////////////////////////////
	// 6. 수정 ( 동적 sql )
	@Disabled
	@Test
	public void update_User() {
		AppUserDto user = new AppUserDto();
		
		user.setPassword("1");
		user.setMbtiTypeId(1);
		user.setUfile("1.png");
		user.setNickname(null);
		user.setMobile(null);
		user.setProvider(null);
		user.setProviderId(null);
	}
	
	// 5. 사용자삭제 + 권한삭제
	@Disabled
	@Test
	public void delete_User() {
		AppUserDto user = new AppUserDto();
		
		user.setAppUserId(22);
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1");
		
		assertEquals(1, dao.deleteAppUser(user));
		assertEquals(1, dao.deleteAuth(auth));
	}
	
	// 4. 마이페이지
	@Disabled
	@Test
	public void mypage_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("1@1");
		
		assertNotNull(dao.findByEmail(user));
		assertEquals("1@1", dao.findByEmail(user).getEmail());
	}
	
	// 3. 아이디 중복
	@Disabled
	@Test
	public void findEmail_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("1@1");
		
		assertEquals(1, dao.iddoubleByEmail(user));
	}
	
	// 2. 로그인
	@Disabled
	@Test
	public void login_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("1@1");
		user.setPassword("1");

		AppUserAuthDto test = dao.readAuthByEmail(user);
		assertNotNull(test);
	}
	
	// 1. 회원가입 / 유저등록 + 권한 등록
	@Disabled
	@Test
	public void insert_User() {
		AppUserDto user = new AppUserDto();
		
		user.setEmail("1@1");
		user.setPassword("1");
		user.setMbtiTypeId(1);
		user.setUfile("1.png");
		user.setMobile("000-1111-1111");
		user.setNickname("1");
		user.setProvider("local");
		user.setProviderId("1");
		
		int userInsert = dao.insertAppUser(user);
		assertEquals(1, userInsert);
		
		AuthDto auth = new AuthDto();
		
		auth.setEmail("1@1");
		auth.setAuth("ROLE_USER");
		
		int authInsert = dao.insertAuth(auth);
		assertEquals(1, authInsert);
	}
}
