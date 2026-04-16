package com.the703.basic009_ex;

public class MethodEx002 {

//	연습문제2)  method
//	패키지명 : com.the703.basic009_ex
//	클래스명 :  MethodEx002
//	다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.
//	
	
	public static void test1(int num) { System.out.println(num); }
	
	public static void test2(double num) { System.out.println(num); }
	
	public static void hap(int i,int j) {
		int result = 0;
		for(; i<=j; i++) {
			result += i;
		}
		System.out.println(result);
	}
	
	public static void disp(int num,char ch) {
		for(int i=0; i<=num; i++) {System.out.print(ch);}
	}
	
	
	public static void main(String[] args) {
	    // public static  리턴값 메서드명(파라미터)
	    test1(10);    // 10 출력
	    test2(1.2);   // 1.2 출력
	    hap(3,5);     // 3+4+5한값  12 출력
	    disp(7, '*'); // *******출력
	}
		
}
