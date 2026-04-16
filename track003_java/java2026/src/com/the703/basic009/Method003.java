package com.the703.basic009;

public class Method003 {

	// 1. 함수 수조 public static 리턴값(결과물) 메서드명(마법상자이름) (파라미터:재료) {할일}
	
	public static int hello(String name) { return 1;  }
	//public static void hello(String name) { System.out.println();  }
	
	public static String sing() {return "용감한 자바전사";} 
	
	public static String intro(String name, int level) {return name+"님의 레벨은 "+level;}
	
	public static double spell(int num) {return num/2f;}
	
	public static int luck() {return 100;}
	
	public static int s(int num) {return num*100;}
	
	//////////////////////////////////////////////////
	public static void main(String[] args) {
		hello("aaa");	// 사용법 : 마법상자이름(파라미터:재료) / 출력 구문이 없어서 안보이는것뿐 1로 값을 반환받음
		System.out.println( hello("bbb")); // 1
		
		// public static 리턴값 메서드명(파라미터){해야할일}
		
		//public static String sing() {return "용감한 자바전사";}
		System.out.println("1. 당신의 이름은? " + sing()); // 용감한 자바전사
	
		//public static String intro(String name, int level) {return name+"님의 레벨은 "+level;}
		System.out.println("2. 당신의 소개? " + intro("홍길동", 9)); // 홍길동님의 레벨은 9 
		
		System.out.println("2. 당신의 소개? " + intro(sing(), 10));

		//public static double spell(int num) {return num/2f;}
		System.out.println("3. 반타작의 저주 > " + spell(9)); // 4.5
	
		//public static int luck() {return 100;}
		System.out.println("4. 운세 > " + luck()); // 100
		
		//public static int s(int num) {return num*100;}
		System.out.println("5. 주식 > " + s(1)); // x100
	}
	//////////////////////////////////////////////////
}
