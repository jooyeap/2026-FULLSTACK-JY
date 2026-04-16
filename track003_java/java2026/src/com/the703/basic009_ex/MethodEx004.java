package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {
	
//	연습문제4)  method
//	패키지명 : com.the703.basic009_ex
//	클래스명 :  MethodEx004
//	      ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//	      이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
//	      --------------------------------------------------------------------------------------------
//	      아이언맨   100   100   100   300    100.0    합격      장학생   **********
//	      --------------------------------------------------------------------------------------------

	public static int process_total(int i,int j,int k) { return i+j+k;}
	
	public static float process_avg(int i) { return i/3f;}
	
	public static String process_pass(float fl, int a, int b, int c) {
		return fl >= 60 ? (a < 40 || b < 40 || c < 40 ? "재시험" : "합격") : "불합격";
	}
	
	public static String process_scholar(float fl) {
		if(fl > 94) {return "장학생";}
		else {return "";}
	}
	
	public static String process_star(float fl) {
		String st = "";
		for(int i=0; i<(int)fl/10;i++) {
			st += "*";
		}
		return st;
	}
	
	public static void process_show(String name, int kor, int eng, int math, int total, float avg,
			String pass, String jang, String star) {
		System.out.printf("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
						 +"이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\n"
						 +"--------------------------------------------------------------------------------------------\n"
						 +"%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\n"
						 +"--------------------------------------------------------------------------------------------\n"
						 ,name,kor,eng,math,total,avg,pass,jang,star);
		
	}
	public static void main(String[] args) {
		
		String name  = ""; 
        int kor, eng, math, total ;
        float avg = 0.0f; 
	    String pass = "";
	    String jang = "";
	    String star= "";  
	    Scanner sc = new Scanner(System.in);
	    
	    /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
	    
	    System.out.print("이름 > ");
	    name = sc.next();
	    System.out.print("\n국어 > ");
	    kor = sc.nextInt();
	    System.out.print("\n영어 > ");
	    eng = sc.nextInt();
	    System.out.print("\n수학 > ");
	    math = sc.nextInt();
	   
	    /////////////////////(3) 처리 : 
	    total = process_total(kor , eng, math);    // 1. 총점처리
	      
	    avg = process_avg(total);    //2.  평균처리
	      
	    ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
	    pass = process_pass(avg , kor, eng, math);  
	      
	    //////// 4. 평균이 95점이상이면 장학생
	    jang = process_scholar(  avg  ); 
	      
	    //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
	    star = process_star(avg);  
	      
	      
	    /////////////////////(4) 출력
	    process_show(name, kor, eng, math, total, avg, pass, jang, star);
	}

}
