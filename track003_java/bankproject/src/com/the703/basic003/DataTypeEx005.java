package com.the703.basic003;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		
		/*
		연습문제5)
	패키지명 : com.the703.basic003_ex
	클래스명 : DataTypeEx005
	출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
	   국어점수를 입력하시오.  _입력받기    100 
	   영어점수를 입력하시오.  _입력받기    100 
	   수학점수를 입력하시오.  _입력받기    99

	   총점 :  299
	   평균 :  99.67
	   */
		
		//변수
	    int ko = 0;
		int en = 0;
		int math = 0;
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("국어 점수를 입력하시오.\n>");
		ko = sc.nextInt();
		
		System.out.print("영어 점수를 입력하시오.\n>");
		en = sc.nextInt();
		
		System.out.print("수학 점수를 입력하시오.\n>");
		math = sc.nextInt();
		//처리
		
//		//출력
		System.out.println();
		
		int total = ko + en + math;
		float avg = total/3f;
//		int total = ko + en + math;
//		float avg = total;
		
		System.out.println();
		System.out.printf("총점 : %d \n평균 : %.2f", total , avg);
//		System.out.printf("총점 : %d \n평균 : %.2f", total , (avg/3));
		
		/*
		String avgs = String.format("%.2f", (avg/3));
		System.out.println("총점 : " + total + "\n평균 : " + avgs);
		*/
		
		

	}

}
