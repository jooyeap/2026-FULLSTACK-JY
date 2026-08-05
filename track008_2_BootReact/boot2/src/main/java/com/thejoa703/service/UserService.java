package com.thejoa703.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.exception.ResourceNotFoundException;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true ) // 데이터 저장 ( insert )시 rollback / readOnly = true 읽기 전용, 낭비
public class UserService {

	// @AutoWired 대신 @RequiredArg~~~ 를 사용
	private final AppUserRepository appUserRepository;
	// 파일 올리기, 
	private final FileStorageService fileStorageService;
	
	// 비밀번호 암호화
	
	// Create : 회원가입
	@Transactional
	public UserResponseDto createUser(UserRequestDto request,
									  MultipartFile profileImage) {
		String provider = request.getProvider()
				!= null ? request.getProvider() : "local";
		
		// 이메일 중복
		if(appUserRepository.findByEmailAndProvider(request.getEmail(), provider).isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
		}
		
		// 닉네임 중복
		if(appUserRepository.existsByNickname(request.getNickname())) {
			throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
		}
		
		AppUser user = new AppUser();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword()); // 암호화
		user.setNickname(request.getNickname());
		user.setProvider(provider);
		user.setRole("ROLE_USER");
		user.setUfile( profileImage != null && !profileImage.isEmpty()
					 ? fileStorageService.upload(profileImage)
					 : "uploads/thejoa703.png");
		
		// 유저 생성
		return UserResponseDto.fromEntity(appUserRepository.save(user));
	}
	
	// Read : 이메일 중복 검사
	public boolean existsByEmail(String email) {
		return appUserRepository.existsByEmail(email);
	}
	
	// Read : 닉네임 중복 검사
	public boolean existsByNickname(String nickname) {
		return appUserRepository.existsByNickname(nickname);
	}
	
	// Read : 로그인
	public UserResponseDto login(LoginRequest request) {
		
		AppUser user = appUserRepository
						.findByEmailAndProvider(
								request.getEmail(),
								request.getProvider() != null ? request.getProvider() : "local")
						.orElseThrow( () -> new ResourceNotFoundException("사용자를 찾을수 없습니다"));
		
		return UserResponseDto.fromEntity(user);
	}
	
	// Read : 사용자 단건 조회
	@Transactional
	public UserResponseDto getUser(Long userId) {
		AppUser user = appUserRepository.findById(userId)
				.orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 사용자입니다. id: "+ userId));
		return UserResponseDto.fromEntity(user);
	}
	
	// Read : 전체 사용자 수 (관리자)
	public long countUsers() {
		return appUserRepository.count();
	}
	
	// Update : 닉네임 변경
	@Transactional
	public UserResponseDto updateNickname(Long userId, String newNickname) {
		
		if(appUserRepository.existsByNickname(newNickname)) {
			throw new ResourceNotFoundException("이미 사용중인 닉네임 입니다.");
		}
		
		// 해당 유저 번호 받아서 유저 찾기
		AppUser user = appUserRepository.findById(userId)
						.orElseThrow( () -> new ResourceNotFoundException("사용자를 찾을수 없습니다."));
		// 값 변경 -> 트랜젝션 종료시 자동 update ( save 한 효과 )
		user.setNickname(newNickname);
						
		return UserResponseDto.fromEntity(user);
	}
	
	// Update : 프로필 이미지 변경
	public UserResponseDto updateProfileImage(Long userId, MultipartFile newProfileImage) {
		
		AppUser user = appUserRepository.findById(userId)
						.orElseThrow( () -> new ResourceNotFoundException("사용자를 찾을수 없습니다."));
		user.setUfile( newProfileImage != null && !newProfileImage.isEmpty()
					 ? fileStorageService.upload(newProfileImage)
					 : "uploads/thejoa703.png");
		return UserResponseDto.fromEntity(user);
	}
	
	// Delete : 회원탈퇴
	public void deleteById(Long userId) {
		if(!appUserRepository.existsById(userId)) {
			throw new ResourceNotFoundException("삭제할 사용자가 존재하지 않습니다. ID: " + userId);
		}
		
		// 소프트 딜리트 / 삭제가 아니고 컬럼 변경 - 프로필 이미지 변경 처럼 작성 
//		AppUser user = appUserRepository.findById(userId)
//				.orElseThrow( () -> new IllegalArgumentException("사용자를 찾을수 없습니다."));
//		user.setDeleted(true);
//		
//		return UserResponseDto.fromEntity(user); // 리턴값 void -> UserResponseDto
		
		// 하드 딜리트 / 실제 db에서 삭제
		appUserRepository.deleteById(userId);
	}
}
