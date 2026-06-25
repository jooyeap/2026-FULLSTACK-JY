package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;



@Controller
@RequestMapping("/board") 	// 공통 prefix
public class Sboard2Controller {

	@Autowired private Sboard2Service service;
	
	// 1. 전체 리스트
	@GetMapping("/list") 	// /board + /list = /board/list
	public String list(@RequestParam( value = "paging", defaultValue = "1") int pageNo, Model model) {
		
		model.addAttribute("paging", new UtilPaging(service.selectCnt(), pageNo) );
		model.addAttribute("list", service.list10(pageNo));
		
		System.out.println(">>>> 페이징 : " + new UtilPaging(service.selectCnt(), pageNo));
		System.out.println(">>>> 리스트 : " + service.list10(pageNo));
		
		return "board/list";	// prefix(/templates) + board/list + suffix(.html)
	}
	
	// 2. 글쓰기 폼
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	// 3. 글쓰기 기능
	@PostMapping("/write")
	public String write_post(MultipartFile file, Sboard2Dto dto
							,RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		
		if(service.insert(dto, file) > 0) {
			result = "글쓰기 성공";
		}
		rttr.addFlashAttribute("success", result);
		
		return "redirect:/board/list";
	}
	
	// 4. 상세보기
	@GetMapping("/detail")
	public String detail(Model model, Sboard2Dto dto) {
		
		model.addAttribute("dto", service.detail(dto));
		
		return "board/detail";
	}
	
	// 5. 수정 폼
	@GetMapping("/edit")
	public String edit(Model model, Sboard2Dto dto) {
		
		model.addAttribute("dto", service.updateForm(dto));
		return "board/edit";
	}
	
	// 6. 수정 기능
	@PostMapping("/edit")
	public String edit_post(Sboard2Dto dto, MultipartFile file,
							RedirectAttributes rttr,
							@RequestParam("bpass") String bpass) {
		String result = "글수정 실패";
		Sboard2Dto target = new Sboard2Dto();
		target = service.updateForm(dto);
		
		if(!target.getBpass().equals(bpass)) {
			result = "비밀번호 확인";
			rttr.addFlashAttribute("fail", result);
			return "redirect:/board/edit?id=" + dto.getId();
		}
		
		if(service.update(dto, file) > 0) {
			result = "글수정 성공";
			rttr.addFlashAttribute("success", result);
		}
		
		rttr.addAttribute("dto", service.updateForm(dto).getId());
		return "redirect:/board/detail?id=" + dto.getId();
	}
	
	// 7. 삭제 폼
	@GetMapping("/delete")
	public String delete(Sboard2Dto dto, Model model) {
		model.addAttribute("dto", service.updateForm(dto));
		return "board/delete";
	}
	
	// 8. 삭제 기능
	@PostMapping("/delete")
	public String delete_post(@RequestParam("bpass") String bpass,
							  Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "비밀번호 확인";
		Sboard2Dto target = new Sboard2Dto();
		target = service.updateForm(dto);
		if(target.getBpass().equals(bpass)) {
			result = "삭제 성공";
			service.delete(target);
			rttr.addFlashAttribute("success",result);
			return "redirect:/board/list";
		}
		rttr.addFlashAttribute("fail",result);
		return "redirect:/board/delete?id=" + target.getId();
	}
}
/*

	1. controller (서비스 빼고 연동)
	- view
	- 경로
	
	2. controller (서비스 연결)

 */
