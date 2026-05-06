package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx003 {
	public static void main(String[] args) {
		int count = 0;
		String name = "";
		String key = "";
		Map<String, Map<String, BookDto>> library = new HashMap<>();
		Map<String, BookDto> sLibrary = new HashMap<>();
		Map<String, BookDto> bLibrary = new HashMap<>();
		
		//library.put("서울점", Map<"978-11111",new BookDto("자바의 정석","남궁성")>);
		
		sLibrary.put("978-11111", new BookDto("자바의 정석", "남궁성"));
		sLibrary.put("978-22222", new BookDto("파이썬 기초", "홍길동"));
//		System.out.println(sLibrary);
		library.put("서울점", sLibrary);
		
		bLibrary.put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));
		bLibrary.put("978-44444", new BookDto("파이썬 심화", "홍길동"));
//		System.out.println(bLibrary.get(bLibrary));
		library.put("부산점", bLibrary);
		
		System.out.println("=== 도서관 전체 목록 ===");
		count = library.size();
		for(Entry<String, Map<String,BookDto>> out : library.entrySet()) {
			System.out.println(out.getKey());
			if(count == library.size()) {
				for(Entry<String, BookDto> in : sLibrary.entrySet()) {
					BookDto a = in.getValue();
					System.out.println(in.getKey()+" | "+a.getTitle()+" | "+a.getAuthor());
				}
			}
			else if(count == (library.size()-1)) {
//				System.out.println("진입");
				for(Entry<String, BookDto> in : bLibrary.entrySet()) {
					BookDto a = in.getValue();
					System.out.println(in.getKey()+" | "+a.getTitle()+" | "+a.getAuthor());
				}
			}
			System.out.println("-------------------------");
			--count;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("\n지점 이름 입력 > ");
		name = sc.next();
		System.out.print("\nISBN 입력 > ");
		key = sc.next();
		
//		Iterator<Entry<String,Map<String,BookDto>>> iter =  library.entrySet().iterator();
//		
//		while(iter.hasNext()) {
//			Entry<String,Map<String,BookDto>> a = iter.next();
//			if(a.getKey().equals(name)) {
//				System.out.print("📖 선택한 도서 정보 : " + a.getKey() + " ");
//			}
//		}
		if(name.equals("서울점")) {
			Iterator<Entry<String,BookDto>> inIter = sLibrary.entrySet().iterator();
			while(inIter.hasNext()) {
				Entry<String,BookDto> a = inIter.next();
				BookDto b = a.getValue();
				if(a.getKey().equals(key)) {
					System.out.println("📖 선택한 도서 정보 : " + b.getTitle() + " / " + b.getAuthor());
				}
			}
		}
		else if (name.equals("부산점")){
			Iterator<Entry<String,BookDto>> inIter = bLibrary.entrySet().iterator();
			while(inIter.hasNext()) {
				Entry<String,BookDto> a = inIter.next();
				BookDto b = a.getValue();
				if(a.getKey().equals(key)) {
					System.out.println("📖 선택한 도서 정보 : " + b.getTitle() + " / " + b.getAuthor());
				}
			}
		}
		
	}
}
//## 📘 연습문제3) Collection Framework + 중첩 HashMap
//패키지명 : com.company.basic014_ex
//클래스명 : MapEx003
//
//### 요구사항
//1. 중첩 Map 구조 만들기  
//   - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
//   - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
//   - 두 번째 Key : ISBN  
//   - Value : BookDTO 객체  
//
//2. DTO 클래스  
//   java
//   class BookDTO {
//       private String title;
//       private String author;
//       // 생성자, getter/setter, toString()
//   }
//   
//
//3. 출력하기  
//   - 각 지점별 도서 목록 출력  
//
//4. 사용자 입력받기  
//   - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  
//
//### 📌 실행 예시 
//=== 도서관 전체 목록 ===
//📚 서울점
//978-11111 | 자바의 정석 | 남궁성
//978-22222 | 파이썬 기초 | 홍길동
//---------------------
//📚 부산점
//978-33333 | 자료구조와 알고리즘 | 이순신
//978-44444 | 파이썬 심화 | 홍길동
//---------------------
//지점 이름 입력> 서울점
//ISBN 입력> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동