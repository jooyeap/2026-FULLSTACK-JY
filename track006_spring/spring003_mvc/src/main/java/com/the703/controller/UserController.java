package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.the703.service.UserService;

@Controller
public class UserController {
	
	@Autowired UserService service;
	
	// 회원가입
	@RequestMapping("/users/join.do")
	public String join() {
		return "";
	}
	
	// 로그인 폼 (get)
	@RequestMapping( value = "/users/login.do", method = RequestMethod.GET)
	public String login() {
		return "";
	}
	
	// 로그인 처리 (post)
	@RequestMapping( value = "/users/login.do", method = RequestMethod.POST)
	public String login_post() {
		return "";
	}
	
	// 마이페이지
	@RequestMapping("/users/mypage.do")
	public String mypage() {
		return "";
	}
	
}
