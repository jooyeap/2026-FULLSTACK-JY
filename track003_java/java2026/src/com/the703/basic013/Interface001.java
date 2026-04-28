package com.the703.basic013;

class Papa{
	int brain;
}
class Mama{
	int brain;
}
//class Son extends Papa,Mama{} 자바에서의 상속은 단일 상속

interface Animal2{
	// static final - Animal2.company로 접근 (클래스 변수) method area, new x ,this 로 각각처리 불가능
	String company="(주) 메가스터디"; 
	 // abstract | {} 구현부가 없음 -> 구현 클래스에서 상세내용
	void eat();
}

class Saram implements Animal2{
	@Override public void eat() { 
		//Animal2.company="kakao"; -> static final 재할당 X
		System.out.println( Animal2.company + " 치킨 ");
	}
}

class Pig implements Animal2{
	@Override public void eat() {
		System.out.println( Animal2.company + " 삼겹살 ");
	}
}

public class Interface001 {
	public static void main(String[] args) {
		// Animal2 ani = new Animal2(); 
		Animal2 [] anis = {new Saram(), new Saram(), new Pig()};
		for(Animal2 a : anis ) {a.eat();}
	}
}

/*
	Saram{@eat()}
		↓
	Animal2 { company="(주)메가스터디" / eat() }
		↑
	Pig{@eat()}
	
	
	
	1. interface
	- 개발코드 변경 없이 객체를 바꿔낄 수 있는 역할 
	
	2. abstract ( is a : 고양이는 동물이다 ) vs interface ( can do this )
	- 추상화 정도가 interface 가 더 높다
	1) abstract - 인스턴수 변수, 일반 메서드, 추상 메서드 둘다 가질 수 있으나
	2) interface = 상수(public static final) + 추상 메서드 ( public abstract )
	
	3. 프로젝트 진행시 interface 를 사용하면
	다른 구성원 들이 각각의 부분을 완성할때 까지 기다리지 않고 규약만 정해놓고 본인 부분만 작성
	
	4. 형식
	interface 인터페이스 이름{
		상수; 	  -> public static final
		추상 메서드; -> public abstract - this,new, 생성자, 구현부 X
		
	}

	class 클래스 이름 implements 인터페이스 이름{}
	
	class 클래스 이름 extends 클래스 이름 implements 인터페이스 이름 1, 인터페이스 이름 2{}
	ㄴ 구현력이 없어서 다중 상속이 가능
	
*/