package com.the703.basic007;

public class For2Ex009 {

	public static void main(String[] args) {

		//A
		//AB
		//ABC
		//ABCD
		//ABCDE
		//ABCDEF
	
		
		for(int i=1; i<27; i++) {
			for(char ch = 'A'; (i+64) >= ch; ch++ ) {
				System.out.print(ch);
			}
			System.out.println();
		}
		
		System.out.println();
		int i = 1;
		while(i<27) {
			char ch = 'A';
			while((i+64) >= ch) {
				System.out.print(ch);
				ch++;
			}
			System.out.println();
			i++;
		}
		
		System.out.println();
		i = 1;
		do {
			char ch = 'A';
			do {
				System.out.print(ch);
				ch++;
			}while((i+64) >= ch);
			System.out.println();
			i++;
		}while(i<27);
		
	}

}
