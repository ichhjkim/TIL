# 03_JAVA기초 문법



## 1. 변수란?

> 메모리에 데이터를 저장해서 재활용하는 방법을 학습



### 1-1: 변수 구조

1) 선언부 - 자료형/변수 이름

2) 대입연산자(=)

3) 초기화



### 1-2: 메모리 할당과 진법

- int 자료형은 메모리에서 4byte 공간을 차지 == 32bit

- 10진수 10 => 2진수 1010으로 메모리에 들어가게 됨기본



## 2. 기본 자료형



### 2-1: 기본 자료형과 객체자료형

- `기본자료형` : 데이터가 변수에 직접 저장됨
  - 정수 
    - byte : 메모리 1byte(==8bit: -127 ~ 127)
    - char[문자; 문자는 아스키코드로 변환되어 인지]: 2byte(==16bit;)  --> 문자 하나 예) "A"
    - short: 2byte
    - int : 4byte(==32bit) ! int를 주로 씀
    - long: 8byte(==64bit)
  - 실수
    - float: 4byte(==32bit)
    - double : 8byte(==64bit) !더블을 주로 씀
  - 불리언(boolean) : 1byte(==8bit)

- `객체자료형`: 객체 메모리 주소가 변수에 저장된다[c에서는 포인터라고 하고, java에서는 레퍼런스라고 한다]
  - 문자열 
    - String : 다른 자료형과는 다르게 `객체자료형`
      - String str = "ABCDE"
      - 그래서 String은 첫글자가 대문자



### 2-2: 형변환

// 자동(묵시적) 형변환: 작은 공간의 메모리에서 큰 공간의 메모리로 이동
```java
byte = by = 10;
int in = by;
System.out.println("in =" + in);
```
// 명시적 형변환: 큰 공간의 메모리에서 작은 공간의 메모리로 이동

``` java
int iVar = 100;
byte bVar = byte(iVar);
System.out.printlin("bVar = "+ bVar);
```

명시적 형 변환은 데이터가 누실될 수 있다.



## 3. 특수문자와 서식문자



### 3-1: 특수문자

일반문자가 아닌 특수한 목적으로 사용되는 문자



`\t`: 탭

`\n`:줄바꿈

`\'`:작은 따옴표

`\"`: 큰 따옴표

`\\`: 역슬래쉬



`//`: 주석(JS)랑 동일

`/*` 여러 줄 주석



### 3-2: 서식문자



printf() 메서드 : f는 format을 뜻함



| %d   | 10진수 |
| ---- | ------ |
| %o   | 8진수  |
| %x   | 16진수 |
| %c   | 문자   |
| %s   | 문자열 |
| %f   | 실수   |
|      |        |



### 3-3: 서식문자의 정렬과 소수점 제한 기능

- 오른쪽 정렬

`System.out.printf("%5d\n", 123);`



- 소수점 제한 기능

`System.out.printf("%0f\n", 1.23)` => 1

`System.out.printf("%1f\n", 1.23)` => 1.2

`System.out.printf("%2f\n", 1.23)` => 1.23

`System.out.printf("%3f\n", 1.23)` => 1.230



## 4. 연산



### 4-1: 피연산자 개수에 의한 연산자 구분



- 단항연산자 : 피연산자가 하나 존재
  - 예) +5, -5, !x
- 이항연산자 : 피연산자가 2개 존재
  - 예) `x = 10;` , `x<y;`, `x!=y`
- 삼항연산자: 피 연산자가 3개 존재
  - 예) 조건식 true ? false



### 4-2: 대입연산자

오른쪽의 결과를 왼쪽에 대입(할당)한다



### 4-3: 산술연산자

+, -, *, /, %



### 4-4: 복합대입연산자

`+=`, `-=`, `/=`, `%=`. `*=`



### 4-5: 관계 연산자

`<`, `>`, `>=`, `<=`, `==`, `!=`

--> true, false 반환



### 4-6: 증감연산자

++/ --  : 1만큼 증가/감소

++x: 일단 더하고 시작

x++: 실행하고 더함, 실행되기 전에는 그 값 그대로

예를 들어_ x= 10 이고,  print(x++) 이면 10이 출력되고 현재 x 값은 11





### 4-7: 논리 연산자

피연산자의 논리곱(AND), 논리합(OR), 논리부정(NOT)을 수행한다.

- && : 논리곱, a && b에서 a and b 모두 참이면 참

- || : 논리합 a or b

- ! : 논리 부정, !a



### 4-8: 조건(삼항연산자)

`조건식 ? 식 1 : 식2 `

조건식이 참이면 식1이 실행되고, 거짓이면 식 2가 실행된다



### 4-9: 비트연산자

데이터를 비트단위로 환산하여 연산을 수행하며, 다른 연산자보다 연산속도가 빠르다



& : AND 연산, a와 b 모두 `1`이면 1

| : OR 연산, a 와 b 중 하나라도 `1`이면 1

^ : XOR 연산, a와 b와 `같지 않으면` 1



## 5. 배열



### 5-1: 배열이란?

> 인덱스를 이용해서 자료형이 같은 데이터를 관리하는 것이다.



#### 배열선언

```java
int[] arr1 = new int[5]; // 배열 선언 단계
int[] arr2 = {1, 2, 3, 4, 5};
```



자바는 배열의 크기를 늘렸다 줄였다 할 수 없다.





##### input 받는 법

`Scanner scanner = new Scanner(System.in);`

`Scanner.nextInt();` // 사용자로부터 받은 입력값에 해당한다.

그래서 arr1[0] = Scanner.nextInt(); 이런식으로 저장할 수 있따.



## 6. 배열과 메모리



### 6-1: 배열의 메모리 크기

배열을 구성하는 데이터의 자료형에 따라서 배열의 메모리크기가 결정된다. 

int형 4byte -> 배열의 크기가 3이면 4*3 == 12byte



### 6-2: 배열의 가리키는 배열 이름

기본 자료형 데이터를 담고 있는 변수와 달리 배열 변수는 배열 데이터의 주소를 담고 있다.

```java
int[] i = new int[3];

// i에는 배열 첫번째 인덱스의 메모리 주소가 담겨있다
```



### 6-3: 배열 기본 속성



1) 배열의 길이 : `.length`

2) 배열의 요소 출력 : `System.out.println(Arrays.toString(arr1));`

3) 배열의 요소 복사

`arr3 = Arrays.copyOf(arr1, arr1.length);`

4) 배열의 레퍼런스

`arr2 = arr1;`

 // 배열 arr1의 주소를 가지고 있어서 arr1을 가리키고 있는것!



### 6-4: 다차원 배열



배열 안에 또 다른 배열 존재

```java
int[][] arr5 = new int[3][2];
// 3행 2열로 만든다
arr5[0][0] = 10;
arr5[1][1] = 100;
arr5[0][1] = 20;
```



shallow copy와 deepcopy는 나중에 상속을 배우고 나면...



## 7. 조건문

- 양자택일: 주로 if문이 쓰임

- 다자 택일 : 주로 switch가 쓰임

  

 ### 7-2: if문

```java
if (num1 < num2) {
	System.out.println("num1은 num2보다 작다");
}
```



### 7-3: switch문

비교 대상이 되는 결과값과 선택사항이 많을 수록 주로 사용한다.









```java
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1은 num2보다 작다");
			
		}
		if (num1 > num2 ) {
			System.out.println("num2는 num1보다 작지 않다");
		} else if (num1 == num2){
			System.out.println("num2는 num1보다 최소 같거나 작다");
		}
		
		// swithch
		System.out.println("점수를 입력하셈");
		
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		switch (score) {
		case 90: 
			System.out.println("오오오오오");
			break;
		case 80:
			System.out.println("아깝");
			break;
		case 70:
			System.out.println("좀 더 노력");
			break;
		case 60: 
			System.out.println("과락 면함");
			break;
		default:
			System.out.println("과락이넴");
		}
```



## 8. 반복문



### 8-1: 반복문이란?



> 프로그램의 진행을 특정 조건에 따라 반복적으로 진행하는 것이다.

for/while: 조건이 참일때 까지 반복 수행



### 8-2: for문

 for (int i = 1; i <10; i++)

for(int i =1l i <10; i += 2)



### 8-3: while문

```java
while(i < 10) {

	i++;

}
```



### 8-4: do while문

조건 결과에 상관없이 최초 한번은 실행함

즉, 최소 한번은 실행한다는 특징을 가짐

```JAVA
do {
	System.out.println("무조건 1번은 실행")
} while(false);

// 조건식이 false면 더 실행안함. true면 조건식에 맞추어 실행
```

