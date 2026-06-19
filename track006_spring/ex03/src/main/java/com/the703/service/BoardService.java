package com.the703.service;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.BoardDto;

public interface BoardService {
	
	// 1. 전체리스트
    public List<BoardDto> selectAll();
    
    // 2. 글작성 처리
    public int insert(BoardDto dto); // 성공 실패 값 둘 중 하나를 리턴해줌
    
    // 3. 글 상세보기 - 조회수 처리 / 해당 글
    public BoardDto detail(int bno); // bno를 넘겨받아서 sql문에서 처리
    
    // 4-1. 글 수정 전 조회 - 해당 글
    public BoardDto editView(int bno); // 수정 화면
    
    // 4-2. 글 수정 처리 - 비밀번호 일치 확인 후 수정
    public int edit(BoardDto dto); // 유저가 입력했던 글 정보로 데이터 수정
    
    // 6. 글 삭제처리 - 비밀번호 일치 확인후 삭제
    public int delete(BoardDto dto); // 데이터 삭제
    
    // 비밀번호 체크
    public int passCheck(BoardDto dto);

    
    // paging
    public List<BoardDto> select10(int pstartno);
    public int selectCnt();
}
