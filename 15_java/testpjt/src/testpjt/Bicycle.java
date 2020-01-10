package testpjt;

public class Bicycle {
	public String color;
	public int price;
	public Bicycle(String c, int p) {
		// TODO Auto-generated constructor stub
		System.out.println("자전거 생성자");
		color = c;
		price = p;
	}
	public void info() {
		System.out.println("---info---");
		System.out.println("color : " + color);
		System.out.println("price: "+ price);
	}
	
}
