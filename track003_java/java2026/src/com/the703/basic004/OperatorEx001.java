package com.the703.basic004;

public class OperatorEx001 {

	public static void main(String[] args) {
		
		/*
연습문제5)  결과값은? 연산되는 순서는?
패키지명 : com.the703.basic004_ex
클래스명 : OperatorEx001
    int a=3, b=10;
    System.out.println(  b+=10 - a-- );   
    System.out.println(  a+=5 );
    System.out.println(  a>=10 || a<0 && a>3);
		 */
		
		int a = 3, b = 10;
		
		System.out.println( b += 10 - a--);
		// b(10) + 10   | a = 3  b = 20
		// 20 - a(3)    | a = 3  b = 17 
		// 17(출력)      | a = 3  b = 17
		// a (2) 값 감소  | a = 2  b = 17
		System.out.println( a += 5 );
		// a(2) + 5     | a = 7  b = 17
		// a(7)
		System.out.println( a >= 10 || a < 0 && a > 3 );
		// a = 7  b = 17
		// 순서대로 거짓 거짓 이니까 false값 출력
		// a(7) >= 10 false
		// a(7) < 0 false
		// a(7) > 3 true << 앞에 이미 false라 해당 조건은 읽지않음
		// false || false 

	}

}
