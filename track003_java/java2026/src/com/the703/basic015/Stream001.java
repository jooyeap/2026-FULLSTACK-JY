package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream001 {
	public static void main(String[] args) {
		
		// 배열
		Integer[] arr = {1,2,3,4,5};
		
		// 리스트
		List<Integer> list = Arrays.asList(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(list);
		
		System.out.println();
		// 1. Stream (흐름)
		Stream<Integer> sarr = Arrays.stream(arr); // Stream<Integer>
		Stream<Integer> slist = list.stream();		// Stream<Integer>
		
		// 2. 처리
		// (t) -> {} accept 
		// void java.util.function.Consumer.accept( T t )
		
		//sarr.forEach( (t) -> {System.out.println(t);} );
//		sarr.forEach( t -> System.out.print(t));
		sarr.forEach( System.out::print );
		
		System.out.println();
		//slist.forEach( (t) -> System.out.print(t));
//		slist.forEach( t -> System.out.print(t));
		slist.forEach( System.out::print);
	}
}
/*
  
 	Stream - 데이터 종류에 상관없이 같은 방식(흐름)으로 처리
 
*/
