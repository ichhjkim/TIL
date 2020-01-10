package Networking;

import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트를 맞을 준비");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결");
			System.out.println(socket);
		} catch (Exception e) {
			System.out.println("에러");
		} finally {
			try {
				if (socket != null) socket.close();
				if (serverSocket != null) serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
