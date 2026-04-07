package com.the703.basic006_ex;

public class ForEx004 {

	public static void main(String[] args) {
		
//		연습문제4)  
//	패키지명 : com.company.java005_ex
//	클래스명 :  ForEx004
//	출력내용 :   for 이용
//	1~10까지 3의 배수 갯수를 출력   
//
//	upgrade)  시간나면 도전!
//	3의배수 : 3,6,9    
//	갯수 : 3개
		
		int count = 0;
		
		System.out.print("3의 배수 : ");
		
		for(int i = 3; i <= 10 ; i += 3) {
			count++;
			if(i == 9) {System.out.print(i); continue;}
			System.out.print(i + ",");
		}
		
		System.out.println("\n갯수 : " + count + "개");
		
		count = 0;
		System.out.println();
		
		System.out.print("3의 배수 : ");
		for(int i = 3; i <= 10 ; i += 3) {
			count++;
			System.out.print((i == 3 ? "" : ",") + i);
		}
		
		System.out.println("\n갯수 : " + count + "개");
	}

}
