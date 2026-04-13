package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
		
//		연습문제5)  array
//	패키지명 : com.the703.basic008_ex
//	클래스명 :  ArrayEx005
//	    1. 배열명 : ch
//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//	    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트
		
		char [] ch = {'B', 'a', 'n', 'a', 'n', 'a'};
		int count_A = 0, count_a = 0;
		
//		System.out.println((int)'a');
//		System.out.println((int)'z');
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {count_a++;}
			else {count_A++;}
		}
		
		System.out.println(count_a + "\n" + count_A);

	}

}
