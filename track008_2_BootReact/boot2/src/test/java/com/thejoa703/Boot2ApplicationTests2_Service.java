package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

@SpringBootTest
@Transactional  // 테스트 완료 후에 데이터 자동 롤백
class Boot2ApplicationTests2_Service {
	
	@Autowired UserService userService;
	
	// 공통으로 사용할 유저를 생성해주는 헬퍼 메서드
    private Long createTestUser(String email, String nickname) {
        UserRequestDto signupDto = new UserRequestDto();
        signupDto.setEmail(email);
        signupDto.setPassword("password123");
        signupDto.setNickname(nickname);
        signupDto.setProvider("local");

        MockMultipartFile profileImage = new MockMultipartFile(
                "profileImage", "test.png", "image/png", "test image content".getBytes()
        );

        UserResponseDto res = userService.createUser(signupDto, profileImage);
        return res.getId();
    }
	
	// =========================================
	// UserService - CRUD
	// =========================================
	
	@Test
	@Order(1)
	@DisplayName("UserSerivce - CRUD: 회원가입, 로그인, 마이페이지, 수정, 삭제")
	void testAppUserSerivce() {
		
		// 로그인
		Long userId = createTestUser("22@22","2");
		
		LoginRequest loginDto = new LoginRequest();
		loginDto.setEmail("22@22");
		loginDto.setPassword("password123");
		loginDto.setProvider("local");
		
		UserResponseDto loginRes = userService.login(loginDto);
		assertThat(loginRes).isNotNull();
		assertThat(loginRes.getId()).isEqualTo(userId);
		
		// 이메일 중복 검사 - 존재 여부 확인
		boolean emailChk = userService.existsByEmail("22@22");
		assertThat(emailChk).isTrue();
		
		// 닉네임 중복 검사 - 존재 여부 확인
		boolean nicknameChk = userService.existsByNickname("2");
		assertThat(nicknameChk).isTrue();

		// 마이페이지
		UserResponseDto foundUser = userService.getUser(userId);
		assertThat(foundUser.getNickname()).isEqualTo("2");
		
		// 유저 닉네임 수정
		UserResponseDto updateUser = userService.updateNickname(userId, "3");
		assertThat(updateUser.getNickname()).isEqualTo("3");
		
		// 유저 삭제
		userService.deleteById(userId);
		//UserResponseDto deleteUser = userService.getUser(userId);
		//assertThat(deleteUser).isNull();
	}
	
	
}


