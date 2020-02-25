# 03_JSP(java server page)



## 01_ library

in build.gradle

```spring
compile('org.apache.tomcat.embed:tomcat-embed-jasper')
compile('javax.servlet:jstl:1.2')
```

in application.properties

```spring
#JSP setting
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```





## advantages

- good security
- develop based on component
- use various APIs in java



