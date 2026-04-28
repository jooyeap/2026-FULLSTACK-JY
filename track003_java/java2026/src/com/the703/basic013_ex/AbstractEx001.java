package com.the703.basic013_ex;

//연습문제1)
//패키지명 : com.the703.basic013_ex 
//클래스명 : AbstractEx001.java 
//주어진조건 : 
//1) 상속도
//           Object
//             ↑
//            Robot {   abstract charge() , move() , speak() }
//   ↑          ↑               ↑ 
//CleaningRobot  SecurityRobot   CookingRobot   
//{@charge() ,    {@charge() ,    {@charge() ,
// @ move() ,     @move() ,           @move() , 
// @ speak() }}         @speak() }}          @speak() }}
//
//2)main

abstract class Robot{
	String name;
	abstract void charge();
	abstract void move();
	abstract void speak();
}

class CleaningRobot extends Robot{
	
	@Override void charge() {System.out.print(" 충전 중... 배터리 ");}
	@Override void move() {System.out.print(super.name);}
	@Override void speak() {System.out.println(": 먼지를 제거합니다!");}
}

class SecurityRobot extends Robot{
	
	@Override void charge() {System.out.print(" 태양광 충전 중... 배터리 ");}
	@Override void move() {System.out.print(super.name);}
	@Override void speak() {System.out.println(": 이상 없음. 안전 확보!");}
}

class CookingRobot extends Robot{
	
	@Override void charge() {System.out.print(" 인덕션 충전 중... 배터리 ");}
	@Override void move() {System.out.print(super.name);}
	@Override void speak() {System.out.println(": 오늘의 메뉴는 파스타입니다!");}
}

public class AbstractEx001 {
   public static void main(String[] args) {
      //Robot robot  = new Robot();  // Q1.why? 오류이유? 추상적 클래스는 구현부가 없어 생성자로 생성(초기화)불가
      System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
      Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
      int[] levels = { 50, 70, 95 };
      int count = 0;
      for( Robot a : bots) {
    	  if(count == 0) { a.name = "Robo"+ (count+1) +" 청소로봇"; }
    	  else if(count == 1) {a.name = "Robo"+ (count+1) +" 경비로봇";}
    	  else if(count == 2) {a.name = "Robo"+ (count+1) +" 요리로봇";}
    	  a.move(); a.charge(); System.out.println(levels[count]+"%");
    	  a.move(); a.speak();
    	  count++;
      }
   }
}
// 
//출력화면 :  
//--- 로봇 배열 시뮬레이션 ---
//Robo1 청소로봇 충전 중... 배터리 50%
//Robo1 청소로봇: 먼지를 제거합니다!
//Robo2 경비로봇 태양광 충전 중... 배터리 70%
//Robo2 경비로봇: 이상 없음. 안전 확보!
//Robo3 요리로봇 인덕션 충전 중... 배터리 95%
//Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!