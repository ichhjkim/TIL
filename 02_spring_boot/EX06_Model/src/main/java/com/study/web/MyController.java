package com.study.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
//	@RequestMapping("/")
//	public @ResponseBody String root() throws Exception{
//		return "JSP in GRADLE";
//	}
//	
//	@RequestMapping("/test1")
//	public String test1() {
//		return "test1"; // WEB-INF/test1
//	}
//	
//	@RequestMapping("/test2")
//	public String test2() {
//		return "sub/test2";
//	}
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Model & View";
	}
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		// Model 객체를 설정해서 view로 Data 전달
		// Data만 설정이 가능
		// String으로 해도 되는구나.. String이 이 모델 이름이라고 생각하면 되는건가
		model.addAttribute("name", "홍길동");
		System.out.println(model);
		return "test1"; 
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2(Model model) {
		// 강한결합코드
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "test입니다");
		mv.addObject("name", "홍길동");
		mv.setViewName("view/myView");
		
		return mv;
		
		
	}

}
