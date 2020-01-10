package listLearning;
import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) {
		// ArrayList<int>를 하면 안댐.. 왜징... 
		ArrayList<String> list = new ArrayList<String>();
		// 데이터 추가
		list.add("hello");
		list.add("java");
		list.add("world");
		System.out.println(list);
		list.add(2, "programming");
		// list index 1번째를 C로 바꿔라
		list.set(1, "C");
		System.out.println(list);
		// 데이터 추출
		String str = list.get(2); //index 2의 값을 저장

		// 데이터 제거
		str = list.remove(2); // index 2번 제거
		    
		// 데이터 전체 제거
		list.clear();


		// 데이터 유무

		boolean b = list.isEmpty();
	}
}
