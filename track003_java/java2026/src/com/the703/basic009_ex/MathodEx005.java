package com.the703.basic009_ex;

public class MathodEx005 {

//	public static void test(int num) {
//		if(num<1) {return;}				// 빠져나올 조건
//		System.out.print(num + "\n");	// 처리
//		test(--num);					// 자기 호출
//	}
	
	public static void hello(int i) {
		if(i<1) {return;}
		System.out.println("Hello"+i);
		hello(--i);
	}
	
	public static void main(String[] args) {
		//test(3);
		hello(5);

	}

}
