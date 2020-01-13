package abstractClass02;

public class MainClass {
	public static void main(String[] args) {
		Bank myBank = new MyBank("¹ÚÂùÈ£", "123-345-2342", 10);
		
		myBank.deposit();
		myBank.withdraw();
		myBank.installmentSavings();
		myBank.cancellation();
		
		System.out.println();
		myBank.getInfo();
	}
}
