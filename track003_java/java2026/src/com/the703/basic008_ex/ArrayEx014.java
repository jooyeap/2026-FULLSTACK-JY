package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx014 {

	public static void main(String[] args) {
		
		int [] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			System.out.println(lotto[i]);
			for(int j=0; j<i;j++) {
				if(lotto[i] == lotto[j] && j !=0 ) {
					lotto[i] = (int)(Math.random()*45)+1;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
		
//		int[] lotto = new int[6];
//	      
//	      for (int i = 0; i < lotto.length; i++) {
//	         lotto[i] = (int)(Math.random()*45)+1;
//	         int j = 0;
//	         while (j < lotto.length) {
//	            if(i!=j && lotto[i] == lotto[j]) {
//	               lotto[i] = (int)(Math.random()*45)+1;
//	               j = 0;
//	               System.out.println(j);
//	            }
//	            j++;
//	         }
//	      }
//	      System.out.println(Arrays.toString(lotto));
   }
}
