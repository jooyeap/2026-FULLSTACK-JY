package com.the703.basic009_ex;

public class MathodEx006 {

	public static void test(int i) {
		if(i<1) {return;}
		System.out.print(i+" ");
		test(--i);
	}
	
	public static void main(String[] args) {
		test(10);
	}

}
