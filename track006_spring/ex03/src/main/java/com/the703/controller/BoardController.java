package com.the703.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	
	// 각 파트별로 db가 필요한가를 기준으로 봐야함
	
	// 1. 전체 리스트 이전버전
//	@RequestMapping("/board/list.do")
//	public String list(Model model) {
//		model.addAttribute("list", service.selectAll()); // 데이터 넘겨주기
//		return "board/list";
//	}
	// /view/ + board/list + .jsp
	//http://localhost:8080/spring003_mvc/board/list.do
	
	@RequestMapping("/board/list.do")
	public String list(Model model,	@RequestParam(value = "pstartno", defaultValue = "1") int pstartno) {
		
		model.addAttribute("paging", new PagingUtil(service.selectCnt(),pstartno));
		model.addAttribute("list", service.select10(pstartno)); // 데이터 넘겨주기
		return "board/list";
	}
	
	// 2-1. 글 쓰기폼 경로
	@RequestMapping( value = "/board/write.do", method = RequestMethod.GET )
	public String write() {
		return "board/write";
	}
	//http://localhost:8080/spring003_mvc/board/write.do
	
	// 2-2. 글쓰기 기능
	
	// 파일 추가 전
//	@RequestMapping( value = "/board/write.do", method = RequestMethod.POST )
//	public String write_post(BoardDto dto, RedirectAttributes rttr) {
//		String result = "글쓰기 실패";
//		if(service.insert(dto) > 0) { result = "글쓰기 성공"; }
//		rttr.addFlashAttribute("result",result); // Flash - 한번만 동작
//		return "redirect:/board/list.do"; // response.sendRedirect + alert 처리가안됨
//	}
	
	// sql에 이미지파일 뭐들어갔는지 알아야하니까 테이블 구조 수정해야할거같음 / bimg 로 추가완료
	@RequestMapping( value = "/board/write.do", method = RequestMethod.POST )
	public String write_post(BoardDto dto, RedirectAttributes rttr,
							 @RequestParam("file") MultipartFile file,
							 Model model) throws IllegalStateException, IOException {
		String result = "글쓰기 실패";
		if(file.getOriginalFilename() != "the703.png" && !file.isEmpty()) {
			String uploadPath = "C:/file/";
			File dest = new File( uploadPath + file.getOriginalFilename());
			file.transferTo(dest);
			dto.setBimg(file.getOriginalFilename());
		}
		if(service.insert(dto) > 0) { result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result",result); // Flash - 한번만 동작
		return "redirect:/board/list.do"; // response.sendRedirect + alert 처리가안됨
	}
	
	// 3. 글 상세보기
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
		return "board/detail";
	}
	//http://localhost:8080/spring003_mvc/board/detail.do
	
	// 4-1. 글 수정폼 경로
	@RequestMapping( value = "/board/edit.do", method = RequestMethod.GET)
	public String edit(int bno, Model model) {
//		String result = "글 수정 실패";
//		BoardDto dto = service.editView(bno);
//		if(service.edit(dto) > 0) {
//			result = "글 수정 성공";
//			model.addAttribute("dto",service.editView(bno));
//			return "board/edit";
//		}
//		else {
//			model.addAttribute("result", result);
//			return "board/detail?bno="+bno;
//		}
//			
//		String result = "비밀번호 확인";
//		BoardDto dto = service.editView(bno);
//		if(service.passCheck(dto) > 0) {
//			model.addAttribute("dto", service.editView(bno));
//			return "board/edit";
//		}
//		else {
//			rttr.addFlashAttribute("result", result);
//			rttr.addAttribute("bno",dto.getBno());
//			return "redirect:/board/detail.do";
//		}
		model.addAttribute("dto", service.editView(bno));
	    return "board/edit";
		
	}
	//http://localhost:8080/spring003_mvc/board/edit.do
	
	// 4-2. 글 수정 기능
	@RequestMapping( value = "/board/edit.do", method = RequestMethod.POST)
	public String edit_post(BoardDto dto, RedirectAttributes rttr,
							@RequestParam("file") MultipartFile file,
							Model model) throws IllegalStateException, IOException {
		String result = "비밀번호 확인";
		if(file.getOriginalFilename() != "the703.png" && !file.isEmpty()) {
			String uploadPath = "C:/file/";
			File dest = new File(uploadPath + file.getOriginalFilename());
			file.transferTo(dest);
			dto.setBimg(file.getOriginalFilename());
		}
		if(service.edit(dto) > 0) {
			result = "글 수정 성공";
			rttr.addFlashAttribute("result",result);
			rttr.addAttribute("bno", dto.getBno());
			return "redirect:/board/edit.do?bno="+dto.getBno();
			}
		else {
			rttr.addFlashAttribute("result",result);
			rttr.addAttribute("bno", dto.getBno());
			return "redirect:/board/edit.do?bno="+dto.getBno();
		}
	}
	
	// 5. 글 삭제폼 경로
	@RequestMapping( value = "/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno, Model model) {
		model.addAttribute("dto", service.editView(bno));
		return "board/delete";
	}
	
	@RequestMapping( value = "/board/delete.do", method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
		String result = "글 삭제 실패";
		if(service.delete(dto) > 0) {
			result = "글 삭제 성공";
			rttr.addFlashAttribute("result",result);
			return "redirect:/board/list.do";
		}
		else {
			rttr.addFlashAttribute("result",result);
			rttr.addAttribute("bno", dto.getBno());
			return "redirect:/board/delete.do?bno="+dto.getBno();
		}
	}
	//http://localhost:8080/spring003_mvc/board/delete.do
	
}
