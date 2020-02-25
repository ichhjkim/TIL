# 06_@ModelAttribute





## @ModelAttribute



role

- first, automatically create object passed over Parameter
  - condition: appointed Class by @ModelAttribute shoule be a Bean Class
- second, binding values from HTTP's data
- third, @ModelAttribute's object automatically is added to Models's object



it means Dto's object is delivered .jsp view



```java
@RequestMapping("/create")
	public String insert2(
			@ModelAttribute("dto") ContentDto contentDto,
			BindingResult result) {
		
		String page = "createDone";
		System.out.println(contentDto);
		
		ContentValidator validator = new ContentValidator();
		
		validator.validate(contentDto, result);
		
		if(result.hasErrors()) {
			page = "createPage";
		}
		return page;
	}
```

@ModelAttribute("dto") =>  we will use "dto" Literally in jsp



in jsp[creatDone, createPage]

```jsp
<form action="<%=conPath%>/create">
	author : <input type="text" name="writer" value="${dto.writer}"> <br>
	content: <input type="text" name="content" value="${dto.content}">
	<input type="submit" value="전송">
</form>
```

`name` is used in Controller to distinguish data in Spring boot Framework.



## Dto(Data Transfer Object)

Dto is a Object that is used in view and controller.

Dao is a Class that is used in Model's Entity Class

![img](https://k.kakaocdn.net/dn/bihUcb/btqu0TSrkJD/0Oz9cosxZY8fXlLcNfe3aK/img.png)



exp) ContentDto

```java
package com.study.web;

import lombok.Data;

@Data
public class ContentDto {
	private int id;
	private String writer;
	private String content;
}

```

