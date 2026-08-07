package com.thejoa703.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.entity.Post;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag( name = "Post Api", description = "게시판 관련 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	// 게시글 단건조회
	@Operation( summary = "게시글 단건 조회", description = "사용자 ID로 특정 게시글을 조회합니다.")
	@GetMapping("{id}")
	public ResponseEntity<PostResponseDto> getPostById(@PathVariable("id") Long id){
		Post response = postService.getPostById(id);
		return ResponseEntity.ok(new PostResponseDto(response));
	}
	
	// 주소창에서 값을 받음 -> @PathVariable
	// 게시글 수정 -> /api/posts/{postId}
	@Operation( summary = "게시글 수정", description = "특정 게시글을 수정합니다.")
	@PatchMapping( value = "/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostResponseDto> updatePost(
			@Parameter(description = "수정할 글의 ID")
			@PathVariable("postId") Long postId,
			@Parameter(description = "작성자의 사용자 ID")
			@RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto request, // multipart/form-data
			@Parameter(description = "업로드 할 이미지 파일 리스트") // swagger	
			@RequestPart(name = "files", required = false) List<MultipartFile> files	
			
	){
			
		return ResponseEntity.ok( postService.updatePost(postId, userId, request, files));
	}
	
	// 게시글 삭제
	@Operation( summary = "게시글 삭제", description = "게시글을 삭제합니다.")
	@DeleteMapping("{id}")
	public ResponseEntity<Long> deletePost(@PathVariable("id") Long id) {
		postService.deletePost(id);
		return ResponseEntity.ok(id);
	}
	
	// 전체 게시글 조회
	@Operation( summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getAllPost(){
		List<Post> posts = postService.getAllPosts();
		
		List<PostResponseDto> response = posts.stream()
				.map( post -> new PostResponseDto(post))
				.toList();
		
		return ResponseEntity.ok(response);
		
	}
	
	// 게시글 작성
	@Operation( summary = "게시글 작성", description = "새로운 게시글을 등록합니다.")
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostResponseDto> createPost(
			@Parameter(description = "작성자의 사용자 ID")
			@RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto request, // multipart/form-data
			@Parameter(description = "업로드 할 이미지 파일 리스트") // swagger	
			@RequestPart(name = "files", required = false) List<MultipartFile> files
	){
		return ResponseEntity.ok( postService.createPost(userId, request, files) );
	}
//	public ResponseEntity<Post> createPost(@RequestBody PostRequestDto requestDto) {
//		Post response = postService.createPost(requestDto.getUserId(), requestDto.getContent());
//		System.out.print("................."+response);
//		return ResponseEntity.status(HttpStatus.CREATED).body(response);
//	}

}
