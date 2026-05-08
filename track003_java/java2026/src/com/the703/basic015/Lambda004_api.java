package com.the703.basic015;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Lambda004_api {
	public static void main(String[] args) {
		
		// (t) -> {} accept 받는용도
		// void java.util.function.Consumer.accept( T t )
		//Consumer<String> consumer = (t)->{ System.out.println("hihi " + t); };
		
		// ver.1 람다식 정리
		Consumer<String> consumer = t -> System.out.println("hihi " + t); 
		// ver.2 참조형 표현
		Consumer<String> consumer1 = System.out::println;
		
		consumer.accept(":)");
		consumer.accept(":p");
		consumer1.accept(":(");
		System.out.println();
		
		// () -> {return}  get 주는용도
		// T java.util.function.Supplier.get()
	  	//Supplier<String> supplier = ()->{return "hihihi";};
	  	
	  	// ver.1 람다식 정리
	  	Supplier<String> supplier = () -> "hoho";
	  	
	  	System.out.println(supplier.get());
	  	System.out.println();
	  	
	  	// (t) -> {return boolean 타입} test 판단용도
	  	// boolean java.util.function.Predicate.test( T t )
	  	//Predicate<Integer> predicate = (t) -> {return t<0;};
	  	
	  	// ver.1 람다식
	  	Predicate<Integer> predicate = t -> t<0;
	  	
	  	System.out.println(predicate.test(10));
	  	System.out.println(predicate.test(-10));
	  	System.out.println();
	  	
	  	// (t) -> {return} apply 처리용도
	  	// R java.util.function.Function.apply( T t )
	   	//Function<String,Integer>  function = (t) -> { return Integer.parseInt(t);};
	   	
	  	// ver.1 람다식
	  	Function<String,Integer> function = t -> Integer.parseInt(t);
	  	
	  	// ver.2 참조형
	  	Function<String,Integer> function1 = Integer::parseInt;
	  	
	   	System.out.println(function.apply("10")+ 3); // 13
	   	System.out.println(function1.apply("12")+3); // 15
	   	System.out.println();
	   	
	   	// (left,right) -> {return int} appltAsInt 연산용도
	   	//int java.util.function.IntBinaryOperator.applyAsInt( int left, int right )
	   	//IntBinaryOperator operator = (a,b)->{return a>b ? a:b;};
	   	
	   	// ver.1 람다식
	   	IntBinaryOperator operator = (a,b) -> a>b? a:b;
	   	
	   	System.out.println(operator.applyAsInt(10, 3));
	   	System.out.println(operator.applyAsInt(3, 10));
	   	
	}
}


/*
  	자바 api 함수형 인터페이스
  	
  	1.   Consumer  받는용도 
  	(t) -> {} accept 받는용도
	void java.util.function.Consumer.accept( T t )
	Consumer<String> consumer = (t)->{ System.out.println("hihi " + t); };
	
  	2.   Supplier  제공용도
  	() -> {return}  get 주는용도
	T java.util.function.Supplier.get()
  	Supplier<String> supplier = ()->{return "hihihi";};
  	
  	3.   Predicate 판단용도
  	(t) -> {return boolean 타입} test 판단용도
  	boolean java.util.function.Predicate.test( T t )
  	Predicate<Integer> predicate = (t) -> {return t<0;};
   	
   	4.   Function  처리용도
   	(t) -> {return} apply 처리용도
  	R java.util.function.Function.apply( T t )
   	Function<String,Integer>  function = (t) -> { return Integer.parseInt(t);};
   	
   	5.   Operator  연산용도
   	(left,right) -> {return int} appltAsInt 연산용도
   	int java.util.function.IntBinaryOperator.applyAsInt( int left, int right )
   	IntBinaryOperator operator = (a,b)->{return a>b ? a:b;};
   	
 */