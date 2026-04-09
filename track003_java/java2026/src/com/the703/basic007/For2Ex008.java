package com.the703.basic007;

public class For2Ex008 {

	public static void main(String[] args) {
		
		int b = 5;
		
		for(int a=1; a<6; a++) {
			System.out.print(a+"+");
			for(;(a+b) == 6; b--) {
				System.out.print(b+"="+(a+b));
			}
			System.out.println();
		}
		
		System.out.println();
		
		int a = 1; b = 5;
		while(a<6) {
			System.out.print(a+"+");
			while((a+b) == 6) {
				System.out.print(b+"="+(a+b));
				b--;
			}
			a++;
			System.out.println();
		}
		
		System.out.println();
		
		a = 1; b = 5;
		do {
			System.out.print(a+"+");
			do {
				System.out.print(b+"="+(a+b));
				b--;
			}while((a+b)==6);
			a++;
			System.out.println();
		}while(a<6);
	}

}
