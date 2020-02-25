package com.study.web;

import lombok.Data;

// command 객체
@Data // 이것만 해주면 getter/setter 필요없음+코딩의 양을 매우 줄일 수 있다.
public class Member {
	private String id;
	private String name;
	
	
	
}
