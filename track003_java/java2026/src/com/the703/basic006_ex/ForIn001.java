package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		
		int kor = 0;
		int eng = 0;
		int math = 0;
		int total = 0;
		double avg = 0;
		String jang = "";
		String pass = "";
		String level = "";
		String name = "";
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름 입력 > ");
		name = sc.next();
		
		for(;;) {
			
		System.out.println("국어 점수 (0~100) 입력 > ");
		kor = sc.nextInt();
//		if(kor > 100 || kor < 0 ) {
//			System.out.println("0~100 사이값을 입력해주세요.");}
		
		System.out.println("영어 점수 (0~100) 입력 > ");
		eng = sc.nextInt();
		
		System.out.println("수학 점수 (0~100) 입력 > ");
		math = sc.nextInt();
		
			if(kor > 100 || kor < 0 || eng > 100 || eng < 0 || math > 100 || math < 0 ) 
			{ System.out.println("0~100 사이값을 입력해주세요."); }
			else {break;}
		}
		
		total = kor + eng + math;
		avg = total/3f;
		jang = avg >= 95 ? "장학생" : " ";
		pass = avg < 60 ? "불합격" : (kor <= 40 || eng <= 40 || math <= 40 ? "불합격" : "합격");
		level = avg >= 90 ? "수" :
			   (avg >= 80 ? "우" :
			   (avg >= 70 ? "미" :
			   (avg >= 60 ? "양" : "가")));
		
		System.out.printf("=====================================================================\n"
						 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
						 +"=====================================================================\n"
						 + "%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s" 
						 , name, kor, eng, math, total, avg, pass, level, jang);
				
		
	}

}
/*	연습문제1)   
패키지명 : com.company.java004_ex
클래스명 :   ForIn001
출력내용 :  성적처리 프로그램입니다.

0. 국어,영어, 수학(0~100만입력받기)  
1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100  
수학점수 입력 > 100
영어점수 입력 > 99
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/
