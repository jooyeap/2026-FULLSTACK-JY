package com.the703.basic010_ex;

import java.util.Scanner;

class TV{
	String channel;
	int volume;
	void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("channel 입력 > ");
		channel = sc.next();
		System.out.println("\nvolume 입력 > ");
		volume = sc.nextInt();
	}
	void show() {
		System.out.println(channel +"   "+ volume);
	}
	
	public TV(String channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}
	public TV() {
		super();
	}
	
}

public class ClassEx004 {
	public static void main(String[] args) {
		TV t1 = new TV("JDBC", 8);
		t1.show();
		TV t2 = new TV();
		t2.input();
		t2.show();
	}
}

////////////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
-------------------------------------------------------------------------------
[METHOD:정보]		TV.class ClassEx004.class #1
-------------------------------------------------------------------------------
[HEAP:동적]      						  	 	|  [STACK:지역]

1번지:{channel, volume, show(), input()}		<- t1[1번지]
1번지:{channel, volume, show(), input()}		<- t2[2번지]
												main #2
-------------------------------------------------------------------------------
*/
///////////////////////////////////////////////////////////////////////////////

//연습문제2)  class
//패키지명 : com.the703.basic010_ex_ex
//클래스명 :  ClassEx004
//-- 생성자 작성하시오.
//class TV{
////상태-멤버변수  : 채널/볼륨 String channel; int volume;   
////행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
//}
//public class ClassEx004 {
//    public static void main(String[] args) {
//   TV  t1 = new TV("JDBC" , 8);
//   t1.show(); 
//   TV  t2 = new TV();
//   t2.input();  
//   t2.show();
//   }
//}
//출력내용 :
//JDBC   8
//
//* channel입력>youtube
//* volume 입력>10
//youtube   10