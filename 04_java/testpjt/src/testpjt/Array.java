package testpjt;

public class Array {
	public static void main(String[] args) {
		int[] arr1 = new int[5]; // 배열 선언 단계
		arr1[0] = 100;
		arr1[1] = arr1[0]*2;
		arr1[2] = arr1[2]*2;
		arr1[3] = 0;
		arr1[4] = -100;
		System.out.println(arr1[1]);
		int[] arr2 = {1, 2, 3, 4, 5};
		System.out.println(arr2[3]);
		
	}
}
