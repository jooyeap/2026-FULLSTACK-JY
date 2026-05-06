package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class BookDto{
	private String title;
	private String author;
	public BookDto(String title, String author) { super(); this.title = title; this.author = author; }
	public BookDto() { super();  }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
}

public class MapEx002 {
	public static void main(String[] args) {
		String key = "";
		Map<String, BookDto> map = new HashMap<>();
		map.put("978-11111", new BookDto("자바의 완성", "가길동"));
		map.put("978-22222", new BookDto("파이썬 기초", "홍길동"));
		map.put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));
		
		System.out.println("===============================");
		System.out.println("ISBN\t  TITLE\t\tAUTHOR");
		System.out.println("===============================");
		
		for(Entry<String, BookDto> a : map.entrySet()) {
			BookDto b = a.getValue();
			System.out.println(a.getKey()+" | "+b.getTitle()+" | "+b.getAuthor());
			System.out.println("-------------------------------");
		}
		
		System.out.println("도서 정보를 제공중입니다.");
		System.out.print("ISBN을 입력하세요 > ");
		Scanner sc = new Scanner(System.in);
		key = sc.next();
		
		Iterator<Entry<String,BookDto>> iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
			Entry<String,BookDto> a = iter.next();
			BookDto b = a.getValue();
			if(a.getKey().equals(key)) {
				System.out.println("📖 선택한 도서 정보: "+b.getTitle()+" / 저자: "+b.getAuthor());
				break;
			}
		}
	}
}
//연습문제2)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : MapEx002
//1. MAP 만들기
//KEY         VALUE
//978-11111   new BookDto("자바의 완성" , "가길동")
//---------------------
//978-22222   new BookDto("파이썬 기초" , "홍길동")
//---------------------
//978-33333   new BookDto("자료구조와 알고리즘" , "이순신")
//
//Map<String, BookDTO> map = new HashMap<>();
//
//
//2 다음과 같이 문제풀기
//2-1. BookDto 만들기   {    private String title;  private String author;}
//2-2. 다음과 같이 출력
//2-3. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//ISBN        TITLE        AUTHOR
//==============================
//978-11111 | 자바의 완성 | 가길동
//------------------------------
//978-22222 | 파이썬 기초 | 홍길동 
//------------------------------
//978-33333 | 자료구조와 알고리즘 | 이순신 
//------------------------------
//도서 정보를 제공중입니다
//ISBN을 입력하세요> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
