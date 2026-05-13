package com.the703.basic018;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

////////////////////////////////////////////////////
// 듣기 - InputStream
class Receiver extends Thread{
	DataInputStream in;
	Socket socket;
	public Receiver(Socket socket) { 
		this.socket = socket;
		try { in = new DataInputStream( socket.getInputStream());
		} catch (IOException e) { e.printStackTrace(); }
	}
	public Receiver() { super(); }
	@Override public void run() { 
		try { while(in != null) {System.out.println(in.readUTF());}
		} catch (Exception e) { System.out.println("연결 끊김");
		} finally {
			try {
			if(in != null) {in.close();}
			if(socket != null) {socket.close();}
			} catch (Exception e) {e.printStackTrace();}
		}
	}
}

////////////////////////////////////////////////////
// 말하기 - OutputStream
class Sender extends Thread{
	DataOutputStream out;
	Socket socket;
	SimpleDateFormat format;
	String who;
	
	public Sender(Socket socket) {
		this.socket = socket; // 상대방과 연결되어 있는 정보
		try { out = new DataOutputStream( socket.getOutputStream());
		} catch (Exception e) {e.printStackTrace();}
		
		// 입력한사람이 누구인가?
		this.who = "[ " + ( socket.getPort() == 703 ? "Client" : "Server");
		// 현재 시각 | hh > 12시간 기준(am/pm) HH > 24시간 기준
		this.format = new SimpleDateFormat(" HH:mm:ss ] ");
	}
	public Sender() { super(); }
	@Override public void run() { 
		// 키보드로 써서 말하기
		BufferedReader br = 
		new BufferedReader(new InputStreamReader(System.in));

		try { while(out != null) {
			String time = format.format(System.currentTimeMillis());
			out.writeUTF(this.who + time + br.readLine());
		}
		} catch(Exception e) { System.out.println("연결 끊김");
		} finally {
			try {
				if(out != null) { out.close();}
				if(br != null) { br.close();}
				if(!socket.isClosed()) {socket.close();}
			} catch(Exception e) {e.printStackTrace();}
		}
	}
}

public class Chat001_Server {
	public static void main(String[] args) {
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//		long time = System.currentTimeMillis();
//		System.out.println(format.format(time));
		
		// 1. 서버소켓, 포트바인딩
		ServerSocket ascenter = null;
		Socket info = null;
		
		try {
			// 703 포트를 사용중이면 오류남
			ascenter = new ServerSocket(703); // 127.0.0.1:703 [ | | | | | ]
			System.out.println("[Server] 1. 서버준비완료 A/S 센터 OPEN");
		} catch (IOException e) { e.printStackTrace(); }
		try {
		System.out.println("[Server] 2. 고객 기다리는중");
		info = ascenter.accept();
		// 연결이 들어오면 소켓으로 연결
		System.out.println("[Server] 4. 고객님 연락와서 상담사(socket)랑 연결");
		
		Thread sender = new Sender(info);
		sender.start();
		Thread receiver = new Receiver(info);
		receiver.start();
		
		} catch (Exception e) { e.printStackTrace(); }
	}
}

/*

	1. Http 통신 - 단방향 (client의 요청이 있을때, server가 응답하고 연결 종료)
	2. Socket 통신 - 양방향 (특정 포트를 통해서 실시간으로 정보를 주고받음 - tcp/udp)
	3. 소켓통신의 흐름
		1) 서버소켓( a/s 센터 ) , 포트 바인딩 ( 문열기 )
		2) 클라이언트가 연결을 요쳥하면, 수락
		3) 클라이언트의 소켓(socket) <-> 상담사(socket)가 읽어 들이기
		   ㄴ InputStream > 프로그램기준 > OutputStream

*/