package setterGetter;

public class Student {
	private String name;
	private int score;
	
	public Student(String n, int s) {
		this.score = s;
		this.name = n;
	}
	public void getInfo() {
		System.out.println("--getInfo()--");
		System.out.println(this.name);
		System.out.println(this.score);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
