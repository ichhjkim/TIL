package StringBuilder_Buffer;

public class MainClass {
	public static void main(String[] args) {
		String str = "Java";
		System.out.println("str +"+ str);
		str = str + "_8";
		System.out.println(str);
		
		// StringBuffer
		StringBuffer sf = new StringBuffer("JAVA");
		System.out.println("sf +" + sf);
		sf.append("append");
		System.out.println(sf);
		// StringBuilder
		StringBuilder sb = new StringBuilder("JAVA builder");
		sb.append("sbappend");
		System.out.println(sb);
		// insert도 있어염
		sf.insert(sf.length(), "____");
		System.out.println(sf + "insert");
		// delete도 있어염
		sf.delete(4,  8); // index 4번 -7번까지 다 지운다
		System.out.println(sf+"delete");
	}
}
