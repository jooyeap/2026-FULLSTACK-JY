package com.the703.basic007;

public class For2Ex012 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 0;
		int result = 0; 
		
		for(a=1; a<11; a++) {
			for(b=1; b<=(a*10);b++) {
				System.out.print((b == 1 ? "" : "+")+b);
				result += b;
			}
			System.out.print("="+result);
			System.out.println();
			result = 0;
		}
		
		System.out.println();
		a =1; b =1; result =0;
		
		while(a<11) {
			while(b<=(a*10)) {
				System.out.print((b == 1 ? "" : "+")+b);
				result += b;
				b++;
			}
			b = 1;
			System.out.print("="+result);
			System.out.println();
			result = 0;
			a++;
		}
		
		System.out.println();
		a =1; b =1; result =0;
		
		do {
			do {
				System.out.print((b == 1 ? "" : "+")+b);
				result += b;
				b++;
			}while(b<=(a*10));
			b=1;
			System.out.print("="+result);
			System.out.println();
			result = 0;
			a++;
		}while(a<11);

	}

}
