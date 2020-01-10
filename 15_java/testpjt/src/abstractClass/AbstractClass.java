package abstractClass;

public abstract class AbstractClass {
	int num;	
	String str;
	public AbstractClass(int i, String s) {
		// TODO Auto-generated constructor stub
		System.out.println("추상 클래스 만들어짐");
		this.num = i;
		this.str = s;
	}
	public void fun1() {
		System.out.println("함수 1 시작");
	}
	public abstract void fun2();
}
