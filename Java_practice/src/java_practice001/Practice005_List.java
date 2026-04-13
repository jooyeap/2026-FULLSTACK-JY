package java_practice001;

import java.util.Arrays;
import java.util.Scanner;

public class Practice005_List {

	public static void main(String[] args) {
		
		char a = '\u0000';
		String st = "";
		char [] ch = new char[26];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<ch.length; i++) { ch[i] = (char)('a'+i); }
//		System.out.println(Arrays.toString(ch));
		
		System.out.println("알파벳 한글자 > ");
		a = sc.next().charAt(0);
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == a) {System.out.println(ch[i]); break;}
		}
		
		char [] ch2 = new char[5];
		st = sc.next();
		
		for(int i=0; i<ch2.length; i++) {
			ch2[i] = st.charAt(4-i);
		}
		
		System.out.println(Arrays.toString(ch2));
		
	}

}
