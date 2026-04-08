package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
//		연습문제2)  for/while/do while
//			패키지명 : com.the703.basic006_ex;
//			클래스명 :  RepeatEx002
//			for , while , do while 3가지 버젼으로 
//			1~10까지 3의 배수의 합 : 18
//
//
//
//			힌트)
//			ver-1)
//			1이  3의 배수라면  합을더해주변수에누적
//			2가  3의 배수라면  합을더해주변수에누적
//			3이  3의 배수라면  합을더해주변수에누적
//
//			ver-2)
//			if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
//			if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
//			if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }
		int i = 0;
		int result = 0;
		
		for(i=1;i<=10;i++) {
			if(i%3 == 0) { result += i;}
		}
		System.out.println("3의 배수의 합 :" + result);
		System.out.println();
		
		i = 0; result = 0;
		
		while(i<=10) {
			if(i%3 == 0) {result += i;}
			i++;
		}
		System.out.println("3의 배수의 합 :" + result);
		System.out.println();
		
		i = 0; result = 0;
		
		do { 
			if(i%3 == 0) {result +=i;}
			i++;
		} while(i<=10);
		System.out.println("3의 배수의 합 :" + result);
		System.out.println();
		
		////////////////////////////////////////////////////////////
		
		i = 0; result = 0;
		
		System.out.print("1~10까지 3의 배수의 합 : ");
		
		for(i=1;i<=10;i++) {
			if(i%3 == 0) {
				result += i;
				System.out.print(i == 3 ? i : "+" + i);
			}
		}
		
		System.out.print(" = " + result);
		System.out.println();
		
		i = 1; result = 0;
		
		System.out.print("1~10까지 3의 배수의 합 : ");
		
		while(i<=10) {
			if(i%3 == 0) {
				result += i;
				System.out.print(i == 3 ? i : "+" + i);
			}
			i++;
		}
		
		System.out.print(" = " + result);
		System.out.println();
		
		do {
			if(i%3 == 0) {
				result += i;
				System.out.print(i == 3 ? i : "=" + i);
			}
			i++;
		}while(i<=10);
	}

}
