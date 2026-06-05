package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardMapper dao; // db관련

	@Override
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insert(BoardDto dto) {
		// ip 주소 처리
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto);
	}

	@Override
	public BoardDto detail(int bno) {
		// 조회수 증가 처리
		dao.updateBhit(bno);
		return dao.select(bno);
	}

	@Override
	public BoardDto editView(int bno) {
		// 수정 폼
		return dao.select(bno);
	}

	@Override
	public int edit(BoardDto dto) {
		// 비밀번호 일치하면 수정
//		if(dao.passCheck(dto) > 0) {
//		return dao.update(dto);
//		}
//		else{return 0;}
		return dao.update(dto);
	}

	@Override
	public int delete(BoardDto dto) {
		//비밀번호 일치하면 삭제
//		if(dao.passCheck(dto) > 0) {
//			return dao.delete(dto.getBno());
//		}
//		else{return 0;}
		return dao.delete(dto);
	}

	@Override
	public int passCheck(BoardDto dto) {
		return dao.passCheck(dto);
	}
	
	

}
