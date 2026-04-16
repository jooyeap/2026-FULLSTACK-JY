package com.the703.basic009;

public class Mathod002 {
	// 1. 리턴값 메서드명(파라미터:재료★){}
	
	//				   hello("bububu");
	public static void hello(String name) { // String name = "bababa"
		System.out.println("hello~ " + name);
	}
	
	//				   icecream(1);
	public static void icecream(int num) {
		System.out.println("아이스크림 "+num+"개");
	}
	
	public static void info(String name, int score) {
		System.out.println(name + " 최종 " + score + "점");
	}
	
	////////////////////////////////////////////////
	public static void main(String[] arg) {
		hello("bababa");
		hello("bububu");
		
		icecream(1);
		icecream(3);
		
		info("ba",10);
		info("bu",9);
	}
	////////////////////////////////////////////////
}
