package inheritance01;

public class ParentClass {
 
	public ParentClass() {
		// TODO Auto-generated constructor stub
		System.out.println("부모 클래스 생성됨");
	}
	public void parentFun() {
		System.out.println("parentFun");
	}
	private void privateFun() {
		System.out.println("private 부모 메서드 접근");
	}
	public void makeFood() {
		System.out.println("make 짜장");
		
	}
}
