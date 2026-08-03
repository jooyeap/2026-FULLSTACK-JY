package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.service.PostService;
import com.thejoa703.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional  // 테스트 완료 후에 데이터 자동 롤백
class Boot1ApplicationTests2_Service {

	@Autowired private AppUserRepository appUserRepository;
	@Autowired private UserService userService;
	@Autowired private PostService postService;
	private AppUser testUser;
	
	@BeforeEach
    void createTest() {
		//// AppUser  공통으로 사용할 테스트용 회원
        AppUser  user = AppUser.builder()
        		.email("z@z")
        		.password("z")
        		.nickname("first")
        		.provider("local")
        		.build(); 
        testUser = appUserRepository.save(user);
       
   }
	
	@Test
	@DisplayName("1. 회원가입 및 사용자 간단 테스트")
	public void testCreate() {
		
        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setEmail("1@1");
        requestDto.setPassword("1");
        requestDto.setNickname("first");
        requestDto.setMobile("010111111");
        requestDto.setMbtitype(2);
        
        UserResponseDto createdUser = userService.createUser(requestDto);
        assertThat(createdUser.getId()).isNotNull();
        assertThat(createdUser.getEmail()).isNotNull();
        
        UserResponseDto foundUser = userService.getUser(createdUser.getId());
        assertThat(foundUser.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("2. 게시글 작성 테스트")
	public void testPost() {
		
		Post post = postService.createPost(testUser.getId(), "테스트");
		
		assertThat(post.getId()).isNotNull();
		assertThat(post.getContent()).isNotNull();
		
	}
	
	@Test
	@DisplayName("3. 게시글 수정 및 검색 테스트")
	public void testUpdatePost() {
		// 게시글 작성
		Post post = postService.createPost(testUser.getId(), "테스트");
		assertThat(post.getId()).isNotNull();
		
		// 게시글 수정
		Post updated = postService.updatePost(post.getId(), "수정");
		assertThat(updated.getContent()).isEqualTo("수정");
		
		// 게시글 조회, 수정 확인
		Post found = postService.getPostById(post.getId());
		assertThat(found.getContent()).isEqualTo("수정");
	}
	
	@Test
	@DisplayName("4. 게시글 삭제 테스트")
	public void testDeletePost() {
		// 게시글 작성
		Post post = postService.createPost(testUser.getId(), "테스트");
		assertThat(post.getId()).isNotNull();
		
		// 게시글 삭제
		postService.deletePost(post.getId());
		assertThat(post.getDeleted()).isTrue();
		
		// 여러 글
		List<Post> posts = postService.getAllPosts();
		boolean exists = posts.stream()
			 .anyMatch( test -> test.getId().equals(post.getId()));
		assertThat(exists).isFalse();
	}
}
