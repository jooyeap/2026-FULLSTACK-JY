package com.the703.basic007;

public class For2Ex001 {

	public static void main(String[] args) {
		
		// ####
		// ####
		// ####
		// ####
		// ver-1 눈에 보이는 그대로
		System.out.print('#');System.out.print('#');System.out.print('#');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('#');System.out.print('#');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('#');System.out.print('#');System.out.print('#');System.out.println();
		System.out.print('#');System.out.print('#');System.out.print('#');System.out.print('#');System.out.println();
		
		// ver-2 칸정리
		for(int a=1; a<5;a++) {System.out.print("#");} System.out.println();
		
		for(int a=1; a<5;a++) {System.out.print("#");} System.out.println();
		
		// ver-3 층정리
		for(int a=1; a<5;a++) {
			for(int b=1;b<5;b++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
	}

}
