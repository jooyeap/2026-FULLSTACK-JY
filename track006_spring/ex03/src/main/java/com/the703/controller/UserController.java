package com.the703.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;


@Controller
public class UserController {
	
	@Autowired UserService service;
	
	// 회원가입 폼
	@RequestMapping( value = "/users/join.do", method = RequestMethod.GET )
	public String join() {
		return "users/join";
	}
	
	// 회원가입 처리
	@RequestMapping( value = "/users/join.do", method = RequestMethod.POST )
	public String join_post(UserDto dto, RedirectAttributes rttr) throws UnknownHostException {
		String result = "회원가입 실패";
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		if(service.insert(dto) > 0) {
			result = "회원가입 성공";
			rttr.addFlashAttribute("result",result);
			return "redirect:/users/login.do";
		}
		rttr.addFlashAttribute("result",result);
		return "redirect:/users/join.do";
	}
	
	// 로그인 폼
	@RequestMapping( value = "/users/login.do", method = RequestMethod.GET)
	public String findLogin() {
		return "users/login";
	}
	
	// 로그인 처리
	@RequestMapping( value = "/users/login.do", method = RequestMethod.POST)
	public String findLogin_post(UserDto dto, Model model, RedirectAttributes rttr) {
		String result = "로그인 실패";
		if(service.findLogin(dto) > 0) {
			result = "로그인 성공";
			rttr.addFlashAttribute("result",result);
			rttr.addAttribute("uno",service.findUser(dto.getEmail()).getUno());
			return "redirect:/users/mypage.do";
		}
		rttr.addFlashAttribute("result",result);
		return "redirect:/users/login.do";
	}
	
	@RequestMapping("/users/mypage.do")
	public String mypage(int uno, Model model) {
		// 여기 dto 자체를 넘겨줘야함
		model.addAttribute("dto");
		return "users/mypage";
	}
}
