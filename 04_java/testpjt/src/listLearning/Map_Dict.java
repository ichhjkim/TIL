package listLearning;

import java.util.HashMap;

public class Map_Dict {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(map);
		
		// 데이터 추가
		map.put(5, "hello");
		map.put(6, "java");
		map.put(7, "world");
		System.out.println("map: "+map);
		System.out.println("map.size():"+map.size());
		//데이터 교체
		map.put(6, "C");
		System.out.println(map);
		
		//데이터 추출
		String str = map.get(5);
		System.out.println("map.get(5):"+str);
		
		//데이터 제거
		map.remove(8);
		System.out.println(map);
		
		//특정 데이터 포함여부
		boolean b = map.containsKey(7);
		System.out.println(b);
		// 데이터 전체 제거
		map.clear();
		System.out.println(map);
	
	}
}
