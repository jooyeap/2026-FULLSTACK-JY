package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn002 {

	public static void main(String[] args) {
		
		/* 초기값은 항상 입력받을 범위 밖의 값을 지정 */
		int kor = -1;
		int eng = -1;
		int math = -1;
		int total = 0;
		double avg = 0;
		String jang = "";
		String pass = "";
		String level = "가";
		String name = "";
		Scanner sc = new Scanner(System.in);
		
		// 입력
		// 		문자열 : next() / 정수형(10) : nextInt() / 실수형(1.23) : nextDouble() / 문자 : next().charAt(0)
		
		//ver 1
//		System.out.print("이름 입력 > "); name = sc.next();
//		for(;;) {
//			System.out.print("국어점수 입력 > "); kor = sc.nextInt();
//			if(kor >= 0 && kor <=100) {break;}
//		}
//		for(;;) {
//			System.out.print("수학점수 입력 > "); math = sc.nextInt();
//			if(math >= 0 && math <=100) {break;}
//		}
//		for(;;) {
//			System.out.print("영어점수 입력 > "); eng = sc.nextInt();
//			if(eng >= 0 && eng <=100) {break;}
//		}
		
		//ver 2
//		System.out.print("이름 입력 > "); name = sc.next();
//		for(;!(kor >= 0 && kor <=100);) {  // 0~100 사이의 범위가 아니면 
//			System.out.print("국어점수 입력 > ");
//			kor = sc.nextInt();
//		}
//		for(;math < 0 || math > 100;) {
//			System.out.print("수학점수 입력 > ");
//			math = sc.nextInt();
//		}
//		for(;!(eng >= 0 && eng <=100);) {
//			System.out.print("영어점수 입력 > ");
//			eng = sc.nextInt();
//		}
		
		//ver 3
//		System.out.print("이름 입력 > "); name = sc.next();
//		for(;;) {
//			
//			if( !(kor >= 0 && kor <= 100)) {
//				System.out.println("국어점수 입력 > ");
//				kor = sc.nextInt();
//				continue;
//			}
//			if( math < 0 || math > 100) {
//				System.out.println("수학점수 입력 > ");
//				math = sc.nextInt();
//				continue;
//			}
//			if( !(eng >= 0 && eng <= 100)) {
//				System.out.println("영어점수 입력 > ");
//				eng = sc.nextInt();
//				continue;
//			}
//			break;
//		}
		
		//ver 4
		System.out.print("이름 입력 > "); name = sc.next();
		for(;;) {
			
			if( !(kor >= 0 && kor <= 100)) { // 해당범위가 아니면 진행하세요.
				System.out.println("국어점수 입력 > ");
				kor = sc.nextInt();
			}
			else if( math < 0 || math > 100) {
				System.out.println("수학점수 입력 > ");
				math = sc.nextInt();
			}
			else if( !(eng >= 0 && eng <= 100)) {
				System.out.println("영어점수 입력 > ");
				eng = sc.nextInt();
			}
			else {break;}
		}
		// 처리  - 연산자 먼저 () / 값(++,--,산술) / 비교(<,>) / 조건 (&& || ? :) / 대입 (=)
		// 	  	- 제어문 (if/ switch) 반복(for/ while/ do while)
		
		total = kor + eng + math;		// 1. 총점 구하기
		avg = total/3f;					// 2. 평균 구하기 (강제현변환) 정수/실수
		pass = avg < 60 ? "불합격" : (kor < 40 || eng < 40 || math < 40 ? "불합격" : "합격"); // 3. 조건대입해 합격여부
		if(avg >= 95 ) { jang ="장학생";} // 4. 평균이 95 이상이면 장학생
		switch((int)avg/10) {			// 5. 평균으로 등급 나누기
			case 10 : case 9 : level = "수"; break;
			case 8 : level = "우"; break;
			case 7 : level = "미"; break;
			case 6 : level = "양"; break;
		}
		
		
		System.out.printf("=====================================================================\n"
						 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
						 +"=====================================================================\n"
						 + "%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s" 
						 , name, kor, eng, math, total, avg, pass, level, jang);
				
		
	}

}