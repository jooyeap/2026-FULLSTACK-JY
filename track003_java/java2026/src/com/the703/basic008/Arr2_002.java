package com.the703.basic008;

public class Arr2_002 {

	public static void main(String[] args) {
		// 1. 값을 알고 있는 경우
		int [][] arr2 = {
				{1,2,3} , // 00 01 02
				{4,5,6}	  // 10 11 12
		};
		
		// 2. 값을 모르는 경우
		
		int [][] arr21 = new int[2][3];
		// new 메모리 빌려오기  int 2층 3칸
		
		// ver-2
//		arr21[0][0] = 10; arr21[0][1] = 20; arr21[0][2] = 30;
//		arr21[1][0] = 40; arr21[1][1] = 50; arr21[1][2] = 60; // for 로
		
		// ver-3
		int count = 0;
		
//		for(int i=0; i<arr21.length; i++) {count++; arr21[0][i] = count;}
//		for(int i=0; i<arr21.length; i++) {count++; arr21[1][i] = count;}

		// ver-4
		
		for(int i=0; i<arr21.length; i++) { // 배열명.length 배열의 층수
			for(int j=0; j<arr21[i].length; j++) { // 배열명[i].length 배열[층]의 칸수
				count += 10;
				arr21[i][j] = count;
				System.out.print( arr21[i][j]+" ");
			} 
			System.out.println();
		}

	}

}
