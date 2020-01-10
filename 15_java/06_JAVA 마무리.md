# 06_JAVA 마무리



## 1. 예외처리



### 1-1: 예외란?

프로그램에 문제가 있는 것을 말하며, 예외로 인해 시스템 동작이 멈추는 것을 막는 것을 예외 처리라고 한다.

- Exception: 이거는 개발자가 대처할 수 있음
- Error : 개발자가 대처할 수 없음



#### Exception

- checked Exception: 예외처리를 반드시 해야하는 경우

  (네트워크, 파일시스템 등)

- Unchecked Exception: 개발자가 자발적으로 예외처리를 하는 것(데이터 오류)





## 1-2: Exception 클래스

Exception 클래스 하위 클래스로 NullPointerException,NumberFormatException 등이 있따.



- NullPointerException :객체를 가리키지 않고 있는 레퍼런스를 이용할 때
- ArrayIndexOUtOfBoundException: 배열에서 존재하지 않는 인덱스를 가리킬떄
- NumberFormatException : 숫자데이터에 문자데이터등을 넣었을 때



### 1-3: try-catch 

개발자가 예외 처리하기 가장 쉽고, 많이 사용되는 방법이다

```java
try {
	예외가 발생할 수 있는 코드
} catch(Exception e) {
	예외가 발생했을 떄 처리할 코드
        // Exception - 모든 Exception 전부
        // (NullPointerException e) 예외의 경우를 이걸로 한정
} finally {
    예외 발생 여부 상관없이 언제나 실행되어야 하는 경우
}
```



##### # 입출력

```java
Scanner sc1 = new Scanner(System.in);

i = scanner.nextInt(); // 사용자의 입력을 int로 받겠다
```



### 1-4: throws

예외 발생시 예외 처리를 직접하지 않고 호출한 곳으로 넘긴다.



```java
public void firstMethod() throws Exception {
	secondMethod();
}
public void secondMethod() throws Exception {
	thirdMethod();
}
public void thirdMethod() throws Exception {
	System.out.println("에러 발생시 나를 호출했던 곳으로 다시 던짐")
}
```



그래서 만약 firstMethod에 예외 처리 try-catch가 있으면 거기서 처리해줌!

```java
try {
	mainClass004.firstMethod();
} catch (Exception e) {
	System.out.println("에러 발생");
} // 얘가 처리해줄 것이다
```



## 2. 입력과 출력



### 2-1: 입/출력이란?

> 다른 곳의 데이터를 가져오는 것을 입력이라고 하고, 다른 곳으로 데이터를 내보내는 것을 출력이라고 한다.

* 데이터가 오고가는 길 : Stream
* 예외처리를 반드시 해주는 것이 좋음



### 2-2: 입/출력 기본 클래스

> 입출력에 사용되는 기본 클래스는 ibyte단위로 데이터를 전송하는 InputStream, OutputStream이 있다.



### 2-3: FileInputStream/ FileOutputStream

1byte단위로 데이터를 읽음

`read()`: 1byte씩 읽음

`read(byte[])`: []크기 만큼 읽음 -- 속도면에서 좀 더 나음



```java
import java.io.FileInputStream;
InputStream inputstream = null;
try {
	inputStream = new FileInputStream("경로\파일명.txt");
    int data = 0;
    byte[] bs = new byte[3];
	try {
        data = inputStream.read(bs); // byte 크기대로 읽음
    }
}
```



`write(byte[] b)`:전체 쓰기

```java
import java.io.FileOutputStream;
outputStream = new FileOutputStream("경로\파일명.txt");
data = outputStream.write(byte[] b);
```

-- ascii 코드로 나옴.... 구림

### 2-4: DataInputStream, DataOutputStream

> byte 단위의 입출력을 개선해서 문자열을 좀 더 편리하게 다룰 수 있다.

`DataInputStream datainputstream = new DataInputStream();`

`datainputstream.readUTF();`



## 3. 네트워킹

> 네트워크에 연결되어 있는 대상 사이에 데이터를 전송하는 방법

--->  예외 처리가 기본 Try-- catch의 생활화

### 3-1: 네트워크 데이터 입력 및 출력

> 네트워크 대상(객체) 사이에 입출력을 이용해서 데이터를 입력



### 3-2: 소켓(Socket)

> 네트워크상에서 데이터를 주고받기 위한 장치이다.

자바는 소켓을 클래스로 제공해줌



### 3-3: 소켓 클래스

> 서버는 클라이언트를 맞을 준비를 하고 있다가 클라이언트의 요청에 반응한다.



```java
import java.net.ServerSocket;
import java.net.Socket;

serverSocket = new ServerSocket(9000); // localhost:9000
System.out.println("클라이언트 맞을 준비 완료");
socket = serverSocket.accept();// 클라이언트 연결, socket을 반환해줌
```



결과창

```
클라이언트를 맞을 준비
클라이언트 연결
Socket[addr=/0:0:0:0:0:0:0:1,port=51919,localport=9000]
```



### 3-4: Client와 Server 소켓

> 서버에 SeverSocket을 준비하고 클라이언트에서 소켓을 이용해 접속한다.