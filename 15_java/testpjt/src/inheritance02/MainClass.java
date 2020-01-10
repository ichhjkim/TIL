package inheritance02;

public class MainClass {
	public static void main(String[] args) {
		ParentClass fch = new FIrstChildClass(); // === FIrstChildClass fch = new FIrstChildClass();
		fch.makeJJajang();
		ParentClass sch = new SecondChildClass();
		sch.makeJJajang();
		// 이렇게 하면 상속 배열을 만드는데 좋음
		ParentClass[] pArr = new ParentClass[2]; // 배열 크기가 2라는 의미
		pArr[0] = fch;
		pArr[1] = sch;
		// 데이터 타입을 통일시킬 수 있기 떄문에 이렇게 배열을 만들기가 좋다!
	
	}
}
