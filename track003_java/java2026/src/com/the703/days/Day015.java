package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
		
		for(int i=3; i>0; i--) {System.out.print(i);}
		System.out.println();
		
		int i=3;
		while(i>0) {System.out.print(i); i--;}
		
		System.out.println();
		i=3;
		do {System.out.print(i); i--;}while(i>0);
		
		System.out.println();
		
		for(int x=3; x>0; x--) {
			for(int y=x; y>0; y--) {System.out.print("★");}
			System.out.println();
		}
		
		System.out.println();
		
		char [] arr = new char[3];
		
		for(int x=0; x<arr.length; x++) {
			arr[x] = (char)('A'+x);
			System.out.print(arr[x]);
			}
		
	}

}
