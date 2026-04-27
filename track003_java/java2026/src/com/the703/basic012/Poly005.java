package com.the703.basic012;

// 1. 다형성
//    하나의 타입(부모)으로 여러 타입의 객체(자식들)를 관리하는것이 목적
/*
 
  		Object
  		↑
  		Animal {String name; int age;}
  		↑	 ↑
 	   Cat   Person -> {int jumin ,@show()}
 		ㄴ>{String num, @show()}
 */

class Animal{
	String name;
	int age;
	void show() { System.out.println("Animal"); }
//	public Animal() { super();  }
//	public Animal(String name, int age) { super(); this.name = name; this.age = age; }
}

class Cat extends Animal{
	String num;
	@Override void show() { System.out.println("Cat > " + super.name + "/" + super.age); }
//	public Cat() { super();  }
//	public Cat(String name, int age) { super(name, age);  }
//	public Cat(String num) { super(); this.num = num; }
}

class Person extends Animal{
	int jumin;
	@Override void show() { System.out.println("Person > " + super.name + "/" + super.age); }
//	public Person() { super();  }
//	public Person(String name, int age) { super(name, age);  }
//	public Person(int jumin) { super(); this.jumin = jumin; }
}

public class Poly005 {
	public static void main(String[] args) {
		// 하나의 타입(부모)으로 여러타입의 객체(자식들)를 관리
		Animal [] anis = {new Cat() , new Cat(), new Person(), new Person()};
		for(int i=0; i<anis.length; i++) {anis[i].show();}
	}
}
