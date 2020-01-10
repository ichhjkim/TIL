package inheritance01;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("자식 클래스 생성됨");

	}
	public void childFun() {
		System.out.println("자식 Fun");
	}
	@Override
	public void makeFood() {
		System.out.println("더 맛있는 짜장");
	}
}
