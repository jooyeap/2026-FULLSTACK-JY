package com.the703.basic014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
	public static void main(String[] args) {
		// ArrayList 와 LinkedList의 차이점
		// ArrayList : 배열기반으로 동작 , 검색 속도 빠름, 삽입/삭제 느림 -> 검색 할때
		// LinkedList : 노드기반 연결구조 , 검색 속도 느림, 삽입/삭제 빠름 -> 삽입/삭제 할때
		
		int size = 100000;
		// 1. ArrayList 테스트
		List<Integer> arrayList = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i=0; i<size; i++) {arrayList.add(i);}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList 삽입시간 : " + (end-start) + "ms");
		
		// 2. LinkedList 테스트
		List<Integer> linkedList = new LinkedList<>();
		start = System.currentTimeMillis();
		for(int i=0; i<size; i++) {linkedList.add(i);}
		end = System.currentTimeMillis();
		System.out.println("LinkedList 삽입시간 : " + (end-start) + "ms");
		
		// 3. 중간삽입 테스트
		start = System.currentTimeMillis();
		for(int i=0; i<size; i++) {arrayList.add(size/2,i);}	// 삽입되는 위치, 값
		end = System.currentTimeMillis();
		System.out.println("ArrayList 중간삽입시간 : " + (end-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0; i<size; i++) {linkedList.add(size/2,i);}
		end = System.currentTimeMillis();
		System.out.println("LinkedList 중간삽입시간 : " + (end-start) + "ms");
	}
}
