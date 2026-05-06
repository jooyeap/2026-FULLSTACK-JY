package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// List : 기차 - 순서, 중복 o 
// Set  : 주머니 - 순서, 중복 x
// Map  : 사전 - key:value  put, get(key), size, remove, contains

public class Map001 {
	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("one", 1);		// key, 값(value)
		maps.put("two", 2);		// 엔트리
		maps.put("three", 3);
		
		System.out.println("1 : " + maps);				// 배열 출력(key=value)
		System.out.println("2 : " + maps.get("two")); 	// two(key)의 밸류값 출력 2
		System.out.println("3 : " + maps.size());		// 배열? 길이 출력 3
		
		System.out.println("4-1 : " + maps.remove("two"));// two(key)의 밸류값 출력 2 > 해당 키값,밸류 삭제
		System.out.println("4-2 : " + maps);
		
		System.out.println("5 : " + maps.containsKey("three")); // 키값 존재 확인후 true,false 반환
		System.out.println("6 : " + maps.containsValue(2));		// 밸류값 존재 확인후 true,false 반환
		
		System.out.println("7-1 : " + maps.entrySet());		// key:value 한쌍 묶음			7-1 : [one=1, three=3]
		System.out.println("7-2 : " + maps.keySet());		// key 객체들로만 이루어진 묶음		7-2 : [one, three]
		// Entry<String, Integer> : [one=1, three=3]
		for( Entry<String, Integer> m : maps.entrySet()) {
			System.out.println( m.getKey() + "-" + m.getValue() );
		}
		// maps.keySet() : [one=1, three=3]
		for( String key : maps.keySet() ) {
			System.out.println(key + "-" + maps.get(key));
		} // get(key) 키를 주면 값을 반환
		
		Iterator<Entry<String, Integer>> iter = maps.entrySet().iterator();
		// #1. 반복자 - 알아서 처리 -> maps.entrySet() 키와 value의 한쌍으로 .iterator() 줄을 세움
		// iter -> [one=1, three=3]
		while(iter.hasNext()){// #2. hasNext() 처리대상확인 iter [->one=1, three=3]
			Entry<String, Integer> m = iter.next();// #3. next() 한개씩 꺼내오기
			System.out.println( m.getKey() + "-" + m.getValue());
		}
		
		Iterator<String> kiter =  maps.keySet().iterator();
		// #1. 키들을 모음 [one, three] iterator() 줄을 세움
		//     kiter -> [one, three]
		while(kiter.hasNext()){// #2. kiter [->one, three]
			String key = kiter.next(); // #3. next() 한개씩 꺼내오기
			System.out.println(key + "-" + maps.get(key));
		}
		
	}
}
