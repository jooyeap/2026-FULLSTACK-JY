package com.the703.basic013_ex;

class Account {
	//인스턴스 변수 this heap area , new 생성자
    private int balance;
    //클래스 변수 공유, static method area
    public static int accountCount=0;
    //인스턴스 변수
    public final int id;              

	public Account(){this.id = ++accountCount;}
    public Account(int id, int balance) {
        this();
        this.balance = balance; 
    }

    // getter/setter
    public int getBalance() { return balance; }
    public void deposit(int amount) { balance += amount; }
    public void withdraw(int amount) { balance -= amount; }

    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + balance + "]";
    }
}

public class Repeat002_oop {
    public static void main(String[] args) {
        Account a1 = new Account(1, 100);
        Account a2 = new Account(2, 200);

        a1.deposit(50);
        a2.withdraw(30);

        System.out.println(a1);  
        System.out.println(a2); 

        System.out.println("총 계좌 수 = " + Account.accountCount); 
        System.out.println("a1.id = " + a1.id); 
        System.out.println("a2.id = " + a2.id); 
    }
}

/*
  
 1. 클래스는 부품객체
 2. 상태(멤버변수: 클래스변수, 인스턴스변수)와 행위(멤버함수: 클래스메서드, 인스턴스메서드) 
 
📝 문제: OOP 개념(2) — 캡슐화 / static / final
Q1. 캡슐화(Encapsulation)란 무엇이며, 위 코드에서 어떻게 구현되었는지 설명하시오.
	
	다른곳에서 접근해서 사용하지 못하게 막음
	
	선언 : private int balance
	접근 : getter,setter  

    // getter/setter
    public int getBalance() { return balance; }
    public void deposit(int amount) { balance += amount; }
    public void withdraw(int amount) { balance -= amount; }
    위 메서드

Q2. 접근제어자의 범위를 넓은 것부터 좁은 것까지 순서대로 쓰시오.

	public > protected > default(package) > private
	어디서든지 > 상속 > 패키지안에서만 > 클래스안에서만
	Q3. static 키워드의 의미를 메모리 구조와 연결지어 설명하고, 위 코드에서 어떤 변수에 적용되었는지 쓰시오.
	
	모든객체에서 공유
	method area 저장 - 객체생성(new)과 관계없이 접근 가능 , 클래스명.변수, 클래스명 메서드
	
	static 키워드가 붙은 멤버변수,메서드들은 메모리 구조에서 method영역에 처음부터 할당되어
	객체생성을 안해도 접근하기가 가능해 다양하게 사용가능함
	public static int accountCount=0; 
	
	접근 : Account.accountCount

Q4. final 키워드의 의미를 설명하고, 위 코드에서 어떤 변수에 적용되었는지 쓰시오.

	final 키워드는 변경,상속을 부정하는 키워드 / 클래스 > 상속x , 변수 > 상수 , 메서드 > 오버라이드x
	public final int id;    
	
	Q5. Account.accountCount의 값은 얼마인가? 왜 그렇게 되는지 설명하시오.
	클래스변수
	2, 위 코드중 Account클래스의 필드생성자중 id값은 fianl로 수정이 불가능 하므로
	기본 생성자에 있는 this.id = ++accountCount; 를 이용하여 아이디 값을 하나씩 증가시킴
	때문에 main 클래스에서 Account 클래스생성자가 2번 호출됐으므로 ++ 증감식으로 인해
	Account.accountCount 값은 2가됨
	  
Q6. a1.id와 a2.id의 값은 각각 얼마인가?
	1,2
	이유는 위 5번 문제와 유사

Q7. 출력 결과를 쓰시오.

	System.out.println(a1); -> [ id= 1, balance= 150 ]
    System.out.println(a2); -> [ id= 2, balance= 170 ]

    System.out.println("총 계좌 수 = " + Account.accountCount);  -> 총 계좌 수 = 2
    System.out.println("a1.id = " + a1.id);  -> a1.id = 1
    System.out.println("a2.id = " + a2.id);  -> a2.id = 2

Q8. static 메서드와 인스턴스 메서드의 차이를 설명하시오.

	static - 클래스에 속함
	1) 공용으로 사용가능
	2) 클래스명.메서드,함수명 으로 호출
	3) method area 에 할당
	인스턴스 - 객체에 속함
	1) 생성자를 통해 객체생성 해야 사용가능
	2) 참조변수명.메서드,함수명 으로 호출
	3) new 생성자로 호출되어 heap area 에 할당
	
Q9. final 키워드가 변수, 메서드, 클래스에 각각 적용될 때 의미를 설명하시오.

	변수 > 상수
	메서드 > 오버라이드 불가능
	클래스 > 상속 불가능
	
Q10. 캡슐화의 장점은 무엇인가?
	외부에서 접근하면 안되는 멤버함수,변수에 접근하는것을 막아줌
	유지보수가 용이함

*/