package testpjt;

public class methodClass {
	public String name;
	public String gender;
	public int age;
	
	public void setInfo(String n, String g, int a) {
		System.out.println("===setInfo Start===");
		name=n;
		gender=g;
		age = a;
	}
	public methodClass() {
		// TODO Auto-generated constructor stub
		System.out.println("»ý¼ºµÊ");
	}
	
	public void getInfo() {
		System.out.println("---getInfo()----");
		
		System.out.println("name: " + name);
		System.out.println("gener:" + gender);
		System.out.println("age: "+age);
	}
	private void mySecret() {
			System.out.println("---mySecrete---");
		}
	}
