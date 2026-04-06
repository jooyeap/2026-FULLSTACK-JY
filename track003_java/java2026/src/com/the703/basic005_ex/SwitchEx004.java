package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx004 {

	public static void main(String[] args) {
		
		
		char a = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력 > ");
		a = sc.next().charAt(0);
		
		switch(a) {
		case 'a': case 'a'-32: System.out.println("APPLE"); break;
		case 'b': case 'b'-32: System.out.println("BANANA"); break;
		case 'c': case 'c'-32: System.out.println("COCONUT"); break;
		}
		
		/*
		 연습문제4)  
	패키지명 : com.company.basic005_ex
	클래스명 :  SwitchEx004
	출력내용 :   switch 이용
	     문자한개 입력받아
	     a , A이면 APPLE
	     b , B이면 BANANA
	     c , C이면 COCONUT
	     */

	}

}
