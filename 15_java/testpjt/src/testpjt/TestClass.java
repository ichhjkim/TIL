package testpjt;

public class TestClass {
	public static void main(String[] args) {
		LearnClass myCar1 = new LearnClass();
		myCar1.color = "red";
		myCar1.gear = "auto";
		myCar1.price = 300000;
		
		myCar1.run();
		myCar1.stop();
		
		System.out.println();
		
		LearnClass myCar2 = new LearnClass();
		myCar2.color = "blue";
		myCar2.gear = "manual";
		myCar2.price = 30000000;
		
		
	}
}
