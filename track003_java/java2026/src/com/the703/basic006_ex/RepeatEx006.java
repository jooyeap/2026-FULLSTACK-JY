package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx006 {

	public static void main(String[] args) {
		
		// 1. 문자열 입력받기
		// 2. 토마토 tomato 기러기 apple
		int leng = 0;
		String word = "";
		
		Scanner sc = new Scanner(System.in);
		
		
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
		
		// 문자열 입력 programming
		// 문자열 빈도수 p:1 r:2 o:1 g:2 a:1 ~~~ >
		// 가장 많이 나온 문자: 'r' (2번)
		
		

	}

}
