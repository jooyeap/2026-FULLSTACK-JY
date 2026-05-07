package com.the703.basic015;

class RefClass{ void method(String str) { System.out.println(str);} }
interface InterUsing{ void inter( RefClass c, String str); }  

interface  InterBasic{ int method(int a, int b); }  
interface  InterString{ int compare(String a, String b); }  
interface  InterParse{ int parse(String s); }  
interface  InterAbs  { int apply(int a); }  
interface  InterPrint{ void print(String s); }  

interface  Ex1{ int getLength(String s); }   
interface  Ex2{ void print(String s); }  

public class Lambda003 {
	public static void main(String[] args) {
		// #1. 익명 클래스
		InterUsing a1 = new InterUsing() {
			@Override public void inter(RefClass c, String str) { c.method(str); }
		};
		a1.inter( new RefClass(), "a1" ); // 부품객체(RefClass)의 method 를 사용
		
		// #2. 람다식 () -> {} [RefClass]의 [method]를 사용 
		InterUsing a2 = (RefClass c, String str) -> { c.method(str);};
		a2.inter( new RefClass(), "a2" );
		
		InterUsing a3 = (c, str) -> c.method(str);
		a3.inter( new RefClass(), "a3" );
		
//		class     RefClass{ void method(String str) { System.out.println(str);} }
//		interface InterUsing{ void inter( RefClass c, String str); }
		// #3. :: 표현식(참조)
		InterUsing a4 = RefClass::method; // 자동 연결 1) RefClass 2) method
		a4.inter( new RefClass(), "a4" );
		
		System.out.println("------------------------------------");
		//////////////////////////////////////////////////////////////////////////
		
//		interface  InterBasic{ int method(int a, int b); }  
		// max Static(바로사용가능)
		InterBasic basic1 = (int a,int b) -> { return Math.max(a, b);/* max -> a,b 중에 큰값 반환*/ }; 
		System.out.println(basic1.method(10, 3));
		
		InterBasic basic2 = (a,b) -> Math.max(a, b);	// Math 부품의 max를 사용 
		System.out.println(basic2.method(10, 33));
		
		InterBasic basic3 = Math::max;					// 부품객체::기능 을 사용 
		System.out.println(basic3.method(44, 33));
		
		InterBasic basic4 = (a,b) -> Math.min(a, b);	/* min -> a,b 중에 작은값 반환*/
		System.out.println(basic4.method(44, 33));
		
		InterBasic basic5 = Math::min;					//   부품객체::기능 을 사용 
		System.out.println(basic5.method(44, 33));
		
		
		System.out.println("------------------------------------");
		
		// interface  InterString{ int compare(String a, String b); }
		// String.compareTo
		InterString basic6 = (a, b) -> a.compareTo(b);  
		System.out.println(basic6.compare("apple", "banana")); // 문자열이 같으면 0 , (음수) a<b a가 b보다 앞에와요 , (양수) a>b a가 b보다 뒤에와요
		
		InterString basic7 = String::compareTo;			
		System.out.println(basic7.compare("banana", "apple")); // String(부품)의 compareTo(기능)를 사용
		
		System.out.println("------------------------------------");
//		interface  InterParse{ int parse(String s); }  
		InterParse basic8 = a -> Integer.parseInt(a);
		System.out.println( basic8.parse("10") +3); // parse("a") + b -> 자료형 String인 a를 자료형 int인 b랑 연산
		
		InterParse basic9 = Integer::parseInt;	
		System.out.println(basic9.parse("12") +4); // Integer(부품)의 parseInt(기능)를 사용
		
		System.out.println("------------------------------------");
//		interface  InterAbs  { int apply(int a); }  
		InterAbs basic10 = a -> Math.abs(a);
		System.out.println(basic10.apply(-10)); // apply(a) -> a를 절대값으로
		
		InterAbs basic11 = Math::abs;
		System.out.println(basic11.apply(-12));	// Math(부품)의 abs(기능)를 사용
		
		System.out.println("------------------------------------");
//		interface  InterPrint{ void print(String s); }
		InterPrint basic12 = a -> System.out.println(a);
		basic12.print("bababa");
		
		InterPrint basic13 = System.out::println; // System.out(부품)의 println(기능)을 사용
		basic13.print("bobobo");
		
		System.out.println("------------------------------------");
//		interface  Ex1{ int getLength(String s); }   
		Ex1 ex1 = a -> a.length();
		System.out.println(ex1.getLength("hello")); // getLength("a") -> a의 문자열 길이를 숫자로 반환
		
		Ex1 ex2 = String::length;
		System.out.println(ex2.getLength("babababa"));	// String(부품)의 length(기능)을 사용
		
		System.out.println("------------------------------------");
//		interface  Ex2{ void print(String s); }
		Ex2 ex3 = a -> System.out.println(a);
		ex3.print("lambda");
		
		Ex2 ex4 = System.out::println;
		ex4.print("laaambda");
		
	}
}


