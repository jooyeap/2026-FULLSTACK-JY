package com.the703.basic009_ex;

public class MathodEx008 {

	public static int fact(int i) {
		if(i<1) {return 1;}
		return i *= fact(i-1);
	}
	
	public static void main(String[] args) {
		int result = fact(4);
		System.out.println(result);
	}

}
