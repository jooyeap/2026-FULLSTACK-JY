package com.the703.basic013_ex;

class Parent {
    int x = 100;
    void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
    int x = 200;
    void method() { System.out.println("Child method"); }
}

public class Repeat001_OOP {
    public static void main(String[] args) {
    	/*
    	  
    	 method area (정보,static,final)
    	 ㄴ Parent.class, Child.class, Repeat001_oop.class#1
    	 heap						stack
    	  1번지) < new의 역할 #3		<- p[1번지]#5
    	  Parent{x=100,method()}	Child() -> Parent() -> Object() / Child()의 역할#4 
    	  							[main]#2
    	  							
    	  #1 > 클래스
    	  #2 > main 클래스
    	  #3 > heap 영역에 생성자로 객체,주소값 생성
    	  #4 > 초기화 과정 자식클래스 부터 상위 부모클래스 방향으로 열리고 다시내려오면서 닫힘
    	  #5 > stack영역에 참조값 생성, 번지수 전달
    	*/
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}
/*
## 📝 문제: OOP 개념(1)

다음 코드를 보고 질문에 답하시오.
Q1. OOP란 무엇인가?
객체 지향 프로그래밍 / Object Oriented Programming / 틀 기반 프로그래밍 / 부품객체(클래스)를 구성(조립)해서 프로그래밍을 구성

어떠한 부품객체들( 클래스 ) 들을 사용하여 결과물을 만들어냄

클래스는 부품객체, 클래스는 상태(속성:멤버변수)와 행위(멤버함수,메서드)를 갖는다

Q2. OOP의 핵심 개념은 무엇인가?
캡슐화 - private , 외부에서의 접근을 제한
다형성 - 하나의 타입으로 여러개의 특징을 관리 
상속 - extends ,  클래스의 재사용
추상화 - abstracts , interface , 핵심적인 기능만 단순화하는 설계 

Q3. 상속도를 그리시오.
Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.
	
	Object
	↑
	Parent	{ int x=100; method() }
	↑
	Child 	{ int x=200, @method() } - {Parent 의 멤버변수,메서드}

Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
	객체 생성,주소 -> new
	초기화 -> Child()
	참조값 -> p
	
Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
	int x = 100; > 인스턴스 변수 / heap area , new,생성자와 관련 있음 , this
	method() = > 인스턴스 메서드 / heap area , ~~
	
Q7. 출력 결과를 쓰시오.

- p.x의 값은?  100
- p.method() 실행 시 어떤 메서드가 호출되는가?  Child method
- c.x의 값은?  200
- c.method() 실행 시 어떤 메서드가 호출되는가? Child method

Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
상속시 부모 클래스의 메서드를 자식클래스에서 재정의

나(자식클래스)에게 맞는 방식으로 부품들을 재사용 하겠다
Child 클래스의 method()가 오버라이딩 되어있음

Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.
	
	1) new : [1번지] Child{ int x, method() 생성
	2) Child() : 객체들을 초기화하고 주소값을 줌
	
	타입 사용할 수 있는 범위 : Child{ x=200, method()} - {x-100, method()}
	생성자 호출 순서 : Child() > Parant() > Object()
	객체 생성 순서 : Child() < Parant() < Object()
*/

 
