package com.study.web;

import javax.validation.Valid;

import org.springframework.http.ContentDisposition;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		// @ResponseBody == django -- httpresponse
		return "Validator (3)";
		
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
			BindingResult result) {
		// dto가 들어오면 @Valid가 항상 검증해줌--ContentDto 위에 있는 annotation을 바탕으로 검증해줌
		String page = "createDone";
		System.out.println(contentDto);
		
//		ContentValidator validator = new ContentValidator();
//		
//		validator.validate(contentDto, result);
//		
		if(result.hasErrors()) {
			page = "createPage";
			if (result.getFieldError("writer") != null) {
				System.out.println("1:"+result.getFieldError("writer").getDefaultMessage());
				// getDefaultMessage는 ContentDto에서 에러 발생시 message 입력값을 출력해줌
			}
			if (result.getFieldError("content") != null) {
				System.out.println("2:"+result.getFieldError("content").getDefaultMessage());
			}
		}
		return page;
	}
	// 스프링은 강한 결합을 꺼려하기 때문에 약한 결합을 시켜주는 것
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new ContentValidator());
//	}
}
