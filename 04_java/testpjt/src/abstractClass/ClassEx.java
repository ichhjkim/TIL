package abstractClass;

public class ClassEx extends AbstractClass {
	
	public ClassEx(int i, String s) {
		super(i, s);
		System.out.println("classEx 시작");
		
	}

	@Override
	public void fun2() {
		// TODO Auto-generated method stub
		System.out.println("함수 2tlwkr");
		
	}
}
