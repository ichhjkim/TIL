package inheritance01;

public class MainClass {
	public static void main(String[] args) {
		ChildClass child1 = new ChildClass();
		
		child1.childFun();
		child1.parentFun();
		child1.makeFood();
		
		ParentClass parent = new ParentClass();
		parent.makeFood();
	}
}
