package com.the703.basic009_ex;

public class MathodEx010 {

	public static int fibonacci(int i) {
		// 1+1 =2 1+2 =3 2+3 =5 3+5 =8 5+8 =13
		// i+j =k i+j =k i+j =k
		// i에 j넣고 j에 k 넣고 k 초기화
		int k=0;
		int j=k;
		k = i+j;
		j=k;
		return k;
		
	}
	
	public static void main(String[] args) {
		for(int i=1; i<5; i++) {System.out.print(fibonacci(i)+" ");}
	}

}
