package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.AppUserDto;
import com.the703.security.CustomUserDetails;
import com.the703.service.AppUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired AppUserService service;
	
	/////////////////////////// 회원 가입 //////////////////////////////
	/////////////////////////// 회원 가입 //////////////////////////////
	
	@ResponseBody
	@GetMapping("/iddouble")
	public Map<String, Object> iddouble(@RequestParam("email") String email){
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("exists", service.selectEmail(email, "local") != null);
		
		return result;
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "users/join";
	}
	
	@PostMapping("/join")
	public String joinForm_post(AppUserDto dto, RedirectAttributes rttr,
								@RequestParam( value = "file", required = false) MultipartFile file) {

		try {
			int result = service.insert(file, dto);
			rttr.addFlashAttribute("successMessage", result > 0 ? "회원가입 성공" : "회원가입 실패");
			return "redirect:/users/login";
		} catch (Exception e) {
			rttr.addFlashAttribute("errorMessage", "회원가입 실패" + e.getMessage());
			return "redirect:/users/join";
		}
		
	}
	
	/////////////////////////// 회원 가입 //////////////////////////////
	/////////////////////////// 회원 가입 //////////////////////////////
	
	/////////////////////////// 로그인 //////////////////////////////
	/////////////////////////// 로그인 //////////////////////////////
	
	@GetMapping("/login")
	public String loginForm() {
		return "users/login";
	}
	
	/////////////////////////// 로그인 //////////////////////////////
	/////////////////////////// 로그인 //////////////////////////////

	/////////////////////////// 마이페이지 //////////////////////////////
	/////////////////////////// 마이페이지 //////////////////////////////
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public String mypageForm(Authentication authentication, Model model) {
		
		String email = null;
		String provider = null;
		Object principal = authentication.getPrincipal();
		
		// 1. local
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails)principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
		}
		// 2. social
		
		model.addAttribute("dto", service.selectEmail(email, provider));
		
		return "users/mypage";
	}
	
	/////////////////////////// 마이페이지 //////////////////////////////
	/////////////////////////// 마이페이지 //////////////////////////////
	
	/////////////////////////// 회원 수정 //////////////////////////////
	/////////////////////////// 회원 수정 //////////////////////////////
	
	@GetMapping("/update")
	public String updateForm(Authentication authentication, Model model) {
		
		String email = null;
		String provider = null;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails)principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
		}
		
		model.addAttribute("dto", service.selectEmail(email, provider));
		
		return "users/update";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update")
	public String updateForm_post(@RequestParam(value="file", required=false) MultipartFile file,
								  AppUserDto dto, RedirectAttributes rttr) {
		
		int result = service.update(file, dto);
		rttr.addFlashAttribute("successMessage", result > 0 ? "수정 성공" : "수정 실패");
		
		return "redirect:/users/mypage";
	}
	
	/////////////////////////// 회원 수정 //////////////////////////////
	/////////////////////////// 회원 수정 //////////////////////////////
	
	/////////////////////////// 회원 삭제 //////////////////////////////
	/////////////////////////// 회원 삭제 //////////////////////////////
	
	@GetMapping("/delete")
	public String deleteForm(Authentication authentication, Model model) {
		
		String email = null;
		String provider = null;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails)principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
		}
		
		model.addAttribute("dto", service.selectEmail(email, provider));
		
		return "users/delete";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/delete")
	public String deleteForm_post(AppUserDto dto, RedirectAttributes rttr,
								  Authentication authentication,
								  HttpServletRequest request,
								  HttpServletResponse response) {
		
		// 사용자 정보 - appUserId / email / provider (local : local , social : kakao, naver)
		String email = null;
		String provider = null;
		int appUserId = -1;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users = (CustomUserDetails)principal;
			email = users.getUser().getEmail();
			provider = users.getUser().getProvider();
			appUserId = users.getUser().getAppUserId();
		}
		
		// 비밀번호 틀렸는지 확인 (local 용도)
		if(!service.matchesPassword(email, provider, dto.getPassword())) {
			rttr.addFlashAttribute("errorMessage", "사용자 정보 확인");
			return "redirect:/users/delete";
		}
		
		// 탈퇴 -  유저 정보 삭제
		dto.setEmail(email);
		dto.setAppUserId(appUserId);
		dto.setProvider(provider);
		int result = service.delete(dto, true); // local : true
		if(result > 0) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			rttr.addFlashAttribute("successMessage", "탈퇴 완료");
			return "redirect:/users/login";
		}	
		else {
			rttr.addFlashAttribute("errorMessage", "탈퇴 실패");
			return "redirect:/users/delete";
		}
	}
	
	/////////////////////////// 회원 삭제 //////////////////////////////
	/////////////////////////// 회원 삭제 //////////////////////////////
	
	@GetMapping("/fail")
	public String fail(Model model) {
		model.addAttribute("errorMessage", "로그인 실패 : 아이디 또는 비밀번호를 확인해주세요.");
		return "users/delete";
	}
	
}
