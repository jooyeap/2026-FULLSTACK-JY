package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class CountDown extends Thread{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println((i+1));
			try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		}
		
	}
	
}

public class ThreadEx001 {
	public static void main(String[] args) {
		Thread cd = new CountDown(); cd.start();
		
		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하세요");
		System.out.println(answer.toLowerCase().equals("apple") ? "정답" : "오답");
		// toLowerCase() -> 다 소문자로 변환
		
//		if(answer.equals("apple")) { System.out.println("정답");}
//		else {System.out.println("오답"); }
	}
}
//연습문제1)  Thread
//패키지명 : com.the703.basic018
//클래스명 : ThreadEx001
//1.  QuestionCount  - 10부터 1까지 
//      카운트 1초에 10 ,
//                2초에 9, 
//                3초에  8.....
//
//2. 사과알파벳을 입력하세요.
//   사과를 입력을받으면 정답입니다 / 정답이 아닙니다.
