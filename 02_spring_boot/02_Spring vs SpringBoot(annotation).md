# 02_Spring vs SpringBoot(annotation)



## what is Annotation?

it is called as metaData. developing IT industry and growing program-code scale, XML's setting data scale also has grown. so, Meta-data that affect system by and large, should be departed from main code. 

ex) @Repository, @Service, @Controller, @Autowired, @Resource

It is a typical method, adding information to codes



## Advantage

- clean Code
- easy understand Valid condition
- Reusable



## Annotaions in Spring Boot



- @SpringBootApplication
  - @Configuration + @EnableAutoConfiguration + @ComponentScan
- @ComponentScan
  - Service, @compoent, @Repository, @Controller, @Configuration 이 붙은 Class Bean을 찾아서 Context에 bean 등록을 해주는 annotation
- @RestController
  - @Controller + ResponseBody



 - Bean DI annotation

    - @Autowired: used in setting fine DI. 
      	- ex_ property, setter method, constructor, method
   - @Resource
     - connecting resources
     - applied in property, setter method
   - @Qualifier
     - used with @Autowired annotation
     - if there are bean objects that are all same type, Qualifier find selected/specific Bean Object

   