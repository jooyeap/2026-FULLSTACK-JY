package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		return "board/list";
	}
	//http://localhost:8080/spring003_mvc/list.do
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	//http://localhost:8080/spring003_mvc/write.do
	
	@RequestMapping("/edit.do")
	public String edit(Model model) {
		return "board/edit";
	}
	//http://localhost:8080/spring003_mvc/edit.do
	
	@RequestMapping("/detail.do")
	public String detail(Model model) {
		return "board/detail";
	}
	//http://localhost:8080/spring003_mvc/detail.do
	
	@RequestMapping("/delete.do")
	public String delete(Model model) {
		return "board/delete";
	}
	//http://localhost:8080/spring003_mvc/delete.do
	
}
