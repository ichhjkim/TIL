# 04_Model



`import org.springframework.ui.Model;`



## Controller



### method 1

```java
@RequestMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("name", "John");
		System.out.println(model);
		return "test1";  // `test1` is view page's name
	}
	
```

when `/test1` is called, **'boot template' String** is saved in **Model** Object.

so, in web page, `boot template` be printed by 'name' key

in this method, we can set only data.

### method 2



```java
@RequestMapping("/mv")
	public ModelAndView test2(Model model) {
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		mv.addObject("lists", list); //  
		mv.addObject("ObjectTest", "test입니다");
		mv.addObject("name", "John");
		mv.setViewName("view/myView"); // setting view's name
		return mv;  // return value should be ModelAndView's Object
		
	}
```

in this method, we can set both data and view.

- first, create ModelAndView Object

- second, 

  - set data

    method: `model.addAttribute("variable'name", "variables'data value")`

  --> insert data name, value

  ​	then, spring boot show the data in view page

  - set viewPage

    method: `mv.setViewName("view/myView")`; // setting view's name

    return ModelAndView's Object

  

  finally,

  in view, we can take the data's value by using `${data's name}`



## JSP

if you want to use Controller's data, you have to declare the

```jsp
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```

first. 



```jsp
<c:forEach var="mylist" items="${lists}">
	${mylist}<br>
</c:forEach>
```

