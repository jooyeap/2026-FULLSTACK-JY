package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {

		/*
		연습문제4)
	패키지명 : com.the703.basic003_ex
	클래스명 : DataTypeEx004
	출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
	     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
	     파이값은 **입니다.
	    */
	    
		//변수
		double fi = 0;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("파이값을 입력하시오.\n>");
		fi = sc.nextDouble();
		//처리 x
		//출력
		System.out.println("파이값은 " + fi + "입니다.");
		System.out.print("파이값은 " + fi + "입니다.\n");
//		System.out.printf("파이값은 %f 입니다.\n" , fi); 소숫점 표시 안해주면 오류남
		System.out.printf("파이값은 %.0f입니다.\n" , fi); 
		System.out.printf("파이값은 %.1f입니다.\n" , fi);
		System.out.printf("파이값은 %.2f입니다.\n" , fi);
		System.out.printf("파이값은 %.4f입니다.\n" , fi);
		System.out.printf("파이값은 %.6f입니다.\n" , fi);

		System.out.println(10/3);	// 정수/정수 = 정수
		System.out.println(10/3f);	// 정수/실수 = 실수
		System.out.println(10f/3);	// 실수/정수 = 실수
	}

}
