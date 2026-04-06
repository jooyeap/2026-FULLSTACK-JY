package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		
	/*연습문제2)
	패키지명 : com.the703.basic005_ex
	클래스명 :  IfEx002
	출력내용 : 숫자 한개를 입력받아 
	양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.*/
		
		// 변수 - 숫자 한개 입력받기
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		// 입력 - 입력받기
		System.out.println("숫자 입력");
		num = sc.nextInt();
		
		// if(양수라면) {양수}
//		if( num > 0 ) {
//			System.out.println(" 양수 ");
//		}
		
		// else if(0 이라면) {zero} 
//		else if( num == 0) {
//			System.out.println(" zero ");
//		}
		
		// else if(음수라면) {음수}
//		else if( num < 0 ) {
//			System.out.println(" 음수 ");
//		}
		
		// 출력                 조건   ?  참   : 거짓(  조건   ?   참   :  거짓)
		System.out.println( num > 0 ? "양수" : ( num == 0 ? "zero" : "음수" ));
		
	}

}
