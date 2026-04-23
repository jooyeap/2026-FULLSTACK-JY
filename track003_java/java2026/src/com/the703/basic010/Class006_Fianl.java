package com.the703.basic010;

// 1. final 변경하지마
// 1) 클래스는 부품객체
// 2) 클래스(상속:x)는 상태(멤버변수:상수)와 행위(멤버함수:물려주기x)를 갖는다

// final class -> 재사용하지마 / 상속x

class FinalEx extends Object{
	static final String child = "5-5"; // 클래스 변수 - method area / new 생성자와 관련 x
	String name; // 인스턴스 변수 - heap area / new,생성자,this와 관련 o
	/*final*/ void show() { System.out.println(child + "\t" + name); }  // 인스턴스 메서드
}

class FinalExSon extends FinalEx{
	@Override void show() { System.out.println("나한테 맞게 수정");}
}

//class Test extends Color{}

public class Class006_Fianl {
	public static void main(String[] args) {
		//FinalEx.child = "5-12"; -> 수정불가
		
	}
}
/*

	final ( 하지마 )
	
	1) 클래스 -> ( 상속 x - extends(재사용) 사용못함 )
	2) 멤버변수 -> ( 상수 o - 값변경 불가 )
	3) 멤버함수 -> ( 부모기능 수정 x @Override 못함 )

*/