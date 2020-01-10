package PublicPrivate;

public class Bank {
	private String name; // public이므로 누구나 접근가능, 그래서 데이터 변질이 가능하다
	// 그래서 private으로 바꿔줌
	static int amount = 0;
	
	public Bank(String name) {
		this.name = name;
	}
	public void saveMoney(int money) {
		amount += money;
		System.out.println(amount);
	}
	public void spendMoney(int money) {
		amount -= money;
		System.out.println(amount);
		
	}
	public void getBankInfo() {
		System.out.println(this.name);
		System.out.println(amount);
	}
}
