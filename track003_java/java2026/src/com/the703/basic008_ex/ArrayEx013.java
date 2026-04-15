package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx013 {

	public static void main(String[] args) {
		
		int [] datas = {1,3,1,1,4,4,3,1,4,1,2};
		int [] stars = new int[4];

		//    1  →  datas[0]  → starts[1-1]++  → stars[datas[0]-1]++ →  starts[0]++
		//    3  →  datas[1]  → starts[3-1]++  → stars[datas[1]-1]++ →  starts[2]++
		//    1  →  datas[2]  → starts[1-1]++  → stars[datas[2]-1]++ →  starts[0]++
		//    1  →  datas[3]  → starts[1-1]++  → stars[datas[3]-1]++ →  starts[0]++
		
		for(int i=0; i<datas.length; i++) { stars[datas[i]-1]++; }
		
		
		
//		for(int i=0; i<datas.length; i++) {
//			for(int j=1; j<5; j++) {if(datas[i] == j) {stars[a] += 1;} a++;}
//			a=0;
//		}
			

//		System.out.println(stars[0]);
//		System.out.println(stars[1]);
//		System.out.println(stars[2]);
//		System.out.println(stars[3]);
		
//		System.out.println("["+stars[0]+", "+stars[1]
//						 +", "+stars[2]+", "+stars[3]+"]");
		
		System.out.println(Arrays.toString(stars));
		
		for(int i=0; i<stars.length; i++) {
			for(int j=0; j<stars[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
				
		
	}

}
