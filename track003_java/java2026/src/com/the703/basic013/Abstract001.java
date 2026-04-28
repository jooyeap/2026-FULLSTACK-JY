package com.the703.basic013;

/*
	abstract (is A) 일반 클래스 + 설계
	고양이도 동물이다.
	개도 동물이다.
	
	<<abstract>>
	   Animal		{name / eat(), sleep(), poo()}
	 ↑        ↑
    cat      dog	{@eat(), @sleep(), @poo()}
*/

abstract class Animal{
	String name;			// 인스턴스 변수 = heap area - new o - this 각각
	abstract void eat(); 	// 추상 메서드는 구현부( {} )가 없음
	abstract void sleep(); 	// 추상 메서드는 추상클래스로 만들어야함
	abstract void poo();	// 추상화, 일반화, 설계 : 공통의 속성, 구체적인 내용이 없음
}

class Cat extends Animal{
	@Override void eat() { System.out.println(super.name + " 고양이 냠냠"); }
	@Override void sleep() { System.out.println(super.name + " 고양이 드르렁"); }
	@Override void poo() { System.out.println(super.name + " 고양이 시원"); }	
}

class Dog extends Animal{
	@Override void eat() { System.out.println(super.name + " 강아지 냠냠"); }
	@Override void sleep() { System.out.println(super.name + " 강아지 드르렁"); }
	@Override void poo() { System.out.println(super.name + " 강아지 시원"); }
}

public class Abstract001 {
	public static void main(String[] args) {
		// 1. abstract : 일반 클래스 + 설계 의 역할
		
		//new 메모리 빌리고 객체생성, Animal 초기화 -> ! {} 구현부가 없음 
		//Animal ani = new Animal(); -> 인스턴스화 불가
		//이유 : abstract void eat(); -> 구현부가 없음, 때문에 실체화 불가
		
		Animal ani = null; // { name, eat(), sleep(), poo()}
		ani = new Cat(); // 부모 <- 자식  업캐스팅 | 타입캐스팅 필요x
		ani.name = "웅냥"; ani.eat();
		
		ani = new Dog();
		ani.name = "멍멍"; ani.eat();
		
		// 2. 사용목적
		Animal [] arr = {new Cat(), new Cat(), new Dog(), new Dog()};
		int count = 0;
		for( Animal a : arr ) { a.name = "ani" + ++count; a.eat(); }
		// 각각의 인스턴스에 이름 | eat() 는 자식꺼 오버라이드 (최신기능? 제일 최근에 올라간거?)
	}
}
/*

	1. 추상화( abstract )
	- 실체화된 객체들 간 공통되는 특성을 추출
	- 미완성적인 개념 ( new 를 사용할 수 없음)
	- 공통된 필드와 메서드의 이름을 통일할 목적
	
	2. 추상 클래스
	
	
*/