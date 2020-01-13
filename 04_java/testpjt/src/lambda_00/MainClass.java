package lambda_00;

public class MainClass {
	public static void main(String[] args) {
		LambdaInterface1 li1 = (String s1, String s2, String s3) -> {
			System.out.println("람다식");
		};
		li1.method("hello", "java", "world");
	// 인자가 1개이거나 타입이 같을 때, 타입을 생략할 수 있다
	LambdaInterface2 li2 = (s2) -> {
		System.out.printf("%s +++", s2);
	};
	li2.method("Hello");
	
	// 실행문이 1개 일때 {}를 생략할 수 있다
	LambdaInterface2 li3 = (s1) -> System.out.println(s1);
	
	// 매개변수와 실행문이 1개 일떄 ()와 {}를 생략할 수 있다
	LambdaInterface2 li4 = s1 -> System.out.println(s1);
	
	// 매개변수가 없을 때는 ()만 작석
	
	//LambdaInterface3 li5 = () -> System.out.println("노 함수인자");	
	
	//반환값이 있는 경우 -- 필요한 함수를 언제든지 내 마음대로 만들 수 있다
	LambdaInterface3 li6 = (x, y) -> {
		int result = x+y;
		return result;
	};
	System.out.printf("result: %d", li6.method(100, 1));
	
	}
}
