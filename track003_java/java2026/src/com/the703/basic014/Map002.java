package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Map002 {
	public static void main(String[] args) {
		Map<String, UserDto> maps = new HashMap<>();
		maps.put("first", new UserDto("first@gmail.com"));
		maps.put("second", new UserDto("second@gmail.com"));
		maps.put("third", new UserDto("third@gmail.com"));
		maps.put("third", new UserDto("33@gmail.com"));
		maps.put("third", new UserDto("33@gmail.com"));		// 키가 같아서 value 값만 덮어씀
		
		System.out.println("몇명 ? " + maps.size());			// 3
		System.out.println(maps);							// 5번째의 third 가 출력 / first, second 도 출력
		// third=UserDto [no=5, email=33@gmail.com]
		// first=UserDto [no=1, email=first@gmail.com]
		// second=UserDto [no=2, email=second@gmail.com]
		System.out.println();
		
		// 1. maps.entrySet() 이용해서 향상된 for문으로 출력
		for(Entry<String, UserDto> a : maps.entrySet()) {
			String key = a.getKey();
			UserDto value = a.getValue();
			System.out.println("nickname : " + key + ", emali : " + value.getEmail());
		}
		System.out.println();
		
		// 2. maps.entrySet() 이용해서 Iterator로 출력 (iterator(), hasNext(), next())
		Iterator<Entry<String, UserDto>> iter = maps.entrySet().iterator(); // 정렬, 줄서기
		
		while(iter.hasNext()) { // 처리대상 확인
			Entry<String, UserDto> a = iter.next(); // 다음 처리대상
			String key = a.getKey();
			UserDto value = a.getValue();
			System.out.println("id : " + key + ", email : " + value.getEmail());
		}
	}
}
