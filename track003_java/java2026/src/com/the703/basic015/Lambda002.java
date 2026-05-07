package com.the703.basic015;

////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String   hi(int num , String name); }   
////////////////////////////////////////////////////////////

public class Lambda002 {
	public static void main(String[] args) {
		// interface InterA2{  void   hi(); }
		System.out.println("[STEP1] 매개변수 X, 리턴값 X");
		// 1-1. 익명객체
		InterA2 a1 = new InterA2() { public void hi() { System.out.println("ㅎㅇ"); } };
		a1.hi();
		
		// 1-2. 람다식 ()->{}
		InterA2 a2 = () -> {System.out.println("람다 ㅎㅇ");};
		a2.hi();
		
		// 처리할일이 한줄이면 {}생략 가능
		InterA2 a3 = () -> System.out.println("더줄인 람다 ㅎㅇ");
		a3.hi(); 
		
		// interface InterB2{  void   hi(String name); }
		System.out.println("\n\n[STEP2] 매개변수 O, 리턴값 O");
		// 2-1. 익명객체
		InterB2 b1 = new InterB2() {
			public void hi(String name) {System.out.println("ㅎㅇ"+name);}
		};
		b1.hi("b1");
		
		// 2-2. 람다식
		InterB2 b2 = (String name) -> {System.out.println("람다 ㅎㅇ" + name);};
		b2.hi("b2");
		
		InterB2 b3 = (name) -> System.out.println("더줄인 람다 ㅎㅇ" + name);
		b3.hi("b3");
		
		InterB2 b4 = name -> System.out.println("더더줄인 람다 ㅎㅇ" + name);
		b4.hi("b4");
		
		// interface InterC2{  String hi(); }
		System.out.println("\n\n[STEP3] 매개변수 X, 리턴값 O");
		// 3-1. 익명객체  Good :Day
		InterC2 c1 = new InterC2() {
			public String hi() {
				return "Good :Day c1"; 
			}
		};
		System.out.println(c1.hi());
		
		// 3-2. 람다식
		InterC2 c2 = () -> {return "Good :Day c2";};
		System.out.println(c2.hi());
		
		InterC2 c3 = () -> "Good :Day c3";
		System.out.println(c3.hi());
		
		// interface InterD2{  String   hi(int num , String name); } 
		System.out.println("\n\n[STEP4] 매개변수 O, 리턴값 O");
		// 4-1. 익명객체 hi name
		InterD2 d1 = new InterD2() {
			public String hi(int num, String name) {
				String star = "";
				for(int i=0; i<num; i++) {star += "★";}
				return"hi "+ name + star;
			}
		};
		System.out.println(d1.hi(1, "이름 "));
		// 4-2. 람다식
		InterD2 d2 = (num , s) -> {
			String star = " ";
			for(int i=0; i<num; i++) { star += "★"; }
			return "hi " + s + star;
		};
		System.out.println(d2.hi(2, "이름"));
		
		InterD2 d3 = (num, s) -> { return "hi " + s + "★".repeat(num); };
		System.out.println(d3.hi(3, "이름 "));
		
		InterD2 d4 = (num, s) -> "hi " + s + "★".repeat(num);
		System.out.println(d4.hi(4, "이름 "));
	}
}