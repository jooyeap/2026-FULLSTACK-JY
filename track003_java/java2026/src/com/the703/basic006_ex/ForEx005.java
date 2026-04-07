package com.the703.basic006_ex;

public class ForEx005 {

	public static void main(String[] args) {
//	연습문제5)  
//	패키지명 : com.company.java005_ex
//	클래스명 :  ForEx005
//	출력내용 :   for 이용
//	소문자 a~z까지 모음의 갯수를 출력하시오.
		
		
		// 1 5 9 15 21
		char ch = 'a';
		int count = 0;
//		System.out.println(ch);
//		ch++;
//		System.out.println(ch);
		
		for(int i = 1; i <= 26; i++,ch++) {
			System.out.print(i != 1 && i != 5 && i != 9 && i != 15 && i != 21 ?
							 ch+"는 모음\n": ch+"는 자음<\n");
			
			if(i == 1 || i == 5 || i == 9 || i == 15 || i == 21) { count++;}
		}
		System.out.println("모음 개수는 " + count + "개");
	}
}
