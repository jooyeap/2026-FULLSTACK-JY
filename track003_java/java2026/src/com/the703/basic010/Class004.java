package com.the703.basic010;

// 1. 클래스는 부품객체
// 2. 클래스의 상태(멤버변수)와 행위(멤버함수)를 갖는다

/*
  	Object				  2) Object() {					} 3) 객체 틀 마무리
  	  ↑
  	Product{name , price} 1) Product() { 여기까지 1번| super(); name=null, price=0 } 4) 
 */
class Product extends Object{ // 상속을 받을게, Object ( 클래스의 기본틀 ) , Object 생략가능
	// 인스턴스 변수
	String name;
	int price;
	
	public Product() { super(); } // super (부모) - Object()
	public Product(String name, int price) { super(); this.name = name; this.price = price; } // this(각각의 인스턴스 변수)
	@Override public String toString() { return "Product [name=" + name + ", price=" + price + "]"; }
	
}

public class Class004 {
	public static void main(String[] args) {
		Product p1 = new Product(); // 1) new 객체생성 2) 생성자-초기화 3) p1 주소갖기 [1번지]
		System.out.println(p1); // p1(1번지) -> Product [name=null, price=0]
		
		Product p2 = new Product("아이폰 17", 100); // 1) new 객체생성 2) 생성자-초기화 3) p2 주소갖기 [2번지]
		System.out.println(p2); // p2(2번지) -> Product [name=null, price=0]
		// this. << 는 각각의 n번지의 변수 를 뜻함 ex) p2의 this.name >> 2번지에있는 name
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Product.class(설계도) , Class004.class #1
------------------------------------
[HEAP:동적]           		 		|  [STACK:지역]
1번지 Product{name=null,price=0}		<- p1[1번지에있는 정보?]
										main #2
------------------------------------
*/
//////////////////////////////////////////////////////

//■ OOP
//1.  생성자   - new 연산자에 의해 호출 [초기화] 담당
//
//2. 기본생성자( 디폴트생성자 )
//- 모든클래스에 생성자가 반드시 존재
//- 생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
//- 개발자가 선언시 컴파일러가 자동생성(하지않음)
//
//3. 생성자형식
//class A{
//   public    A(                 ){}   //기본생성자(디폴트생성자)
//   public    A(String name){}   //파라미터, 알규먼트가 있는 생성자.
//}
//1)  리턴값 (X)
//2)  클래스명과 (동일해야함) 