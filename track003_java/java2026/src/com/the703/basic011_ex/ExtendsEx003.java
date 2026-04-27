package com.the703.basic011_ex;

// 1. 클래스는 부품객체
// 2. 부품객체 (상태 와 행위)
// 3. static(공용), final(수정 X), public(접근)
// 4. 부품객체 재사용 ( extends, 오버로딩, 오버라이딩, )

/*
	Object
	  ↑
	 Papa	{int brain / sing(이문세 - 붉은 노을) } 		- 생성자 : default, field
	  ↑
	 Son	{int money / @Override sing(빅뱅 - 붉은 노을) }
	 
	 super > 부모 클래스
*/

class Papa extends Object{
	int brain;
	void sing() { 
		System.out.println("이문세 - 붉은 노을");
		
	}
	
	public Papa() { super(); }
	public Papa(int brain) { super(); this.brain = brain; } // Papa
}

class Son extends Papa{
	int money;
	@Override	// 오버라이딩
	void sing() { 
		System.out.println("빅뱅 - 붉은 노을");
		System.out.println("IQ > " + brain + "\nMoney > " + money);
	}
	// 생성자 오버로딩
	public Son() { super();  }
	public Son(int brain) { super(brain);  }
	// public Son(int money) { super(brain); } 바로위에 파라미터 int brain 자료형이 같아 오류발생
	public Son(int brain, int money) {
		super(brain);
		this.money = money;
	}
}
/////////////////////////////////////////////////////

public class ExtendsEx003 {
	public static void main(String[] args) {
		Son myson = new Son(148,100);
		myson.sing();
	}
}
/*
----------------------------------------------------------------------------------
Son myson = new Son(148,100); -> Papa(brain)  this.money = money;
----------------------------------------------------------------------------------
[method] Papa.class , Son.class , ExtendsEx003.class
----------------------------------------------------------------------------------
[heap]														[stack] 	
   Object()		  { 	#3							}#4
	 ↑										↓
	Papa(148)	  {brain / sing #2 -> brain=148/sing}#5
	 ↑										↓
1번지 Son(148,100) {money / @sing #1 -> money=100/@sing }#6	<- myson [1번지]
															main

*/
