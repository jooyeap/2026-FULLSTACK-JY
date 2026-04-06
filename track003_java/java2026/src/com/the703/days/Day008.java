package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {

		int kor = 0;
		int eng = 0;
		int math = 0;
		int total = 0;
		double avg = 0;
		String pass = "";
		String level = "";
		String jang = "";
		String name = "";
		Scanner sc = new Scanner(System.in);
		
			
		System.out.print("학번 입력 >");
		name = sc.next();
		
		for(;;) {
			
		System.out.print("국어 점수 입력 >");
		kor = sc.nextInt();
		
		System.out.print("수학 점수 입력 >");
		math = sc.nextInt();
		
		System.out.print("영어 점수 입력 >");
		eng = sc.nextInt();
		
			if((kor > 100 || kor < 0 ) || (eng > 100 || eng < 0 ) || (math > 100 || math < 0)) {
				System.out.println("0에서 100 사이값을 입력해주세요.\n");
			}
			else { break;}
			
		}
		
		total = kor + math + eng;
		avg = total/3f;
		jang = avg >= 95 ? "장학생" : "";
		
		pass = avg < 60 ? "불합격" :(kor <= 40 || eng <= 40 || math <= 40 ? "불합격" : "합격") ;
		level = avg >= 90 ? "수" :
			   (avg >= 80 ? "우" :
			   (avg >= 70 ? "미" :
			   (avg >= 60 ? "양" : "가" )));
		
		System.out.printf("=================================================================\n"
						 +"학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
						 +"=================================================================\n"
						 +"%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s"
//						 +(avg >= 95 ? "장학생" : "\n")
						 ,name,kor,eng,math,total,avg,pass,level,jang);



	}

}

//int형 변수 x가 60이상일때 조건식
// x >= 60

//char형 변수 ch가 'a' 또는 'A' 일때 true인 조건식
// ch == 'a' || ch == 'A' 

//char형 변수 ch가 숫자('0'~'9') 일때 조건식
// ch >= '0' && ch <= '9'

//char형 변수 ch가 영문자(대문자) 일때 조건식
// ch >= 'A' && ch <= 'Z'