package com.the703.basic006_ex;

public class RepeatEx001 {

	public static void main(String[] args) {
//		연습문제7)  for/while/do while
//		패키지명 : ccom.the703.basic006
//		클래스명 :  RepeatEx001
//		1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
//		2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
//		3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3

		System.out.println("Q1-1. for 1 2 3 4 5");
		
		for(int i=1; i<=5; i++) { System.out.print(i+" ");}
		
		System.out.println();
		System.out.println("Q1-2. while 1 2 3 4 5");
		
		int i = 1;
		while(i<=5) {System.out.print(i+" "); i++;}
		
		System.out.println();
		System.out.println("Q1-3. do while 1 2 3 4 5");
		
		i = 1;
		do {System.out.print(i+" "); i++;} while(i<=5);
		
		System.out.println();
		System.out.println("Q2-1. for 5 4 3 2 1");
		
		for(i=5; i>=1; i--) {System.out.print(i+" ");}
		
		System.out.println();
		System.out.println("Q2-2. while 5 4 3 2 1");
		
		i = 5;
		while(i >= 1) {System.out.print(i+" "); i--;}
		
		System.out.println();
		System.out.println("Q2-3. do while 5 4 3 2 1");
		
		i = 5;
		do {System.out.print(i+" "); i--;} while(i>=1);
		
		System.out.println();
		System.out.println("Q1-1. for JAVA1 JAVA2 JAVA3");
		
		for(i=1;i<=3;i++) {System.out.print("JAVA"+i+" ");}
		
		System.out.println();
		System.out.println("Q1-2. while JAVA1 JAVA2 JAVA3");
		
		i = 1;
		while(i<=3) {System.out.print("JAVA"+i+" "); i++;}
		
		System.out.println();
		System.out.println("Q1-3. do while JAVA1 JAVA2 JAVA3");
		i = 1;
		do {System.out.print("JAVA" +i+" "); i++;} while(i <=3);
		
	}

}
