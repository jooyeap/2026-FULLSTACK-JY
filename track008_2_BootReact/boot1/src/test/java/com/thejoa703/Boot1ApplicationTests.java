package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional  // 테스트 완료 후에 데이터 자동 롤백
class Boot1ApplicationTests {

	@Autowired AppUserRepository appUserRepository;
	@Autowired PostRepository postRepository;
	private AppUser savedUser;
	private Post savedPost;
	// insert, update ( save ) select ( findBy필드명 )
	// delete deletedBy
	
	
	
	// ============================================
	// 1. CREATE ( 생성 테스트 )
	// ============================================
	
	@BeforeEach
	void createTest() {
		
		//// AppUser 공통으로 사용할 테스트용 회원
		AppUser user = AppUser.builder()
					   .email("z@z")
					   .password("z")
					   .nickname("zzzz")
					   .provider("local")
					   .build();
		savedUser = appUserRepository.save(user);
		
		//// Post 공통으로 사용할 테스트 게시글
		Post post = new Post();
		post.setContent("CRUD 테스트용 게시글");
		post.setUser(savedUser);
		savedPost = postRepository.save(post);
	}
	
	@Test
	@DisplayName("1. CREATE 생성테스트 (SAVE) ")
	void testCreate() {
		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedPost.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("2. READ 생성테스트 (findBy) ")
	void testRead() {
		Optional<AppUser> foundUser =  appUserRepository.findById(savedUser.getId());
		assertThat(foundUser).isPresent(); // true, false
		assertThat(foundUser.get().getNickname()).isEqualTo("zzzz");
		
		Optional<AppUser> foundEmail = appUserRepository.findByEmail("z@z");
		assertThat(foundEmail).isPresent();
		assertThat(foundEmail.get().getEmail()).isEqualTo("z@z");
		
		List<Post> posts = postRepository.findByDeletedFalse();
		assertThat(posts).isNotEmpty();
		
	}
	
	@Test
	@DisplayName("3. UPDATE 생성테스트 (SAVE) ")
	void testUpdate() {
		AppUser user = AppUser.builder()
				   .email("z@z")
				   .password("z")
				   .nickname("zz")
				   .provider("local")
				   .build();
		savedUser = appUserRepository.save(user);
		
		assertThat(savedUser.getNickname()).isEqualTo("zz");
		
		savedUser.setNickname("zero");
		appUserRepository.save(savedUser);
		
		savedPost.setContent("new 20260727");
		postRepository.save(savedPost);
		
		AppUser updatedUser = appUserRepository.findById(savedUser.getId()).get();
		Post updatedPost = postRepository.findById(savedPost.getId()).get();
		
		assertThat(updatedUser.getNickname()).isEqualTo("zero");
		assertThat(updatedPost.getContent()).isEqualTo("new 20260727");
	}
	
	@Test
	@DisplayName("4. DELETE 생성테스트 (DELETE)")
	void testDelete() {
		appUserRepository.delete(savedUser);
		postRepository.delete(savedPost);
		
		Optional<AppUser> deletedUser = appUserRepository.findById(savedUser.getId());
		Optional<Post> deletedPost = postRepository.findById(savedPost.getId());
		
		assertThat(deletedUser).isEmpty();
		assertThat(deletedPost).isEmpty();
	}
}

/// jpa : save(insert, update) / delete(delete) / findBy필드명(select)
