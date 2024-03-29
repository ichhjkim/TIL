# Thread Local

## 동시성 문제

여러 스레드가 동시에 같은 인스턴스의 필드값을 변경하면서 발생하는 문제를 동시성문제라고 한다.
동시성 문제는 여러 스레드가 같은 인스턴스에 접근해야하기 때문에 트래픽이 적은 상황에서는 확률상 잘 나타나지 않지만,
트래픽이 많아질 수록 발생 확률이 높아진다.

특히 스프링 빈처럼 싱글톤 객체의 필드를 변경하여 사용할때는 이러한 동시성 문제를 조심해야한다.

### 참고
이러한 동시성 문제는 지역변수에서는 발생하지 않는다.
지역변수는 스레드마다 각각 다른 메모리 영역에 할당된다. 
동시성 문제가 나타나는 곳은 같은 인스턴스 필드(주로 싱글톤), 또는 static 같은 공용 필드에 접근할때 발생한다.
동시성문제는 읽기를 할때는 발생하지 않는다. 값을 변경할 때 주로 나타난다.

## TreadLocal이란?
해당 쓰레드만 접근할 수 있는 특별한 저장소이다. 
여러 쓰레드가 같은 인스턴스의 필드에 접근하면 처음 보관한 데이터는 사라질 수도 있다.
(동시성 문제 발생)
<br>

ThreadLocal을 사용하면 각 쓰레드마다 별도의 저장소를 제공해준다.
예를 들어, 데이터를 저장할 떄 TreadLocal을 이용하면 
`thread A`의 쓰레드 저장소|
`thread B`의 쓰레드 저장소를 각각 쓰레드별로 구분해서 저장한다.

자바는 언어차원에서 쓰레드로컬을 지원하기 위해 `java.lang.ThreadLocal`클래스는 제공한다.

## ThreadLocal 사용법

- 값 저장: ThreadLocal.set();
- 값 조회: ThreadLocal.get();
- 값 제거: ThreadLocal.remove();
<br>

###  ThreadLocal 사용 주의법
해당 쓰레드가 쓰레드로컬을 모두 사용하고 나면, 'ThreadLocal.remove()'을 호출해서 쓰레드 로컬에 저장된 값을 제거해주어야 한다.
쓰레드 로컬 값을 사용한 후 제거하지 않고 그냥두면 WAS(톰켓)처럼 ThreadPool을 사용하는 경우
심각한 문제를 초래할 수 있다.

WAS는 사용이 끝난 Thread를 제거 하지 않고, ThreadPool에 반환한다. 쓰레드를 생성하는 비용은 비싸기 때문이다.
보통 쓰레드 풀을 이용해서, 쓰레드를 재사용한다. 이때 쓰레드 로컬에 있는 데이터를 삭제하지 않으면,
이전 요청에서 사용하던 데이터가 쓰레드 로컬에 계속 남아있게 된다.
그러므로, 다음 요청에서 이전 요청에서 사용했던 데이터를 볼 수 있다는 치명적인 문제가 발생핼 수 있다.


