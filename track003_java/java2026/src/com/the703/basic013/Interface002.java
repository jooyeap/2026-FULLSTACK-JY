package com.the703.basic013;

interface Inter11 { void method1();}
interface Inter12 { void method2();}

interface Inter13 extends Inter11, Inter12{}

class Papa2{}
// 			주요 메인 클래스 상속 |	    	추가 설계 1, 추가 설계 2
class Son2 extends Papa2	  implements Inter11, Inter12{
	@Override public void method1() {};
	@Override public void method2() {};
}

public class Interface002 {
	public static void main(String[] args) {
		Son2 my = new Son2();
		// a instanceof b -> a 가 b의 상속 되어있으면 true 반환 
		if( my instanceof Object ){ System.out.println("1. Object");}
		if( my instanceof Papa2 ){ System.out.println("2. Papa2");}
		if( my instanceof Inter11 ){ System.out.println("3. Inter11");}
		if( my instanceof Inter12 ){ System.out.println("4. Inter12");}
		if( my instanceof Inter13 ){ System.out.println("5. Inter13");}
		
	}
}
