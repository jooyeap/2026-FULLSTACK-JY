package com.the703.basic010_ex;

import java.util.Scanner;

class Card{
	int cardNum;
	boolean isMembership;
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("카드 번호 > ");
		cardNum = sc.nextInt();
		System.out.print("멤버쉽 유무 > ex) Y/N");
		isMembership = sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y' ? true : false; 
	}
	void show() {
		System.out.println("~~~~");
	}
	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]";
	}
	
}

public class ClassEx005 {

	public static void main(String[] args) {
		
		Card c1 = new Card();
		System.out.println(c1);
	}

}

////////////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
-------------------------------------------------------------------------------
[METHOD:정보]			Card.class ClassEx005.class
-------------------------------------------------------------------------------
[HEAP:동적]      						  	 	|  [STACK:지역]

1번지:{channel, volume, show(), input()}		<- t1[1번지]
1번지:{channel, volume, show(), input()}		<- t2[2번지]
main #2
-------------------------------------------------------------------------------
*/
///////////////////////////////////////////////////////////////////////////////

//연습문제3)  class
//패키지명 : com.the703.basic010_ex
//클래스명 :  ClassEx005
//-- 생성자 작성하시오.
//class Card{
//   //상태-멤버변수  : 채널/볼륨 int cardNum; boolean  isMembership;   
//   //행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
//}
//public class ClassEx005{
//   public static void main(String[] args) {
//   Card  c1= new Card(); 
//   System.out.println(c1);  
//   }
//}
//
//출력내용 :
//Card[cardNum=0, isMembership=false]

