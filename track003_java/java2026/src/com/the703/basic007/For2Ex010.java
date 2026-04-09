package com.the703.basic007;

public class For2Ex010 {

	public static void main(String[] args) {
		
		
		//90까지? 65부터
		for(int i=27; i>0; i--) {
			for(char ch ='A'; ch <= (i+63) ; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
		int i = 27;
		while(i>0) {
			char ch = 'A';
			while(ch <= (i+63)) {
				System.out.print(ch);
				ch++;
			}
			System.out.println();
			i--;
		}

		i =27;
		
		do {
			char ch = 'A';
			do {
				System.out.print(ch);
				ch++;
			}while(ch <= (i+63));
			System.out.println();
			i--;
		}while(i>1);
		
	}

}
