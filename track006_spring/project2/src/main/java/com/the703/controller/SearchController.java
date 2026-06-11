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
	
	@ResponseBody
	@RequestMapping( value="/doubleEmail", method=RequestMethod.GET)
	public Map<String, Object> doubleEmail( @RequestParam("email") String email){
		Map<String, Object> result = new HashMap<>();
		
		String find = service.emailCheck(email);
		
		if(find != null) { result.put("exists", true); }
		else { result.put("exists", false);}
		
		return result;
	}
		
}
