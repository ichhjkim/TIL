# 04_JAVA 객체 



## 1. 객체지향프로그래밍이란



### 1-1: 객체란?

세상에 존재하는 모든 것을 뜻하며, 프로그래밍에서 `속성`과 `기능`을 가지는 프로그램 단위이다.



### 1-2: 클래스란?

> 객체를 생성하기 위한 틀로 모든 객체는 클래스로 부터 생성된다.



### 1-3: 클래스 구성요소

`속성(멤버변수)` + `기능(메서드)`



## 2. 클래스 제작과 객체 생성



### 2-1: 클래스 제작

> 클래스는 멤버변수(속성), 메서드(기능), 생성자 등으로 구성된다
>
> eclipse LearnCalss, Bicycle 참조

```java
package pjt001;
public class Grand {
    // 속성 -- 변수
    public String color;
    public String gear;
    public int price;
    // method의 이름이 클래스 이름과 동일한애 == 생성자
    // 얘에 의해서 메모리에 객체가 올라감. 반환형이 없음,
   
    public Grand () {
        System.out.println("grand");
        // 생성할때 필요한 내용인 애들은 이 안에 기술하면 됨
    }
    // method를 만들떄는 void --> 반환형
    // void는 반환값이 없다는 의미
    public void run () {
        System.out.println("run");
    }
    // method 반환 값이 있고 그 반환값의 자료형이 string일떄 String이라고 씀
    public String stop() {
        System.out.println("---stop----");
       	return "stop"
    }
}
```



### 2-2: 객체 생성&생성자

> 클래스로 부터 'new'를 이용해서 객체를 생성한다
>
> TestClass.java 참조



```java
Grand myCar1 = new Grand();
```

myCar1 객체가 있는 곳 주소를 myCar1이 가지고 있음(==참조하고 있다 ==레퍼런스가 있다)



## 3. 메서드



### 3-1: 메서드 선언과 호출

> 메서드도 변수와 같이 선언 및 정의 후 필요시에 호출해서 사용한다.

```java
public void getInfo() {
	System.out.println("메서즈")
}
```

public : 접근자

--> method를 어떻게 하면 허용할까 허용하지 않을까

void : 반환형

getInfo: 메서드 이름

(): 메개변수



### 3-2: MethodClass.java, MethodDo.java 참조



### 3-3: 중복 메서드(`overloading`)

> 이름은 같고, 매개변수의 개수 또는 타입이 다른 메서드를 만들 수 있따.
>
> 대신 이름이 같으면 반드시 타입이 달라야 한다.

```java
public void getInfo() {
	System.out.println("===genInfo---I--");
   
}
public void getInfo(int x, int y) {
    System.out.println("getInfo---2--");
   	System.out.printf("parameter -> x : %d, y: %d \n", x, y);
}
public void getInfo(String s1, String s2) {
    System.out.println("getInfo --- 3");
    System.out.printf("parameter -> x : %s, y: %s \n", s1, s2);
    
}
```



### 3-4: 접근자



지금까지 우리는 public만 접근자로 사용

private메서드도 있음. 어떤 객체에 private으로 설정되어 있는 거는 외부에서는 호출할 수 없다.



--> python 에서는 private이 없음. private이 좀더 보안에 좋음

python 에서는 private 대신 __methodname을 씀, 



## 4. 객체와 메모리



### 4-1: 메모리에서 객체 생성(동적생성)

객체는 메모리에서 `동적`으로 생성되며, 객체가 더이상 필요없게 되면 `GC(Gabage collector)`에 의해서 제거된다.



- 객체는 별도의 메모리 공간에서 존재하며
- class는 해당 객체의 메모리 공간의 주소를 저장(레퍼런스)하고 있다.



그러면, 필요없는 객체는 레퍼런스를 없앰. GC는 돌다가 레퍼런스 없는 객체는 제거해서 메모리를 효율적으로 관리한다.



`objectClass.java`참고



### 4-2: 객체를 같은 클래스여도 다들 다른 객체

```java
package testpjt;

public class ObjectClass {

}

```



```java
package testpjt;

public class ObjectMainClass {

	public static void main(String[] args) {
		ObjectClass obj1 = new ObjectClass();
		ObjectClass obj2 = new ObjectClass();
		ObjectClass obj3 = new ObjectClass();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		
	}
}
```



프린트 결과

testpjt.ObjectClass@15db9742
testpjt.ObjectClass@6d06d69c
testpjt.ObjectClass@7852e922

다들 @ 뒤에 다른 주소값을 가짐



### 4-3: null과 NULLPointException

> 레퍼런스에 null 저장되면 객체의 연결이 끊기며, 더이상 객체를 이용할 수 없다.



예

```java
ObjectClass obj1 = new ObjectClass();
obj1 = null; // 레퍼런스가 끊임
obj1.getInfo(); //레퍼런스가 끊긴 객체에서 method를 호출하면
// ExeptionError 발생!
```



## 5. 생성자와 소멸자 그리고 this 키워드



### 5-1: 디폴트 생성자

객체가 생성될때 가장 먼저 호출되는 생성자로, 만약 개발자가 명시하지 않아도 **컴파일 시점**에 ***자동 생성***된다. 



### 5-2: 사용자 정의 생성자

```java
package testpjt;

public class ObjectClass {
	public ObjectClass(String s, int[] iArr) {
		System.out.println("s ---> "+s);
		System.out.println("iArr"+ iArr);
	}
}

```



### 5-3: 소멸자

> 객체가 GC에 의해서 메모리에서 제거 될때 finalize() 메서드가 호출된다. 



`System.gc();` => GC를 실행시켜주세요. 이걸 사용한다고 해서 GC가 바로 작동하는 것이 아니라, 가급적 빨리 작동하도록 요청하는 것. java는 기본적으로 메모리를 개발자가 직접 관리하지 않으므로 일반적으로 system.gc()를 사용하는 경우는 드물다



### 5-4: this 키워드

```java
public ObjectClass(int x, int y) {
		//  x, y는 함수가 실행될때면 잠깐 실행되고 사라짐
		// public  x, public y는 계속 메모리에 올라가있음
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println("저장전");
		this.x = x; // this.x는 클래스 내 전역변수 x를 의미
		this.y = y;
	}
	public void getInfo() {
		System.out.println("x---> "+ x); // 여기서 x는 전역변수 public x임
		System.out.println("y ---> "+ y);
	}
```

클래스 내 전역변수



## 6. 패키지와 static

class 파일을 효율적으로 관리하기 위한 방법과 객체 간에 속성 또는 기능 공유하는 방법



### 6-1: 패키지(package)

java 프로그램은 많은 클래스로 구성되고, 이러한 클래스를 폴더 형식으로 관리하는 것을 패키지라고 한다.



1) 패키지 이름 결정 요령

- 패키지 이름은 패키지에 속해있는 클래스가 최대한 다른 클래스와 중복되는 것을 방지
- 패키지 이름은 일반적으로 도메인을 거꾸로 이용 -- 유니크한 이름을 나타내기 위해서
- 개발 중에 패키지의 이름과 구조는 변경될 수 있다.
- 패키지 이름만 보고도 해당 패키지 않에 있는 클래스가 어떤 속성과 기능을 가지고 있는지 예상이 될 수 있도록 이름을 만든다.

### 6-2: 클래스 이름 호출

- 동일한 패키지 내에서 클래스를 불러올때는 import가 필요 없지만, 동일한 패키지가 아닐떄는 `import 패키지이름.클래스이름;`을 써주어야 한다.

- 아니면 `import 패키지이름.*;`: 해당 패키지내 모든 클래스를 임포트 하겠다.

- 아니면 쓸때마다 패키지이름.클래스이름 풀로 쓰는 경우도...



### 6-3: static

클래스의 속성과 메서드에 static키워드를 사용하면 어디서나 속성과 메서드를 공유할 수 있다. 



```java
public class EmployBank {
	String name;
    static int amount = 0;
    
    public EmployBank(String name) {
        this.name = name;
    }
    public void saveMoney(int money) {
        amount += money;
        System.out.println("amount :" + amount);
    }
}
```

// **`static` int amount**는 모든 EmployBank 클래스의 객체가 공유하는 변수!



그래서 예를 들어

```java
EmployBank parkBank = new EmployBank("박찬호");
parkBank.saveMoney(100);
EmployBank leeBank = new EmployBank("이승엽");
leeBank.saveMoney(50);
```

하면 amount는 150이 찍힌다.



## 7. 데이터 은닉

객체가 가지고 있는 데이터를 외부로 부터 변질되지 않게 보호하는 방법



### 7-1: 멤버 변수의 private 설정

멤버 변수(속성)은 주로 private으로 설정해서, 외부로부터 데이터가 변질되는 것을 막는다.



- 데이터(속성) 변질이 우려되는 시나리오
  - 직원 급여 프로그램에서 급여담당자가 실수로 급여액을 잘못입력하는 경우
  - 변경될 수 없는 사번이 변경되는 경우



### 7-2: setter, getter

멤버 변수를 외부에서 변경할 수 있도록 하는 메서드

`package setterGetter참고`



```java
package setterGetter;

public class Student {
	private String name;
	private int score;
	
	public Student(String n, int s) {
		this.score = s;
		this.name = n;
	}
	public void getInfo() {
		System.out.println("--getInfo()--");
		System.out.println(this.name);
		System.out.println(this.score);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
```



```java
package setterGetter;

public class MainClass {
	public static void main(String[] args) {
		Student st1 = new Student("네오", 90);
		st1.getInfo();
		st1.setScore(100); // setScore메서드를 통해 데이터 조작
		st1.getInfo();
		st1.getName();
	}
}

```



getter, setter함수는

객체의 변수를 변경할떄, 데이터를 조작할떄 안정장치를 마련하기 용이하게 해줌