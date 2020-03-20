## MOUNTING



- contructor: 생성자 함수, state 설정 선언

- props로 받은 값을 state에 동기화를 하고 싶을 때 

  -> update에서 할 수도 있음

- componentDidMount:컴포넌트가 나타난 시점에 뭔가를 하겠다

  - 이벤트 리스너라던가
  - 외부 라이브러리 연동
  - 컴포넌트에서 필요한 데이터 요청
  - DOM에 관련된 작업 : 스크롤 설정



## UPDATING

shoulComponentUpdate: 가상 돔에 그리는 것을 줄여줌.

![1584623643544](C:\Users\nillc\AppData\Roaming\Typora\typora-user-images\1584623643544.png)

getSnapshotBeforeUPdate: update되기 직전에 씀, 스크롤 위치를 파악하거나 할떄 쓰임





UNMOUNT 코드가 사라지면서 쓰임



https://codesandbox.io/s/xl313zyrkw