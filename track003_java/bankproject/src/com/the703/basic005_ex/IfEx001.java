package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx001 {

	public static void main(String[] args) {
		
	/*연습문제1)
	패키지명 : com.the703.basic005_ex
	클래스명 :  IfEx001
	출력내용 : 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.*/
		
		int a , b , c = 0;
		double total = 0;
		String result = "불합격";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 자료 입력 >");
		a = sc.nextInt();
		
		System.out.println("두번째 자료 입력 >");
		b = sc.nextInt();
		
		System.out.println("세번째 자료 입력 >");
		c = sc.nextInt();
		
		total = (a+b+c)/3f;
		
		System.out.println("평균값 >" + total);
		
//		if(total >= 60) {
//			System.out.println("합격");
//		}
//		
//		else {
//			System.out.println("불합격");
//		}
		
//		if( total >= 60 ) { result = "합격";}
//		System.out.println(result);
		
		// 삼항연산자 조건 ? 참 : 거짓
		System.out.println(total >= 60 ? "합격" : "불합격");
		
		
	} 

}
