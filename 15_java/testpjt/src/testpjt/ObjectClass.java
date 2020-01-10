package testpjt;

public class ObjectClass {
	public int x;
	public int y;
	public ObjectClass(String s, int[] iArr) {
		System.out.println("s ---> "+s);
		System.out.println("iArr"+ iArr);
	}
	
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
}
