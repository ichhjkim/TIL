import java.util.Date;

public class UnderstandDI {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
	}
	public static void getDate(Date d) {
		Date date = d;
		System.out.println(date);
	}
	public static void memberUse1() {
		// 강한 결합: 직접 생성
		Member m1 = new Member();
	}
	public static void memberUse2(Member m) {
		// 약한 결함: 생성된 것을 주입받음 - 의존 관계(Dependency Injection)
		Member m2 = m;
	}
}

class Member {
	String name;
	String nickname;
	private Member() {
		// public -> private로 바꾸면 강한 결합은 에러가 남
		// 약한 결합이 더 안정적이게 함
	}
}
