package testpjt;

public class methodDo {
	public static void main(String[] args) {
		methodClass child1 = new methodClass();
		child1.getInfo(); // 아무것도 지정하지 않았기 떄문에 name:null이 뜸
		child1.gender = "woman";
		child1.getInfo();
		child1.setInfo("hong", "m", 20);
		child1.getInfo();
		// child1.mySecret(); 실행 안됨. 외부에서 접근이 안됨
	}

}
