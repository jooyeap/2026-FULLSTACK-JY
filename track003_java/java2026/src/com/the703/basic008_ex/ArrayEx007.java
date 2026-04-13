package com.the703.basic008_ex;

public class ArrayEx007 {

	public static void main(String[] args) {
		
		char [] ch = {'B', 'a', 'n', 'a', 'n', 'a'};
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i] <= 90) {System.out.print((char)(ch[i]+32));}
			else {System.out.print((char)(ch[i]-32));}
		}

	}

}
