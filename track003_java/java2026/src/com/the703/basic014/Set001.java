package com.the703.basic014;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 1. 콜렉션 프레임워크 : [배열] 의 단점을 개선한 [객체]만 저장가능한 [동적배열]
// 2. List, Set, Map
// List(기차) - 순서 o , 중복 o / add, get, size, remove, contains
// Set(주머니) - 순서 x , 중복 x / add, 향상된 for/ Iterator, size, remove, contains;

class Candy{
	String name;
	int price;
	
	public Candy() { super(); }
	public Candy(String name, int price) { super(); this.name = name; this.price = price; }
	@Override public String toString() { return "Candy [name=" + name + ", price=" + price + "]"; }
	
	@Override public int hashCode() { return Objects.hash(name, price); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}
	
}

public class Set001 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(new Integer(1)); // Integer e = new Integer(1) 부품객체
		set1.add(1); // Integer e = 1  (기본값)
		set1.add(1); // 부품객체 = 기본값 (Integer - wrapper 클래스)
		set1.add(1); // 기본값을 자동으로 - 객체화 - 부품객체(wrapper 클래스)
		set1.add(2);
		set1.add(3);
		
//		Integer i1 = 1; // 부품객체 = 기본값
//		int i2 = i1;	// 기본값 = 부품객체
//		float f = i1.floatValue();
//		//float f2 = i2.floatValue();  -> 기본값은 부품객체의 특성을 이용못함
//		// Wrapper - Integer, Float, Double ~ 
//		System.out.println(i1 + " : " + f);
//		System.out.println(i1 + " : " + i2);
		
		System.out.println(set1); // 1개만 출력 -> [1]
		
		Set<Candy> set2 = new HashSet<>();
		set2.add(new Candy("사탕",200));
		set2.add(new Candy("사탕",200));
		set2.add(new Candy("사탕",200));
		set2.add(new Candy("비싼사탕",4500));
		set2.add(new Candy("아이셔",1500));
		// add, get, size, remove, contains
		System.out.println(set2);
		System.out.println(set2.size());
		System.out.println(set2.remove(new Candy("사탕",200)) ? "먹엇당" : "못먹엇당");
		System.out.println(set2.contains(new Candy("아이셔",1500)) ? "있음" : "없음");
		
		System.out.println(set2);
		
		for(Candy a : set2) {
			System.out.println(a.name + "-" + a.price);
		}
	}
}
