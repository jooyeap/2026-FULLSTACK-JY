package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream002 {
	public static void main(String[] args) {
		
		 Integer[]     arr  = {1,2,5,4,3,4,5,1,2,1,1,1,1,1,1};   
	     List<Integer> list = Arrays.asList(arr);
	     
	     // 1. stream
	     Stream<Integer> sarr = Arrays.stream(arr);
	     Stream<Integer> slist = list.stream();
	     
	     // 2. 중간연산
	     	     
	     // (t) -> {return} Predicate 판단용도
	     // filter -> boolean java.util.function.Predicate.test( T t ) -> Predicate
	     sarr.filter( a -> a%2 != 0) // 홀수만 필터링
	     .distinct() // 중복 제거 153
	     .sorted() // 정렬 135
	     .limit(2) // ()개 제한 13
	     .skip(1) // ()개 스킵 3
	     // (t) -> {}		Consumer 받는용도
	     // forEach -> void java.util.function.Consumer.accept( T t ) -> Consumer
	     .forEach(System.out::print); // -> 최종연산
	     
	     System.out.println();
	     
	     slist.filter( a -> a%2 == 0) // 짝수만 필터링 2442
	     	  .distinct() // 중복 제거 24
	     	  .sorted() // 정렬 24
	     	  .limit(2) // ()개 제한 24
	     	  .skip(1) // ()개 스킵 4
	     	  .forEach(System.out::print); // -> 최종연산
	     
	     // 3. 최종연산 .forEach
	     
	}
}