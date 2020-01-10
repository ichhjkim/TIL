package testpjt;

import java.util.Scanner;

public class condition {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1은 num2보다 작다");
			
		}
		if (num1 > num2 ) {
			System.out.println("num2는 num1보다 작지 않다");
		} else if (num1 == num2){
			System.out.println("num2는 num1보다 최소 같거나 작다");
		}
		
		// swithch
		System.out.println("점수를 입력하셈");
		
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		switch (score) {
		case 90: 
			System.out.println("오오오오오");
			break;
		case 80:
			System.out.println("아깝");
			break;
		case 70:
			System.out.println("좀 더 노력");
			break;
		case 60: 
			System.out.println("과락 면함");
			break;
		default:
			System.out.println("과락이넴");
		}
		
	}
}
