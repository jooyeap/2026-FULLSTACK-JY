package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn002 {

	public static void main(String[] args) {
		
		int kor = -1;
		int eng = -1;
		int math = -1;
		int total = 0;
		double avg = 0;
		String jang = "";
		String pass = "";
		String level = "";
		String name = "";
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("이름 입력 > ");
		name = sc.next();
		
		for(int i = 0; i <= 2;) {
			
		if(i == 0) {	
			System.out.print("국어 점수 (0~100) 입력 > ");
			kor = sc.nextInt();
				if(kor > 100 || kor < 0 ) {
					System.out.println("0~100 사이값을 입력해주세요.\n");
					continue;
					}
				else {i++;}
				
				//System.out.println(i);
		}
		
		else if(i == 1) {
			System.out.print("영어 점수 (0~100) 입력 > ");
			eng = sc.nextInt();
				if(eng > 100 || eng < 0) {
					System.out.println("0~100 사이값을 입력해주세요.\n");
					continue;
				}
				else {i++;}
				//System.out.println(i);
		}
		
		else if(i == 2) {
		System.out.print("수학 점수 (0~100) 입력 > ");
			math = sc.nextInt();
				if(math > 100 || math < 0) {
					System.out.println("0~100 사이값을 입력해주세요.\n");
					continue;
				}
				else {i++;}
				//System.out.println(i);
			}
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