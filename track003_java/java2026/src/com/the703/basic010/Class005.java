package com.the703.basic010;

// 1. 클래스는 부품객체
// 2. 부품은 상태(멤버변수)와 행위(멤버함수)를 갖는다

class Farm{
	// 상태(멤버변수)
	
	// 인스턴스 변수 - heap area - new 랑 관련있음 / 생성자 호출
	String name;
	int age;
	
	// 클래스 변수 - method area - new, 생성자와 관련없음
	// 명시적초기화
	static String FarmName = "(주) 동물농장"; // 클래스 변수 -> 클래스명.변수명
	static String FarmBoss;
	static int FarmNum;
	static { FarmNum = 2; FarmBoss = "신동엽"; } // 초기화 블록
	
	// 행위(멤버함수)
	
	// 클래스 메서드 / 접근법 -> 클래스명.메서드 / method area - static
	static void numPlus() { FarmNum++; }
	
	// 인스턴스 메서드 / heap area - new , 생성자
	void show() {
		System.out.println("\n\n::::::::::::::::::");
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
		System.out.println("::동물농장 인원 : " + Farm.FarmNum);
	}
}

public class Class005 {
	public static void main(String[] args) {
		System.out.println("\n\n0. 동물농장");
		System.out.println("::회사이름 > " + Farm.FarmName);
		System.out.println("::회사사장 > " + Farm.FarmBoss);
		System.out.println("::회사인원 > " + Farm.FarmNum);
		
		System.out.println("\n\n1. 동물식구 - this -> 각각");
		
		Farm cat = new Farm(); // new 객체 생성 -> Farm() 초기화 -> cat번지
		cat.name = "애옹"; cat.age = 3; Farm.numPlus(); cat.show();
		Farm dog = new Farm();
		dog.name = "맘무"; dog.age = 7; Farm.numPlus(); dog.show();
		//dog.numPlus(); -> 타입이 static이 아니라 클래스명으로 접근해야함
		
	}
}
/*
 	초기화 순서	 		기본값으로 초기화		명시적초기화	초기화블록		생성자
 	FarmName		null			(주)동물농장	(주)동물농장 	x
	FarmBoss		null			null		2			x
	FarmNum			0				0			신동엽		x
	-------------------------------------------------------------
	cat/name,age	null 0			null 0		null 0		null 0
	dog/name,age	null 0			null 0 		null 0		null 0
*/
////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------
[METHOD:정보, static, final] Farm.class , Class005.class
	Farm.FarmName, Farm.FarmBoss, Farm.FarmNum , Farm.numPlus()
------------------------------------------------------------------------
[HEAP:동적]           		 		|  [STACK:지역]

2번지{name, age, show()} 				 <- dog [2번지]
1번지{name, age, show()} 				 <- cat [1번지]
      

										main #2
------------------------------------------------------------------------
*/
////////////////////////////////////////////////////////////////////////