package com.the703.basic007;

public class For2Ex002 {

	public static void main(String[] args) {

		//@###
		//#@##
		//##@#
		//###@
		System.out.print('@');System.out.print('#');System.out.print('#');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('@');System.out.print('#');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('#');System.out.print('@');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('#');System.out.print('#');System.out.print('@');System.out.println();
		
		System.out.println();	// 4번 출력 - 네번째 자리에 오면 @
		for(int i=1; i<5; i++) {System.out.print(i==1 ? '@' : '#');} System.out.println();
								// 4번 출력 - 첫번째 자리에 오면 @
		for(int i=1; i<5; i++) {System.out.print(i==1 ? '@' : '#');} System.out.println();
								// 4번 출력 - 두번째 자리에 오면 @
		for(int i=1; i<5; i++) {System.out.print(i==1 ? '@' : '#');} System.out.println();
								// 4번 출력 - 세번째 자리에 오면 @
		for(int i=1; i<5; i++) {System.out.print(i==1 ? '@' : '#');} System.out.println();
		
		System.out.println();
		for(int a=1; a<5; a++) {
			for(int b=1; b<5; b++) {
				if(a == b) {System.out.print('@'); continue;}
				System.out.print('#');
			}
			System.out.println();
		}

	}

}
