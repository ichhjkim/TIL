## 02_CPU스케쥴링&메모리관리&디스크스케쥴링



## 1. CPU스케쥴링



### 1) FCFS(First-Come First-Served)

먼저 들어온 순서대로 실행

- 문제: 평균 대기시간이 길어짐



### 2) SJF(shortest-job-first)

금번 CPU 사용시간이 가장 짧은 프로세스를 제일 먼저 스케쥴

- 장점 : minimum average waiting time 보장
- 단점: 실행시간이 오래걸리는 프로세스는 영원히 실행 안될 수도



### 3) RR(RoundRobin) -- 오늘날의 컴퓨터

각 프로세스는 동일 크기의 할당시간을 가짐

- 장점 : 어떤 프로세스도  (n-1)*할당시간 이상 기다리지 않음. 대기시간이 프로세스의 CPU사용시간에 비례



## 2. 메모리관리

![메모리관리에 대한 이미지 검색결과](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F996BA63F5BD167E4200A2B)

좌측 : 휘발성

우측 : 비휘발성





## 3. 메모리관리

ram의 메모리가 다 찼다면 미래에 사용될 것인가 말것인가를 기준으로 메모리에 올라가 있는 프로세스를 빼거나 남겨두어야 한다. 그 기준에는 LRU, LFU가 있다.



### 1) LRU

가장 오래전에 사용된 페이지를 삭제

### 2) LFU

참조 횟수가 가장 적은 페이지를 삭제



## 4. 디스크 스케쥴링(디스크 헤드 이동시간을 줄이는 것이 핵심)



- 디스크 접근시간(Access Time)의 구성

  - 탐색시간(Seek Time): 헤드를 해당 트랙으로 움직이는 시간[가장 오래 걸림]

  - 회전시간(Rotational Time): 헤드가 원하는 섹터에 도달하기 까지 시간

  - 전송시간(Transfer Time)

    

- 디스트 접근 방법

  - SSTF(Shortest SeekTIme First): Seek Time이 제일 가까운 애들 부터
    - 단점: Starvation 문제
  - FCFS(First-Come, First-Served)
  - SCAN(오늘날 씀): 그냥 자기 갈길가는 방식. 한쪽 끝에서 다른 쪽 끝으로 이동하며 가능 길목에 있는 모든 요청 처리



## 5. 저장장치 계층구조와 캐싱(Caching)

| primary       | register          |
| ------------- | ----------------- |
|               | **cache memory**  |
|               | **main Memory**   |
|               |                   |
| **secondary** | **magnetic Disk** |
|               | **optional Disk** |
|               | **magnetic Tape** |



### Primary vs Secondary

|             | primary | secondary |
| ----------- | ------- | --------- |
| Cpu직접접근 | o       | x         |
| 비쌈        | o       | x         |
| 휘발성      | o       |           |
| 속도        | 빠름    | 느림      |



**caching** : copying information into faster storage system



## 6. 플래시메모리

- 반도체 장비
- Nand형, NOR 형(임베디드 코드 저장용)



#### 1) 특징

* 비휘발성
* 전력소모 적음
* 물리적인 충격에 강
* 작은 크기, 가벼움
* 쓰기 횟수 제약





