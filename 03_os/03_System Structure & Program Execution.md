# 03_System Structure & Program Execution



> CPU가 운영체제에 의해 실행될 때는 다 실행이 가능하다. CPU가 사용자 프로그램 A에 의해 실행될 때는 CPU를 독점하지 못한다.



## 1. Mode Bit

사용자 프로그램의 잘못된 수행으로 다른 프로그램 및 운영체제에 피해가 가지 않도록 하기 위한 **보호장치**



### 1) 분류

- 1 사용자 모드 : 사용자 프로그램 수행
- 0 모니터모드 : OS코드 수행(운영체제가 CPU 사용) 
  - 보안을 해칠 수 있는 중요한 명령어는 모니터모드에서만 가능



### 2) 작동방식

> > interrupt나 exception or trap 발생시 하드웨어가 mode bit을 0으로. 
> >
> > 사용자 프로그램에게 CPU넘기기 전 mode bit 1





## 2. Timer



timer interrupt! CPU 제어권이 OS에게로 넘어가는 것이다.



* timer 하드웨어: 운영체제가 사용자 프로그램에게 일정한 시간만 주고 일정한 시간이 흐른후 interrupt를 걸어 OS로 CPU사용권을 넘긴다.



## 3. I/O device



> CPU가 모든 I/O 장치에게 명령을 하달하는 기계어는 `특권명령`이다.



사용자 프로그램이 직접 I/O장치를 작동시킬 수 없고 OS에게 부탁해야한다. 이때, OS에게 부탁하는 것을 `시스템 콜`이라고 한다.



## 4. System Call[시스템콜]

사용자 프로그램이 운영체제의 서비스를 받기 위해 커널함수를 호출하는 것. 사용자 프로그램이 Interrupt를 거는 것이다.

예)  사용자 프로그램이 I/O장치를 쓰기 위해 CPU 요청(interrupt)



## 5. Interrupt



인터럽트를 당한 시점에 레지스터와 프로그램 counter을 save한 후, CPU제어를 인터럽트 처리 루틴에 넘긴다.



**register**: 하나의 프로그램이 끝나면 다음 프로그램이 실행되도록 하는 일종의 화살표 같은 것



### 1) 넓은 의미:

- interrupt [하드웨어 인터럽트] 
  - 예) timer, I/O장치 등
- Trap [소프트웨어 인터럽트]
  - exception : 프로그램이 오류를 일으키는 경우
    - 예) 본인이 할 수 없는 명령을 실행하려고 한 경우
  - system call : 프로그램이 커널함수 호출



> > > `device driver vs firm-ware`
> > >
> > > 1) device driver: device controller가 실행하는 것이 아니라 CPU가 실행하는 것
> > >
> > > 2) firm-ware: device controller가 실행하는 것 



## 7. 동기식 입출력과 비동시기 입출력

--> 두 경우 모두 I/O의 완료는 `interrupt`로 알려줌



### 1) 동기식 입출력(synchronous I/O)

- I/O 요청 후 입출력 작업이 완료된 후에야 제어가 사용자 프로그램에 넘어감
  - 구현방법 1: I/O가 끝날떄 까지 CPU낭비, 매 시점 하나의 I/O
- 예) 읽기



### 2) 비동기식 입출력(asynchronous I/O)

- 결과가 나오든 아니든 I/O 요청한 프로그램의 다른일을 하고 있는 것 
- 예) I/O 작업과 무관한 것 또는 쓰는 작업



## 8. DMA(Direct Memory Access)

```
빠르게 동작하는 I/O가 있으면 CPU에 너무 자주 interrupt가 걸리는 문제가 있다. interrupt도 일종의 overhead!

```

>  기존에는 메모리를 CPU만 건들수 있는 CPU작업장이었지만 DMA가 생기면서 DMA가 I/O 장치에서 작업한 결과를 메모리에 copy 할 수 있게 되었다.



### 1) 목적 

- interrupt가 너무 자주 걸리는 것을 막기 위해 DMA가 메모리에 copy 해줌



### 2) 특징

- 빠른 입출력 장치를 `메모리`에 가까운 속도로 처리하기 위해 사용
- CPU의 중재 없이 device controller가 device의 `buffer storage`의 내용을 메모리에 **block**단위로 직접 전송(DMA를 통해)
- 바이트 단위가 아니라 `block`단위로 전송
- DMA가 메모리에 block 단위로 올리고 `interrupt`



## 9. 서로 다른 기계어



- I/O를 수행하는 special instruction에 의해 
  - I/O를 수행하는 기계어 따로
  - CPU메모리를 수행하는 기계어 따로

- memory mapped I/O에 의해
  - 메모리에 접근하는 기계어로 I/O 까지 작동
  - 메모리 주소가 I/O장치 까지 연장해서 매겨짐.









