package com.the703.basic007;

public class For2Basic {

	public static void main(String[] args) {
		
		for(int x=1; x<5; x++) {
			for(int y=1; y<5; y++) {
				System.out.print(y);
			}
			System.out.println();
		}
		
		
		// 123
		// 123
		// 123
		// 123
		// ver-1
		
		System.out.println(1 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		System.out.println(2 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		// ver-2 각칸정리 for 정리 {반복되는 영역} {변수} for(시작;종료;변화)
		
		System.out.println();
		System.out.println(1+"층");
		for(int a=1; a<4; a++) { System.out.println(a);}
		
		System.out.println(2+"층");
		for(int a=1; a<4; a++) { System.out.println(a);}
		
		// ver-2 각층정리 for 정리
		
		for(int a=1; a<4; a++) {
			System.out.println(a + "층");
			for(int b=1; b<4;b++) {
				System.out.print(a+"0"+b +"호 ");
			}
			System.out.println();
		}
	}

}
