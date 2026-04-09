package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		
		char ch = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a,b,c 중 입력 > ");
		ch = sc.next().charAt(0);
		
		if(ch == 'a' || ch == 'A') {System.out.println("APPLE");}
		else if(ch == 'b' || ch == 'B') {System.out.println("BANANA");}
		else if(ch == 'c' || ch == 'C') {System.out.println("COCONUT");}
		
		switch(ch) {
			case 'a': case 'A':System.out.println("APPLE"); break;
			case 'b': case 'B':System.out.println("BANANA"); break;
			case 'c': case 'C':System.out.println("COCONUT"); break;
		}
		
		for(int i=1; i<6; i++) { System.out.print(i + " "); }
		
		System.out.println();
		int i = 1;
		while(i < 6) { System.out.print(i+" "); i++; }
		
		System.out.println();
		i = 1;
		do {System.out.print(i+" ");i++;}while(i<6);

		
	}

}
