package com.the703.basic013_ex;

//연습문제5)  
//패키지명 :  package com.company.java013_ex;
//클래스명 :  public class InterfaceEx004
//
//1. Barista 클래스를 작성하시오.  
//2. 주어진조건
interface Drink { public void serve(); }
class Coffee implements Drink {
   @Override public void serve() { System.out.println("커피가 준비되었습니다."); }
   public void addSugar() { System.out.println("커피에 설탕을 넣습니다."); }
}
class Tea implements Drink {
   @Override public void serve() { System.out.println("차가 준비되었습니다."); }
   public void addLemon() { System.out.println("차에 레몬을 넣습니다."); }
}
class Juice implements Drink {
   @Override public void serve() { System.out.println("주스가 준비되었습니다."); }
   public void addIce() { System.out.println("주스에 얼음을 넣습니다."); }
}

class Barista {
	void make(Drink a) {
		if( a instanceof Coffee) { ((Coffee) a).addSugar();}
		else if( a instanceof Tea) { ((Tea) a).addLemon();}
		else if( a instanceof Juice) {((Juice) a).addIce();}
		a.serve();
	}
}

//3. 메인화면
public class InterfaceEx004 {
   public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);
      Barista barista = new Barista();

      // 배열에 객체들을 담아둠
      Drink[] menu = { new Coffee(), new Tea(), new Juice() };

      while (true) {
         System.out.println("=== 카페 메뉴판 ===");
         System.out.println("1. 커피");
         System.out.println("2. 차");
         System.out.println("3. 주스");
         System.out.println("0. 종료");
         System.out.print("선택: ");
         int choice = sc.nextInt();

         if (choice == 0) {
            System.out.println("카페 주문을 종료합니다.");
            break;
         }

         if (choice >= 1 && choice <= menu.length) {
            Drink drink = menu[choice - 1]; // 배열에서 꺼내오기
            barista.make(drink);
         } else {
            System.out.println("잘못된 선택입니다.");
         }
         System.out.println();
      }
      sc.close();
   }
}

//4. 실행화면
//=== 카페 메뉴판 ===
//1. 커피
//2. 차
//3. 주스
//0. 종료
//선택: 1
//커피가 준비되었습니다.
//커피에 설탕을 넣습니다.
//
//선택: 2
//차가 준비되었습니다.
//차에 레몬을 넣습니다.
//
//선택: 3
//주스가 준비되었습니다.
//주스에 얼음을 넣습니다.
//
//선택: 0
//카페 주문을 종료합니다.

