package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {

	/*연습문제7)  ※ 숙제
	패키지명 : com.company.java004_ex
	클래스명 :  IfEx007
	출력내용 :  계산기

	1. 정수를 하나 입력해주세요 > 10
	2. 정수를 하나 입력해주세요 > 3
	3. 연산자를 입력해주세요(+,-,*,/) > +
	10+3=13*/
		
		int num1 , num2 = 0;
		double result = 0;
		int result2 = 0;
		char ch = '\u0000';
		String st = "%d %s %d = %.0f";
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 하나 입력해주세요 > ");
		num1 = sc.nextInt();
		
		System.out.println("정수를 하나 입력해주세요 > ");
		num2 = sc.nextInt();
		
		System.out.println("연산자를 입력해주세요 (+,-,*,/) > ");
		ch = sc.next().charAt(0);
		
		if(ch == '+') {
			result = (num1 + num2);
		}
		
		else if(ch == '-') {
			result = num1 - num2;
		}
		else if(ch == '*') {
			result = num1 * num2;
		}
		else if(ch == '/') {
			result = ((double)num1 / num2);
			//st = "%d %s %d = %.2f";
			
		}
		
		//System.out.printf(st,num1,ch,num2,result);
		
		System.out.printf(ch == '/' ? "%d %s %d = %.2f" :
									  "%d %s %d = %.0f", num1, ch, num2, result);
		//System.out.println((int)ch);
		
//		System.out.println(
//				ch == '+' ? result = num1 + num2 : 
//			   (ch == '-' ? result = num1 - num2 :
//			   (ch == '*' ? result = num1 * num2 :
//			   (ch == '/' ? result = ((double)num1 / num2) : ""
//				   ))));
		
	}

}
