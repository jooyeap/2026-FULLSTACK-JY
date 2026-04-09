package com.the703.basic007;

public class For2Ex011 {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 1;
		int result = 0;
		
		for( a=1; a<11; a++) {
			System.out.print(b+"+...+"+(a*10));
			for(; b<=(a*10);b++) {
				result += b;
			}
			System.out.print("="+result);
			System.out.println();
			result = 0;
		}
		
		a =1; b =1; result =0;
		System.out.println();
		
		while(a<11) {
			System.out.print(b+"+...+"+(a*10));
			while(b<=(a*10)) {
				result += b;
				b++;
			}
			System.out.print("="+result);
			System.out.println();
			result = 0;
			a++;
		}
		
		
		a =1; b =1; result =0;
		System.out.println();
		
		do {
			System.out.print(b+"+...+"+(a*10));
			do {
				result += b;
				b++;
			}while(b<=(a*10));
			System.out.print("="+result);
			System.out.println();
			result = 0;
			a++;
		}while(a<11);

	}

}
