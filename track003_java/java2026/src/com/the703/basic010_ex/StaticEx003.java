package com.the703.basic010_ex;

class Sawon3{
	
	/* 오류나는 이유
		맨처음 메모리에 할당될때
		method area에 클래스, 클래스 변수, 클래스 메서드 가 메모리 상에 올라가고
		맨처음 static int basicpay = pay; 와 같은경우
		선언 당시에 pay는 메모리상에 올라가있지 않음 / 아직 new 생성자로 생성하지 않았음
		때문에 pay를 basicpay에 대입이 불가능함
	*/
	
	// 인스턴스 변수
	int pay = 10000;
	
	// 클래스 변수
	static int su = 10;
	//static int basicpay = pay;
	static int basicpay2;
	
	// 클래스 메서드
	public static void showSu() {   System.out.println(su);  }

	// public static void showPay() {   System.out.println(this.pay);  }     

	// 인스턴스 메서드
	public  void  showAll001() {
	    System.out.println(su);  
	    System.out.println(this.pay);  
	} 
	
	// 클래스 메서드
	public static  void  showAll002() {
		// 지역 변수
	    // showAll001();
	    //System.out.println(this.pay); 
	} 
}
public class StaticEx003 {
	public static void main(String[] args) {
		Sawon3 sola = new Sawon3();
		sola.showAll001();
	}
}

//패키지명 : com.company.java010_ex
//클래스명 :  MemberVarEx001
//-- class Sawon3작성해주세요 
//1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//2. 인스턴스메서드, 클래스메서드 구분하시오.
//3. 오류나는 이유는?
//class Sawon3{ 
//    int pay      =10000;    
//    static int su=10;     
//    static int basicpay=pay;    
//    static int basicpay2;    
//    
//    public static void showSu() {   System.out.println(su);  }          
//    public static void showPay() {   System.out.println(this.pay);  }    
//  
//    public  void  showAll001() {   
//       System.out.println(su);  
//       System.out.println(this.pay);  
//    } 
//    public static  void  showAll002() {   
//        showAll001();    
//       System.out.println(this.pay);
//    } 
//} 
//public class MemberVarEx001{
//  public static void main(String[] args) {
//   Sawon3   sola = new Sawon3();  
//   sola.showAll001();
//  }
//}
