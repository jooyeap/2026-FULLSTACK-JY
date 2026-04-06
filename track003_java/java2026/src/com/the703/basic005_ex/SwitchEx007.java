package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 입력 > ");
		a = sc.nextInt();
		
		System.out.print("두번째 입력 > ");
		b = sc.nextInt();
		
		System.out.print("세번째 입력 > ");
		c = sc.nextInt();
		
		avg = (a+b+c)/3f;
		
//		avg = avg <= 90 && avg >= 100 ? 1 :
//			 (avg >= 80 ? 2 :
//			 (avg >= 70 ? 3 :
//			 (avg >= 60 ? 4 : 5)));
//		
//		switch((int)avg) {
//		case 1: System.out.println("수"); break;
//		case 2: System.out.println("우"); break;
//		case 3: System.out.println("미"); break;
//		case 4: System.out.println("양"); break;
//		case 5: System.out.println("가"); break;
//		}
		
		switch((int)avg/10) {
		case 9: case 10: System.out.println("수"); break;
		case 8: System.out.println("우"); break;
		case 7: System.out.println("미"); break;
		case 6: System.out.println("양"); break;
		default : System.out.println("가");
		}
		
		
		
		/*연습문제7)  
	패키지명 : com.company.basic005_ex  
	클래스명 : SwitchEx007 
	출력내용 : switch 이용
	평균 한 개 입력받아
	    90~100점대면 수
	    80~90점(90점미만)대면  우
	    70~80점(80점미만)대면  미
	    60~70점(70점미만)대면  양
	    나머지 가*/

	}

}
