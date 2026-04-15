package com.the703.basic008_ex;

//import java.util.Scanner;

public class ArrayEx010 {

	public static void main(String[] args) {
		
		int [] su = {-3,-5,-1,-9,-7}; // 2 3 1 5 4
		int rank = 1;
//		int a = 0; 
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("몇번째");
//		a = sc.nextInt();
		
		for(int i=0; i<su.length; i++) {
			if(i == 4) {continue;}
			if(su[4] < su[i]) { rank++; }
		}
		
		System.out.println(rank + "등");

		
//		su[0] su[1] 1 2 2 3 3 4
//		su[0] su[2] 1 3 2 4 
//		su[0] su[3] 1 4
//		su[0] su[4]
	}

}
