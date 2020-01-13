package interface00;

public class MainClass {
	public static void main(String[] args) {
		
		interfaceA fa = new interfaceClass();
		interfaceB fb = new interfaceClass();
		// fa는 interfaceA 에 속하기 때문에 funcA에만 접근할 수 있따
		fa.funA();
		fb.funB(); // fa에서 funB는 접근하지 못함
	}
}
