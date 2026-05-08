package com.the703.basic015;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {
		Integer[]  ages = {17 , 21, 26 , 45, 18};
		
		// Ex1. 짝수만 출력
		Stream<Integer> sages = Arrays.stream(ages);
		
		sages.filter( a -> a%2 == 0).forEach(System.out::print);
		System.out.println();
		
		// Ex2. 평균값 처리 (숫자들을 더해서 연산)
		// (value) -> {return}
		// int java.util.function.ToIntFunction.applyAsInt( T value )
		// Stream은 1회용이기 때문에 한번 사용하면 다시 초기화시켜줘야 오류안남
		sages = Arrays.stream(ages); System.out.println();
		
		// 집계 연산
		// average -> 평균 / max -> 최대 / min -> 최소 / sum -> 합 / count -> 개수
		double aver = sages.mapToInt(age->age) // IntStream으로 변환
						   .average()			// 평균계산
						   .orElse(0.0); 		// 값이 없으면 ()로 반환
		System.out.println(aver);
		
		// Ex3. 제일 나이가 많은 사람
		sages = Arrays.stream(ages); System.out.println();
		
//		sages.sorted().skip(ages.length-1).forEach(System.out::print);
		
		int max = sages.mapToInt(a->a).max().orElse(-1);
		System.out.println(max);
		
		// Ex4. 나이 정렬해서 리스트로
		sages = Arrays.stream(ages); System.out.println();
		
		// java.util.stream.Collector<T, A, R>
		List<Integer> a = Arrays.stream(ages)
						  .sorted()
						  .collect( Collectors.toList());
		System.out.println(a);
		
		// Ex5. 20살 이상만 필터링해서 리스트로 수집, 내림차
		sages = Arrays.stream(ages); System.out.println();
		
//		List<Integer> b = sages.filter( c -> c>19)
//							.sorted( (i,j) -> j.intValue() - i.intValue())
//							.collect( Collectors.toList());
		
		List<Integer> b = sages.filter( c -> c>19)
						.sorted( Comparator.reverseOrder())
						.collect( Collectors.toList());
		
		System.out.println(b);
		
	}
}
