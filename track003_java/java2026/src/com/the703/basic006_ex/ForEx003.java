package com.the703.basic006_ex;

public class ForEx003 {

	public static void main(String[] args) {
		
//		연습문제3)  
//	패키지명 : com.company.java005_ex
//	클래스명 :  ForEx003
//	출력내용 :   for 이용
//	1~10까지의 합을 구하시오.
//
//	upgrade)  시간나면 도전!
//	1+2+3+4+5+6+7+8+9+10=55

		int result = 0;
		
		for(int i = 1; i <= 10 ; i++) {
			result += i;
			if(i == 10) {System.out.print(i); continue;}
			System.out.print(i + "+");
		}
		
		System.out.print("=" + result);
		
		result = 0;
		System.out.println();
		
		for(int i = 1; i <= 10 ; i++) {
			result += i;
			System.out.print((i == 1 ? "" : "+") + i);
		}
		
		System.out.print("=" + result);
	}

}
