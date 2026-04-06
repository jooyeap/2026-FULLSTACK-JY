package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		
		
	/*연습문제8)  
	패키지명 : com.the703.basic005_ex
	클래스명 :  IfEx007
	출력내용 :  성적처리 프로그램입니다.

	1. 총점 구하기
	2. 평균 구하기
	3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
	4. 평균이 95점이상이면 장학생
	5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

	학번 입력 > std111
	국어점수 입력 > 100
	수학점수 입력 > 100
	영어점수 입력 > 99
	============================================= 
	학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
	============================================= 
	std111   100   100   99   299   99.67   합격   수   장학생*/
		
		int kor = 0;
		int math = 0;
		int eng = 0;
		int total = 0;
		double avg = 0;
		String pass = "불합격";
		String name = "";
		String level = "";
		
//		String result = "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨";
//		String result_bottom = "%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학번 입력 > ");
		name = sc.next();
		
		System.out.print("국어 점수 입력 > ");
		kor = sc.nextInt();
				
		System.out.print("영어 점수 입력 > ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수 입력 > ");
		math = sc.nextInt();
		
		// 1. 총점 구하기
		total = kor + math + eng;
		// 2. 평균 구하기
		avg = (kor + math + eng)/3f;
		
		
		// 3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		
		pass = avg < 60 ? "불합격" : (kor < 40 || eng < 40 || math < 40 ? "불합격" : "합격");
		
//		if(avg >= 60 && kor >= 40 && eng >= 40 && math >= 40) {
//			pass = "합격";
//		} // 합격 여부
		
				
//		pass = avg >= 60 ?
//			  (kor >= 40 ?
//			  (eng >= 40 ?
//			  (math >= 40 ? "합격" : "불합격"): "불합격"): "불합격") : "불합격";
//		
		// 5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		
//		if	   (avg >= 90)	{ level = "수"; }
//		else if(avg >= 80)  { level = "우"; }
//		else if(avg >= 70)  { level = "미"; }
//		else if(avg >= 60)  { level = "양"; }
//		else 			  	{ level = "가"; }

		level =  avg >= 90 ? "수" : 
				 avg >= 80 ? "우" : 
			 	 avg >= 70 ? "미" :
				 avg >= 60 ? "양" : "가" ;
		
//		if(avg >= 95) {
//			result += "\t 장학생";
//			result_bottom += "\t 장학생";
//		} // 장학생 여부
		
		// 4. 평균이 95점이상이면 장학생
		System.out.printf("=====================================================================\n"
						 + "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
						 +"=====================================================================\n"
						 + "%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s" 
						 , name, kor, eng, math, total, avg, pass, level
						 + (avg >= 95 ? "\t장학생\n" : "\n"));
		


	}

}
