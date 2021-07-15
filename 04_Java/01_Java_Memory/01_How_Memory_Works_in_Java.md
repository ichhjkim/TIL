# 01 How Memory Works in JAVA

## STACK vs HEAP

### 01) Stack

java application은 여러 stack을 가진다

- Features
* every Thread has its own stack
* 효율적인 데이터 구조
* JVM에 의해 관리됨
* 자바는 언제 STACK이 destoryed될지 정확히 알고 있다.
* 함수를 호출할때, 자바는 스택에서 Local variables를 pull 한다.
* Local variables are stored on the stack

ex. int, double ..

**참고 closing bracket에 도달하면, 쓰레드가 종료된다.

### 02) Heap
longer lifetime data에 적합

every object is stored in heap
ex. string, Integer, Array

-Features
* objects are stored on the heap
* Variables are a reference to the object

