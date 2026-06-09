package com.the703.service;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.BoardDto;

public interface BoardService {
	
	// 1. 전체리스트
	public List<BoardDto> selectAll();
	
	// 2. 글쓰기 기능
	public int insert(BoardDto dto); // 제목 이름 등 다 데이터 넣어야함
	
	// 3. 글 상세보기 - 조회수 처리 / 해당 글 
	public BoardDto detail(int bno); // bno만 가져와서 sql구문으로 처리
	
	// 4-1. 글 수정 폼 경로 - 해당 글
	public BoardDto editView(int bno); // 위와 동일
	
	// 4-2. 글 수정 기능 - 비밀번호 일치 확인 후 수정
	public int edit(BoardDto dto); // 기존에 입력했던 글 같은걸 다 가져와야함
	
	// 6. 글 삭제기능 - 비밀번호 일치 확인후 삭제
	public int delete(BoardDto dto); // 위와 동일
	
	// 비밀번호 체크
	public int passCheck(BoardDto dto);

	
	// paging
	public List<BoardDto> select10(int pstartno);
	public int selectCnt();

}
