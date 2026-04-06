package com.the703.v1;

public class Basic003 {

	public static void main(String[] args) {
		//1. System.out.println(); 줄바꿈 o
		System.out.println("Hello");
		
		//2. System.out.print(); 줄바꿈 x
		System.out.print("A\t"); // \t > tap키 누른효과
		System.out.print("B\n"); // \n > 줄바꿈 효과
		System.out.print("a\t");
		System.out.print("b\n");
		
		//3. System.out.printf( "%s%d" , "문자열" , 10);
		// %d 정수 , %s 문자열 
		System.out.printf("%d 더하기 %d 은 %s",1,1,"ㅇㅅㅇ");
		System.out.printf("\n%s하면 %d원", "궁금하면",500);
		
		System.out.println();
		
		//4. +의 의미
		System.out.println(10+3);
		System.out.println(10+"3");
		System.out.println("10"+3);
		
		System.out.println();
		
		System.out.println("10+3=" + (10+3)); // 1. 오류없애기 2. 결과물 10+3=13
		
	}

}
