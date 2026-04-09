package com.the703.basic007;

public class For2Ex013 {

	public static void main(String[] args) {
		
		for(int a=2; a<10; a++) {
			System.out.println(a+"단");
			for(int b=1; b<10; b++) {
				System.out.println(a+"*"+b+"="+(a*b));
			}
			System.out.println();
		}
		
		System.out.println();
		int a=2; int b=1;
		
		while(a<10) {
			System.out.println(a+"단");
			while(b<10) {
				System.out.println(a+"*"+b+"="+(a*b));
				b++;
			}
			b = 1;
			a++;
			System.out.println();
		}
		
		System.out.println();
		a=2; b=1;
		
		do {
			System.out.println(a+"단");
			do {
				System.out.println(a+"*"+b+"="+(a*b));
				b++;
			}while(b<10);
			b = 1;
			a++;
			System.out.println();
		}while(a<=9);

	}

}
