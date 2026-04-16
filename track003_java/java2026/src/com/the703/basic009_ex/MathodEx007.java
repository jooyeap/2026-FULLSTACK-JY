package com.the703.basic009_ex;

public class MathodEx007 {

	public static int plus(int i) {
		if(i<1) {return 0;}
		return i += plus(i-1);
	}
	
	public static void main(String[] args) {
		int n =5;
		System.out.print("1부터"+n+"까지의 합계 : " + plus(n));
	}

}
