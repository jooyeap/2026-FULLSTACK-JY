package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx006 {

	public static void main(String[] args) {
		
		int a = 0;
		int a_ck = 0;
		int b = 0;
		int b_ck = 0;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 1 입력 : ");
		a = sc.nextInt();
		a_ck = a;
		
		
		System.out.print("숫자 2 입력 : ");
		b = sc.nextInt();
		
		
		if(a < b) {
			for(;a <= b; a++) {
				System.out.print((a == a_ck ? "":"+")+a);
				result += a;
			}
		}
		else {
			for(;a >= b; a--) {
				System.out.print((a == a_ck ? "":"+")+a);
				result += a;
			}
		}
		
		
		
		System.out.print("="+result);
	}

}
