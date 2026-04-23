package com.the703.basic010_ex;

// 1. 클래스는 부품객체
// 2. 상태(멤버변수) 와   행위(멤버함수) 를 가짐
//       ㄴ 인스턴스변수,클래스변수/ㄴ 인스턴스 함수, 클래스 함수        


//연습문제1)  final
//패키지명 : com.company.basic010_ex
//클래스명 : FinalEx
//다음코드에서 오류나는 부분을 찾아 주석달고 이유를 적으시오.
class User002 {
   final String nation = "Korea";   
   final String jumin;   
   String name;

   public User002() { jumin="00000"; } 
   public User002(String jumin, String name) {
      this.jumin = jumin;
      this.name = name;
   }
}
public class ClassFinalEx001 {
   public static void main(String[] args) {
      User002 user1 = new User002("123456-1234567", "아이유");
      System.out.println(user1);   
      
      // nation, jumin 에 final이 붙어 상수이므로 값을 변경할 수 없음
      //user1.nation = "USA";      
      //user1.jumin  = "123123-1234321";
      
      user1.name = "IU"; 
      System.out.println(user1);   
   }
}

