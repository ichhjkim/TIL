# 05_JAVA상속 및 클래스




## 1. 상속

### 1-1: 상속이란

> 부모클래스를 상속 받은 자식 클래스는 부모 클래스의 속성과 기능을 이용할 수 있다



할아버지(집) --> 아버지(집+자동차) -> 아들(집+자동차+요트)



- parent Class(속성, 기능) -> childClass(속성, 기능)
- childClass의 속성과 기능 = parent Class의 속성과 기능 + childClass의 속성과 기능



### 1-2: 상속의 필요성

> 기존의 검증된 class를 이용해서 빠르고 쉽게 새로운 class를 만들수 있다.



### 1-3: 상속 구현
> `extends` 키워드를 이용해서 상속을 구현한다.

childClass를 생성을 하면 상위 Class의 부모Class 객체가 먼저 생성되어 메모리에 올라감

inheritance01.package 참조

- python과 다른점

	- java에서는 다중 상속을 지원하지 않고, 단일 상속만 지원한다.



### 1-4: 부모 클래스에서 private 접근자

> 아무리 자식 클래스 이더라도 부모클래스의 private 변수나 메서드는 자식 클래스에게 상속되지 않는다.



## 2. 상속 특징

상속관계에 있는 클래스의 특징들에 대해서 학습



### 2-1: 메서드 오버라이드(override)

> 부모클래스의 기능을 자식 클래스에서 재정의해서 사용한다.



이때 자식 클래스에서 오버라이드된 메서드를 부모클래스에서 호출하면 원래 부모클래스에서 정의했던 메서드가 호출됨



### 2-2: 자료형(타입)

> 기본 자료형처럼 클래스도 자료형이다.
>
> inheritance02 package 참조

```java
package inheritance02;

public class MainClass {
	public static void main(String[] args) {
		ParentClass fch = new FIrstChildClass(); // === FIrstChildClass fch = new FIrstChildClass();
		fch.makeJJajang();
		ParentClass sch = new SecondChildClass();
		sch.makeJJajang();
		// 이렇게 하면 상속 배열을 만드는데 좋음
		ParentClass[] pArr = new ParentClass[2]; // 배열 크기가 2라는 의미
		pArr[0] = fch;
		pArr[1] = sch;
		// 데이터 타입을 통일시킬 수 있기 떄문에 이렇게 배열을 만들기가 좋다!
	
	}
}
```



- Object 클래스 : 모든 클래스의 최상위 클래스는 Object 클래스이다.
  - `java.lang`이라는 package



### 2-3: super 클래스

> 상위 클래스를 호출할떄 `super` 키워드를 이용한다.

** 현재 내가 있는 객체를 가르킬떄 this라고 함



예시) ParentClass

```java
ParentClass
int openYear = 1995;
public void makeJJajang() {
	System.out.println("짜장면을 만들자");
}
```

 

예시) ChildClass

```java
ChildClass
int openYear = 2000;
public void getOpenYear() {
	System.out.println(this.openYear);
	System.out.println(super.openYear); // 부모클래스의 변수를 호출할때 super 사용
}
```



## 3. 내부클래스와 익명클래스

내부클래스는 클래스 내에 또 클래스가 존재하는 것



### 3-1: 내부클래스(innerClass)

> 클래스 안에 또 다른 클래스를 선언하는 것

- 장점 ㅣ 두 클래스의 멤버에 쉽게 접근할 수 있다
- 단점 | 하지만 현재는 실무에서 쓰이지 않음. 로직이 복잡해지고 데이터가 커지면 서로 꼬일 가능성이 커짐



#### `static` Class는 외부에서 접근할 수 없다



### 3-2: 익명(anonymous) 클래스

> 이름이 없는 클래스로 주로 메서드를 재정의하는 목적



- 언제 사용? 익명클래스는 **인터페이스**나 **추상클래스**에서 주로 이용된다.

```java
new AnnonymousClass() {

    @Override
    public void method() {
        System.out.println("[[[[익명 클래스 override]]]]")
    }
}.method(); // --> 내가 필요한 메서드를 바로 실행.  
```

단, 한번쓰고 버리는 애여서 이름이 없기 떄문에 다시 불러서 쓸수는 없다. 그래서 내가 정의한 메서드를 바로 실행해야함



## 4. 인터페이스

`interface00.package 참조`

### 4-1: 인터페이스란?

클래스와 달리 객체를 생성할 수는 없으며, 클래스에서 구현해야하는 작업명세서이다.



class에서 interface를 구현하는 단계[interface의 선언만 되어 있는 기능을 클래스가 상세화] -> 클래스가 객체를 생성



### 4-2: 인터페이스를 사용하는 이유

객체가 다양한 자료형(타입)을 가질 수 있기 때문이다.

 `implements`를 통해 불러옴. 상속은 `extends`

```java
public class interfaceClass implements interfaceA, interfaceB {

}
```





### 4-3: 장난감 인터페이스

`interface01Toy.package` 참고





## 5. 추상클래스



### 5-1: 추상클래스

클래스의 공통된 부분을 뽑아서 별도의 클래스(추상클래스)로 만들어 놓고, 이것을 상속해서 사용



- 특징
  - 멤버변수를 가진다.
  - 추상클래스를 상속하기 위해서는 `extends`를 이용
  - 추상클래스는 추상메서드를 가지며, 상속한 클래스에서 반드시 구현해야함 // interface와 같음
  - 일반 메서드도 가질수 있다
  - 일반 클래스와 마찬가지로 생성자도 있따.



### 5-2: 추상클래스 구현

> 클래스 상속과 마찬가지로 extends 키워드를 이용해서 상속하고 abstract 메서드를 구현한다



- super 적용

자식 클래스

```java
public MyBank(String name, String account, int totalAmount) {
		super(name, account, totalAmount); // 상속하는 Class의 생성자 함수에서 적용
	}
```



적용되는 부모 클래스의 생성자 함수

```java
public Bank(String name, String account, int totalAmount) {
		this.name =name;
		this.account = account;
		this.totalAmount = totalAmount;
    // super의 name, account, toalAmount가 각각 함수의 인자(매개변수에 적용된다)
		// TODO Auto-generated constructor stub
	}
```



### 5-3: 인터페이스 vs 추상클래스



- 공통점 : 추상메서드를 가진다. 객체 생성이 불가하며 자료형(타입)으로 사용된다.
- 차이점
  - 인터페이스 
    - 상수, 추상메서드만 가진다
    - 추상메서드를 구현만 하도록 한다.
    - **다형성**을 지원한다.
  - 추상메서드
    - 클래스가 가지는 모든 속성과 기능을 가진다.
    - 추상메서드 구현 및 **상속**의 기능을 가진다.
    - **단일 상속**만 지원한다.



## 6. 람다



### 6-1: 람다식이란?

익명함수를 이용해서 익명 객체를 생성하기 위한 식이다.

interfaceType 변수 <- interface 수현



람다식 방식

> interfaceType 변수 <----할당(대입)--- Lambda Expressions 



#### 람다함수의 여러 모습

```java
package lambda_00;

public class MainClass {
	public static void main(String[] args) {
		LambdaInterface1 li1 = (String s1, String s2, String s3) -> {
			System.out.println("람다식");
		};
		li1.method("hello", "java", "world");
	// 인자가 1개이거나 타입이 같을 때, 타입을 생략할 수 있다
	LambdaInterface2 li2 = (s2) -> {
		System.out.printf("%s +++", s2);
	};
	li2.method("Hello");
	
	// 실행문이 1개 일때 {}를 생략할 수 있다
	LambdaInterface2 li3 = (s1) -> System.out.println(s1);
	
	// 매개변수와 실행문이 1개 일떄 ()와 {}를 생략할 수 있다
	LambdaInterface2 li4 = s1 -> System.out.println(s1);
	
	// 매개변수가 없을 때는 ()만 작석
	
	//LambdaInterface3 li5 = () -> System.out.println("노 함수인자");	
	
	//반환값이 있는 경우 -- 필요한 함수를 언제든지 내 마음대로 만들 수 있다
	LambdaInterface3 li6 = (x, y) -> {
		int result = x+y;
		return result;
	};
	System.out.printf("result: %d", li6.method(100, 1));
	
	}
}
```



#### 주의 할 점

```java

public interface LambdaInterface3 {
	public int method(int x, int y);
    // return 값이 있으면 미리 public과 method 사이에 리턴할 값의 타입을 적시해주어야 한다!!!
}

```



### 장점: 람다를 쓰면 코드가 유연해지고 개발자가 편리 . 협업시 조음



## 7. 문자열 클래스



### 7-1: String 객체와 메모리

문자열을 다루는 String 클래스는 데이터가 변하면 메모리상의 변화가 많아 속도가 느리다



> > 문자열이 변경되면 기존의 객체를 버리고 새로운 객체를 메모리에 생성한다. 이떄, 기존 객체는 GC에 의해서 메모리 회수가 이루어 진다.

기존의 문자열을 활용하는 것이 아니라 아예 메모리에 새로 할당함

그래서 느림. 기존 문자열과 변화된 문자열의 주소도 다름@


### 7-2: StringBuffer, StringBuilder

> string 클래스의 단점을 보완한 클래스로 데이터가 변경되면 메모리에서 기존 객체를 재활용한다.



```java
StringBuffer sf = new StringBuffer("JAVA");
sf.append("_8")
```

속도저하도 덜하고 기존과 메모리 주소도 같음



#### stringBuffer vs StringBuilder -- 둘이 사용하는 것은 동일

- StringBuffer 장점
  - 데이터 안정성이 조음: 메모리에 데이터가 들어가고 빠질떄 싱크로나이즈 기법을 씀.하나씩 하나씩 메모리를 받음. 데이터 누실,드랍, 훼손되는 경우가 거의 없음
- stringBuilder 장점: 속도가 더 빠름
  - 들어오는데로 받기 때문에 데이터 안정성이 조금 떨어짐. 
  - 이게 좀더 빠르기 때문에 요즘 좀 더 선호됨

```java
	public static void main(String[] args) {
		String str = "Java";
		System.out.println("str +"+ str);
		str = str + "_8";
		System.out.println(str);
		
		// StringBuffer
		StringBuffer sf = new StringBuffer("JAVA");
		System.out.println("sf +" + sf);
		sf.append("append");
		System.out.println(sf);
		// StringBuilder
		StringBuilder sb = new StringBuilder("JAVA builder");
		sb.append("sbappend");
		System.out.println(sb);
		// insert도 있어염
		sf.insert(sf.length(), "____");
		System.out.println(sf + "insert");
		// delete도 있어염
		sf.delete(4,  8); // index 4번 -7번까지 다 지운다
		System.out.println(sf+"delete");
	
```



## 8. collections



### 8-1: List

배열과 같이 자료형을 효율적으로 사용하는 방법에 대해 배워보자

> 리스트는 `인터페이스`로 이를 구현한 클래스는 인덱스를 이용해서 데이터를 관리한다.
> 

list - vector, arraylist, linkedlist

`import를 반드시 해주어야 함`

```java
import java.util.ArrayList;

// ArrayList 객체 생성
	// ArrayList<int>를 하면 안댐.. 왜징... 
ArrayList<String> list = new ArrayList<String>();

// 데이터 추가
list.add("hello");
list.add("java");
list.add("world");

list.add(2, "programming");
// list index 1번째를 C로 바꿔라
list.set(1, "C");

// 데이터 추출
String str = list.get(2); //index 2의 값을 저장

// 데이터 제거
str = list.remove(2) // index 2번 제거
    
// 데이터 전체 제거
    
    
    
list.clear();


// 데이터 유무

boolean b = list.isEmpty();
```



### 8-2: MAP

> map은 인터페이스로 이를 구현한 클래스는 key를 이용해 데이터 접근



- 특징
  - key를 이용한다
  - key는 중복될 수 없다
    - key의 중복은 불가능 하지만, 데이터 중복은 가능



```java
import java.util.HashMap;

public class Map_Dict {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(map);
		
		// 데이터 추가
		map.put(5, "hello");
		map.put(6, "java");
		map.put(7, "world");
		System.out.println("map: "+map);
		System.out.println("map.size():"+map.size());
		//데이터 교체
		map.put(6, "C");
		System.out.println(map);
		
		//데이터 추출
		String str = map.get(5);
		System.out.println("map.get(5):"+str);
		
		//데이터 제거
		map.remove(8);
		System.out.println(map);
		
		//특정 데이터 포함여부
		boolean b = map.containsKey(7);
		System.out.println(b);
		// 데이터 전체 제거
		map.clear();
		System.out.println(map);
	
```



