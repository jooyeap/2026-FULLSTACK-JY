package com.the703.basic012_ex;


//연습문제1)  다형성
//패키지명 : com.company.basic012_ex
//클래스명 : PolyEx001 
//다음과 같이 코드를 작성하시오.
// Q1. 상속도 그리기
/*
		Object  {#3 -->							}#4
		 ↑
		Papa	{money, sing()  #2/money=10000,	}#5
		 ↑
		Son		{money, @sing() #1/money=1500,	}#6
*/		

// Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
class Papa extends Object{  
   int money = 10000;     
   public Papa() { super(); }
   public void sing() {  System.out.println("GOD-거짓말");  }
}// end class

class Son extends Papa{ 
   int money = 1500;
   public Son() { super(); }
   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
} // end class

public class PolyEx001 {
   public static void main(String[] args) { 
	  // 부모 <- 자식 ( 업 캐스팅 )
      Papa mypapa = new Son();    
      // Q3. Papa mypapa 의미?
      // 1) 1번지 mypapa { money=10000,sing() }
      // Q4. 인스턴스화한 실제 메모리 빌려온그림
      // 2) new Son();
      // 		Son() -> Papa -> Object
      // 1번지 : {1500, @sing() }-> {10000, sing() }-> { } // 반대로 닫히고
      // 3) mypapa{10000, sing} = [1번지] {1500,@sing} - {10000,sing}
      
      /*
        	Q5에서 10000이 출력
        	ㄴ mypapa에 맨 처음 할당된 money는 10000임
        	  아래 오버로딩같이 뭐가 된게 아니니까 제일 처음된게 출력되는것?
        	  때문에 Q7같이 (Son)을 적어서 1500을 가져와서 출력하는것
        	Q6 출력
        	ㄴ sing은 자식에서 오버드라이브 되어있으니까 출력이 @sing이 되는게 맞음
      */
      System.out.println(mypapa.money); // Q5.  출력   
      mypapa.sing();  //Q6. 출력 
       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.  
      System.out.println(((Son)mypapa).money);
   }
}
