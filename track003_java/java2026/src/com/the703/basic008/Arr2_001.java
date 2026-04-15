package com.the703.basic008;

import java.util.Arrays;

public class Arr2_001 {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3};
		
		int [][] arr2 = {
				{1,2,3} , // 00 01 02
				{4,5,6}	  // 10 11 12
		};
		
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		
		// ver-1 눈에 보이는대로
		System.out.print(arr2[0][0]+"\t");
		System.out.print(arr2[0][1]+"\t");
		System.out.print(arr2[0][2]+"\t"); System.out.println();
		
		System.out.print(arr2[1][0]+"\t");
		System.out.print(arr2[1][1]+"\t");
		System.out.print(arr2[1][2]+"\t"); System.out.println();
		
		// ver-2 칸정리
		for(int kan=0; kan<=2; kan++) {System.out.print(arr2[0][kan]+"\t");}
		System.out.println();
		for(int kan=0; kan<=2; kan++) {System.out.print(arr2[1][kan]+"\t");}
		System.out.println();
		
		// ver-3 층정리
		
		for(int i=0; i<3; i++ ) {
			for(int j=0; j<3; j++) {System.out.print(arr2[i][j]+"\t");}
		}
		
		// ver-4 length 이용
		// 배열명.length 층 / 배열명[0](층).length
		for(int i=0; i<arr2.length; i++) { // 층
			for(int j=0; j<arr2[i].length; j++) {System.out.print(arr2[i][j]+"\t");} // 칸
			System.out.println();
		}
	}

}
