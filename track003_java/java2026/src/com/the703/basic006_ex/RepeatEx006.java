package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx006 {

	public static void main(String[] args) {
		
		// 1. 문자열 입력받기
		// 2. 토마토 tomato 기러기 apple
		// 3. 
		int leng = 0;
		String word = "";
		Scanner sc = new Scanner(System.in);
		
		// 앞뒤 문자를 조건문으로 받을수 있나?
		
		System.out.print("단어 입력 > ");
		word = sc.next();
		leng = word.length();
		
//		System.out.println(leng);
		
		if(word.charAt(0) == word.charAt(leng-1)) {
			System.out.println("앞뒤 같음");
		}
		else {
			System.out.println("앞뒤 틀림");
		}
		

	}

}
