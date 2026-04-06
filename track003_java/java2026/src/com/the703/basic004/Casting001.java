package com.the703.basic004;

public class Casting001 {

	public static void main(String[] args) {
		// 1. 자료형 ( 기본형 / 참조형 )
		// 2. 기본형 - boolean - true / false
		//			 정수형 : byte < short < *int* < long / 1 2 4 8
		//  		 실수형 : float < *double* / 4 8
		// 3. #1. 형변환 - 자동 타입변환 (boolean 빼고)
		
		byte by = 1; short sh = 2; int in = 4; long lo = 8L;
		
		float fl = 3.14f; double dou = 3.14;
		boolean bl = true; 
		
		sh = by; // 정수형(2byte) - 정수형(1byte)
		in = by; // 정수형(4byte) - 정수형(1byte)
		lo = by; // 정수형(8byte) - 정수형(1byte)
		//lo = fl;  정수형(8byte) - 실수형(4byte) fl이 실수형이라 fl이 더커서 넣을수없음 
				 //Type mismatch: cannot convert from float to long
		fl = lo; // 실수형(4byte) - 정수형(8byte) 실수형이 더크니까 담을수있음
		//in = bl;  정수형(4byte) - 불린형(1byte)
				 //Type mismatch: cannot convert from float to long
		by = -128;
		by = 0;
		//by = 128; // byte -128 ~ 127
		// 1) bit : 1  0 < 8bit = 1byte >
		// 		1 0 (2개) / 10 10 -> 11 10 01 00 (4개)
		// 		2^1=2    2^2=4   2^3=8
		//      2 4 8 16 32 64 128 256 512 1024 2048
		// 2) 양수음수 -128 , 0 , 127
		
		//    #2. 형변환 - 강제 타입변환
		
		by = (byte) in; // 정수형(1byte) - 정수형(4byte)
		
		int in2 = (int) 1.2;
		float fl2 = (float) 1.2;
		System.out.println(in2 + "\t" + fl2);
		
		// Q1) System.out.println(  1.5 + 2.7 ); 형변환이용해서 3으로 나오게 만들기
		
		int a = (int) 1.5;
		int b = (int) 2.7;
		
		System.out.println( a + b );
		System.out.println((int)1.5 + (int)2.7);
		
		

		
	}

}
