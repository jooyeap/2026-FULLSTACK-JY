package com.the703.basic002_ex;

public class VarEx002 {
	
	public static void main(String[] args) {
		
		int a;
		a = 10;
		int b;
		b = 3;
		
		System.out.println(a + "+" + b + "="+ (a + b));
		System.out.println(a + "-" + b + "="+ (a - b));
		System.out.println(a + "*" + b + "="+ (a * b));
		System.out.println(a + "/" + b + "="+ (a / b));
		
		System.out.println();
		
		//%d+%d=%d
		System.out.printf("%d+%d=%d\n" , a , b ,(a+b));
		System.out.printf("%d-%d=%d\n" , a , b ,(a-b));
		System.out.printf("%d*%d=%d\n" , a , b ,(a*b));
		System.out.printf("%d/%d=%d\n" , a , b ,(a/b));
		
		
	}

}
