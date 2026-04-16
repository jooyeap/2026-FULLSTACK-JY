package com.the703.days;

public class Day016 {

	public static void main(String[] args) {
		// 101 102 103
		// 104 105 106
		
		int [] [] arr = new int[2][3];
		int count =101;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] += count++;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<=arr.length+1; j++ ) {
				arr[i][j-1] = 100+(j*(i+1));
				System.out.print(arr[i][j-1]+" ");
			}
			System.out.println();
		}

	}

}
