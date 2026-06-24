package com.the703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.Sboard2Dto;

public interface Sboard2Service {

	// 1. 전체 페이징
	public List<Sboard2Dto> list10(int pageNo);
	
	// 2. 갯수 카운트
	public int selectCnt();
	
	// 3. 상세 조회 ( 조회수 올리기 )
	public Sboard2Dto detail(Sboard2Dto dto);
	
	// 4. 입력 기능 ( 이미지 올리기 )
	public int insert(Sboard2Dto dto, MultipartFile file);
	
	// 5. 수정 폼
	public Sboard2Dto updateForm(Sboard2Dto dto);
	
	// 6. 수정 기능 ( 이미지 올리기 )
	public int update(Sboard2Dto dto, MultipartFile file);
	
	// 7. 삭제 기능
	public int delete(Sboard2Dto dto);
}
