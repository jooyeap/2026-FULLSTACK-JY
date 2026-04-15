package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004 {

	public static void main(String[] args) {
		
//		연습문제4)  array
//	패키지명 : ccom.the703.basic008_ex
//	클래스명 :  Array2Ex004
//	배열을 이용하여 다음의 프로그램을 작성하시오.   
//	1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//
		int[][] datas = {  {  10, 10, 10 ,10},             
		                  {  20, 20, 20 ,20},     
		                  {  30, 30, 30 ,30},     
		};  // 3층 4칸                                  
		                               
		int[][] result = new int[datas.length+1][datas[0].length+1];    
//		int total_x = 0;
		
//
//	#1. result 에 datas데이터 복사하기
//	#2. 가로방향누적데이터
//	#3. 세로방향데이터누적
//	#4. 총합
//
//	출력내용:
//	10   10   10   10   40   
//	20   20   20   20   80   
//	30   30   30   30   120   
//	60   60   60   60   240
//		for(int i=0; i<datas.length; i++) {
//			
//			for(int j=0; j<datas[i].length; j++) {
//				result[i][j] = datas[i][j];
//				result[datas.length][j] += datas[i][j];
//				total_x += datas[i][j];
//				
//				if(j == 3) { 
//					result[i][j+1] = total_x;
//					result[datas.length][j+1] += total_x;
//				}
//			}
//			System.out.println(Arrays.toString(result[i]));
//			total_x = 0;
//			if(i == 2) {  System.out.println(Arrays.toString(result[i+1])); }
//		}
		
		for(int i=0; i<datas.length; i++) {
			
			for(int j=0; j<datas[i].length; j++) {
				result[i][j] = datas[i][j]; // 가로 데이터 누적
				result[datas.length][j] += datas[i][j]; // 세로 데이터 누적
				result[i][datas.length+1] += datas[i][j]; // 가로 합산 데이터 누적
				result[datas.length][datas.length+1] += datas[i][j]; // 전체 합산 데이터 누적
				
			}
			System.out.println(Arrays.toString(result[i]));
//			total_x = 0;
			if(i == 2) {  System.out.println(Arrays.toString(result[i+1])); }
		}

	}

}
