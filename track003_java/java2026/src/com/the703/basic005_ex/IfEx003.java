package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		
	/*연습문제3)
	패키지명 : com.the703.basic005_ex
	클래스명 :  IfEx003
	출력내용 : 숫자한개를 입력받아 
	만약 1을 입력했다면   one ,   
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.*/
		
		// 변수
		int num = 0;
		Scanner sc = new Scanner(System.in);
		// 입력
		System.out.println("숫자 입력");
		num = sc.nextInt();
		
		// 처리 및 출력
		
		// if(만약 1을 입력했다면) {one}
		if( num == 1 ) { System.out.println("one"); }
		
		// else if(만약 2를 입력했다면) {two}
		else if( num == 2 ) { System.out.println("two"); }
		
		// else if(3을 입력했다면) {three}
		else if( num == 3 ) { System.out.println("three"); }
		
		// else {1,2,3이 아님}
		else { System.out.println("1,2,3이 아니다."); }
		
		
		System.out.println( num == 1 ? "one" :
						  ( num == 2 ? "two" :
						  ( num == 3 ? "three" : "1,2,3이 아니다")));
		
	} 

}
