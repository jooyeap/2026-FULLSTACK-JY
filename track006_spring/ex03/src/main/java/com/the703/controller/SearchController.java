package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.the703.service.UserService;

@Controller
public class SearchController {

	@Autowired UserService service;
	
	// 회원가입 이메일 체크
	@ResponseBody // 화면을 리턴하는게 아니라 데이터만 리턴함
	@RequestMapping(value = "/doubleEmail", method = RequestMethod.GET)
	public Map<String,Object> doubleEmail(@RequestParam("email") String email) {
		Map<String, Object> result = new HashMap<>();
		
		// db에서 이메일 존재 여부 확인
		String find = service.findByEmail(email);
		
		if(find != null) { result.put("exists", true); }
		else { result.put("exists", false); }
		
		return result;
	}
}
