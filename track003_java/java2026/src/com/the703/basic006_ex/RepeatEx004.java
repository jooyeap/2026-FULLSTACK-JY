package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		
		char ch = '\u0000';
		

		for(ch='A';ch<='Z'; ch++) {
			if(ch%5 == 0 && ch != 'A') {System.out.println();}
			System.out.print(ch);
		}
		
		System.out.println("\n");
		ch = 'A';
		
		while(ch<='Z') {
			if(ch%5 == 0 && ch != 'A') {System.out.println();}
			System.out.print(ch);
			ch++;
		}
		
		System.out.println("\n");
		ch = 'A';
		
		do {
			if(ch%5 == 0 && ch != 'A') {System.out.println();}
			System.out.print(ch);
			ch++;
		}while(ch<='Z');
	}

}
