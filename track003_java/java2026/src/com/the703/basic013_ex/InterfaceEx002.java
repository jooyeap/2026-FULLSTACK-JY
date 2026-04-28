package com.the703.basic013_ex;

//연습문제2)  
//패키지명 :  com.the703.basic013_ex;
//클래스명 :  InterfaceEx002
//
//
//1. Driver 클래스를 작성하시오.  
/*
	M > V < C  d??
*/
//2. 주어진조건
interface Vehicle { public void run();  }

class MotorCycle implements Vehicle {
   @Override public void run() { System.out.println("오토바이가 달립니다."); }
   public void helmet() { System.out.println("헬맷을 착용합니다.");}
}
class Car implements Vehicle {
   @Override public void run() { System.out.println("자동차가 달립니다."); }
}

class Driver{ 
	void drive(Vehicle a) {
		if(a instanceof MotorCycle) { ((MotorCycle)a).helmet();}
		a.run();
	} 
}

//3. 메인화면
public class InterfaceEx002{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
  //리턴값     메서드명(파라미터)
      driver.drive(car);
      driver.drive(mo);
   }
}

//4. 실행화면
//자동차가 달립니다.
//오토바이가 달립니다.