package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx006 {

	public static void main(String[] args) {
		
		char [] list = new char[52];
//		char [] ch_a = new char[26];
//		char [] ch_A = new char[26];
		int count = 0;
		
		char ch = 'A';
		
//		for(int x=0; x<ch_a.length; x++) {
//			ch_A [x]= (char) ((int)ch-32);
//			ch_a [x]= ch++;
////			System.out.print(ch_a[x]);
////			System.out.println(ch_A[x]);
//			if(ch_a[x] == 'a' || ch_a[x] == 'e' || ch_a[x] == 'i'
//			|| ch_a[x] == 'o' || ch_a[x] == 'u') { count += 2;}
//		}
		
		for(int x=0; x<list.length/2; x++) { //반복횟수 반으로 나누는 대신 리스트에 한번에 2개씩 
			list[x] = ch; 				// A 대문자 부터 Z까지  
			list[x+26] = (char)(ch+32); // a 소문자 부터 z까지
			ch++;						// 처리 후 다음 문자로 ++
		}
		System.out.println(Arrays.toString(list));
		for(int x=0; x<list.length; x++) {
			
			if(ch==90) {ch += 7; continue;}
//			if(list[x] == 'a' || list[x] == 'A'){ count += 1;}
//			else if(list[x] == 'e' || list[x] == 'E'){ count += 1;}
//			else if(list[x] == 'i' || list[x] == 'I'){ count += 1;}
//			else if(list[x] == 'o' || list[x] == 'O'){ count += 1;}
//			else if(list[x] == 'u' || list[x] == 'U'){ count += 1;}
//			ch++;
			
			if(list[x] == 'a' || list[x] == 'A' ||
			   list[x] == 'e' || list[x] == 'E' ||
			   list[x] == 'i' || list[x] == 'I' ||
			   list[x] == 'o' || list[x] == 'O' ||
			   list[x] == 'u' || list[x] == 'U'){ count += 1;}
			ch++;
		}
		
		System.out.println("모음의 갯수 : " + count);
	}

}
