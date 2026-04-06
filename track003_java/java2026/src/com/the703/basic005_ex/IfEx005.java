package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
		
	/*연습문제5)
	패키지명 : com.company.java004_ex
	클래스명 :  IfEx005
	출력내용 : 문자한개를 입력받아 
	대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
	※  a = 'A' + 32    */

		char ch = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 한개를 입력해주세요.");
		ch = sc.next().charAt(0);
		
		if( ch >= 'a' && ch <= 'z') {
			ch -= 32;
		}
		else if( ch >= 'A' && ch <= 'Z') {
			ch += 32;
		}
		
		System.out.println(ch);
		System.out.println( ch >= 'a' && ch <= 'z' ? ch -= 32 : ( ch >= 'A' && ch <= 'Z' ? ch += 32 : "") );
		
		
//		System.out.println((int)'a');
//		System.out.println((int)'z');
//		System.out.println((int)'A');
//		System.out.println((int)'Z');
		
	}

}
