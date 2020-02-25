# 05_Request Data

in post request



> how to get Data from web

## Servlet

```java
@RequestMapping("/test1")
public String test1(HttpServletRequest httpServletRequest, Model model) {
String id = httpServletRequest.getParameter("id");
String name = httpServletRequest.getParameter("name");
model.addAttribute("id", id);
model.addAttribute("name", name);
return "test1";
}
```

HttpServletRequest has information about request,

HttpServletResponse has information about response

`getparameter` method helps to pass over `id`, `name`

return "test1" => view'name



## RequestParam

```java
@RequestMapping("/test2")
	public String test2(@RequestParam("id") String id,
						@RequestParam("name") String name,
						Model model)
	{
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "test2";
	}
```

"id" and "name" is delivered by RequestParam.



## Object

```java
@RequestMapping("/test3")
public String test3(Member member, Model model) {
return "test3";
}

```



Member class

```java
package com.study.web;

// command 객체
public class Member {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
```



### Lombok

```java
import lombok.Data;

// command 객체
@Data // 이것만 해주면 getter/setter 필요없음+코딩의 양을 매우 줄일 수 있다.
public class Member {
	private String id;
	private String name;
	
}

```



first, install lombok in homepage.



in cmd

```cmd
java -jar lombok.jar
```

this command should be typed where lombok.jar located



#### advantages

- clear code

  - it contains getter/setter part
  - only need to type @Data annotation

  

## URI

it can be also used in GET request.

```java
@RequestMapping("/test4/{studentId}/{name}")
	public String getStudent(@PathVariable String studentId,
							@PathVariable String name,
							Model model)
	{
		model.addAttribute("studentId", studentId);
		model.addAttribute("name", name);
		return "test4";
	}
```

`@pathVariable` is annotation that is passed over data;





