package abstractClass02;

public abstract class Bank {
	String name;
	String account;
	int totalAmount;
	public Bank(String name, String account, int totalAmount) {
		this.name =name;
		this.account = account;
		this.totalAmount = totalAmount;
		// TODO Auto-generated constructor stub
	}
	public void deposit() {
		System.out.println("예금");
	}
	public void withdraw() {
		System.out.println("출금");
	}
	public abstract void installmentSavings();
	
	public abstract void cancellation();
	
	public void getInfo() {
		System.out.println("name==="+name);
		System.out.printf("account: %s", account);
		System.out.printf("totalamount: %d", totalAmount);
	}
		
	
}
