package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Milk{
	private String mname;
	private int mprice;
	public Milk() { super();  }
	public Milk(String mname, int mprice) { super(); this.mname = mname; this.mprice = mprice; }
	@Override public String toString() { return mname + " " + mprice; }
	
	// 클래스 확인 용도
	@Override public int hashCode() { return Objects.hash(mname, mprice); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;
	}
	
	public String getMname() { return mname; }
	public void setMname(String mname) { this.mname = mname; }
	public int getMprice() { return mprice; }
	public void setMprice(int mprice) { this.mprice = mprice; }
}

public class Day028 {
	public static void main(String[] args) {
		int count = 0;
		
		// List ( 기차 ) : 순서 o , 중복 o  / add, get, size, remove, contains
		List<Milk> milks = new ArrayList<>();
		
		milks.add(new Milk("바나나우유", 1300));
		milks.add(new Milk("메론맛우유", 1800));
		milks.add(new Milk("커피우유", 1500));
		milks.add(new Milk("커피우유", 1500));
		
		for(int i=0; i<milks.size(); i++) {
			Milk m = milks.get(i);
			System.out.println((i+1)+" "+m.getMname()+" "+m.getMprice());
		}
		System.out.println("-----------------");
			
		for(Milk m : milks) {
			System.out.println(++count+" "+m.getMname()+" "+m.getMprice());
		}
		System.out.println("-----------------");
		count = 0;
		// void java.util.List.sort( Comparator<? super Milk> c )
		// 리턴값 void ( 안에서 알아서 처리 )
		// Comparator<? super Milk> c - Comparator 비교 부품객체 <? super Milk> -> Milk 포함한 부모객체
		
		System.out.println("================");
		
		// 오름차순 정렬
		System.out.println("\n가격 순으로 오름차순");
		// 1. 익명적객체
//		milks.sort( new Comparator<Milk>() {
//			@Override public int compare(Milk o1, Milk o2) {  return Integer.compare(o1.getMprice(), o2.getMprice()); } 
//		});
		// 2. 람다식
//		milks.sort( (m1, m2) -> Integer.compare( m1.getMprice(), m2.getMprice() ) );
		// 3. 참조형 Integer(부품객체)에 compare(기능박스)
		// 
		// error : milks.sort( Integer::compare ); // 부품이 아니라 부품안의 값을 비교함 milk객체에서 가격을 꺼내야함
		milks.sort(Comparator.comparingInt(Milk::getMprice));
		
		
		for(Milk m : milks) { System.out.println(++count+" "+m.getMname()+" "+m.getMprice()); }
		System.out.println("================");
		// Set ( 주머니 ) : 순서 x , 중복 x / add, get(x) -> 향상된for/Iterator, size, remove, contains
		Set<Milk> set = new HashSet<>();
		
		set.add(new Milk("바나나우유", 1300));
		set.add(new Milk("메론맛우유", 1800));
		set.add(new Milk("커피우유", 1500));
		set.add(new Milk("커피우유", 1500));
		
		Iterator<Milk> iter = set.iterator(); // #1 줄 세우기
		
		while(iter.hasNext()) { // #2 처리 대상 확인
			Milk m = iter.next(); // #3 다음 처리대상
			System.out.println(++count +" "+ m.getMname()+" "+m.getMprice());
		}
		System.out.println("--------------------");
		count = 0;
		
		for(Milk m : set) {
			System.out.println(++count +" "+ m.getMname()+" "+m.getMprice());
		}
		System.out.println("--------------------");
		count = 0;
		
		// Map ( 사전 : key:value(쌍) ) / put, get(key), size, remove, contains
		Map<String,Milk> map = new HashMap<>();
		
		map.put("banana", new Milk("바나나우유", 1300));  
		map.put("melon", new Milk("메론맛우유", 1800));  
		map.put("coffee", new Milk("커피우유", 1500));  
		map.put("coffee2", new Milk("커피우유", 1500)); 
		
		for( Entry<String,Milk> a : map.entrySet()) {
			Milk m = a.getValue();
			System.out.println(a.getKey()+" "+m.getMname()+" "+m.getMprice());
		}
		System.out.println("--------------------");
		
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
//			System.out.println(key +" "+map.get(key).getMname() +" "+ map.get(key).getMprice());
		}
		System.out.println("--------------------");
		
		Iterator<Entry<String,Milk>> m =  map.entrySet().iterator();
		
		while(m.hasNext()) {
			Entry<String,Milk> a = m.next();
			System.out.println(a.getKey()+" "+a.getValue().getMname()+" "+a.getValue().getMprice());
		}
		
	}
}


/*
Q1. 빈칸 채우기
1.  List는 순서가 [ 있는 ] 구조로 데이터를 관리하며, 중복을 [ 허용함 ]
    - 주요 메서드: add, get, size, remove, contains	 -> 기차
2. Set은 순서가[ 없는 ] 구조로 데이터를 관리하며,  중복을 [ 허용하지않음 ]
    - 주요 메서드: add, get(x) -> 향상된for문 / Iterator, size, remove, contains -> 주머니
3. Map은 [key]와 [value]의 쌍으로 데이터를 관리한다. 
    - 주요 메서드: put, get(key), size, remove, containsKey, containsValue ~~
 
---

Q2. ArrayList, HashSet, HashMap을 작성하시오.  

1. Milk Dto 클래스 만들기  
   - 속성 : private String mname; private int mprice  

2. milks 이름으로 ArrayList 만들기  
3. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
4. for + size 이용해서 데이터 출력  
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
4     커피우유         1500
```
 
5. sets 이름으로 HashSet 만들기  
6. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
7. Iterator 이용해서 데이터 출력   
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
```
 
8. maps 이름으로 HashMap 만들기  
9. 다음의 데이터 넣기 (Key-Value 구조)  
   maps.put("banana", new Milk("바나나우유", 1300));  
   maps.put("melon", new Milk("메론맛우유", 1800));  
   maps.put("coffee", new Milk("커피우유", 1500));  
   maps.put("coffee2", new Milk("커피우유", 1500));  

10. for-each + keySet 이용해서 데이터 출력  
```
banana    바나나우유       1300
melon     메론맛우유       1800
coffee    커피우유         1500
coffee2   커피우유         1500
``` 

*/