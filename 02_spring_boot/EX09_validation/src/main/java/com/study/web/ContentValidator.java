package com.study.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
// validator를 따로 만들면 협업시 좋음
public class ContentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDto.class.isAssignableFrom(arg0);
		// 검증할 객체의 클래스 타입 정보
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ContentDto dto = (ContentDto)obj;
		
		String sWriter = dto.getWriter();
		if (sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("writer is null");
			errors.rejectValue("writer", "empty");
			
		}
		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("content is null");
			errors.rejectValue("content", "null");
		}
	}

}
