# 02_Values and References

## Passing By Value

For Objects passed into methods, the REFERENCE to the object is passed BY VALUE

## The final Keyword

if final keyword is assigned, can't assign another value;
make it completely unchangable!
-> compile error

단,
```
final Customer c = new Customer("John");
````
의 의미는 c가 new Customer의 reference를 기억한다는 것. 
customer name의 데이터가 변하는 것까지 final이 막을 수는 없다.
