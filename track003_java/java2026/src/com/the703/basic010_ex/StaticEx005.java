package com.the703.basic010_ex;

//연습문제3)  멤버변수
//패키지명 : com.company.java010_ex
//클래스명 :  MemberVarEx003
////- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
////- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
////- 문제 3. 오류가 발생하는 이유를 설명하시오.
////- 문제 4. runtime data area 위치영역 그림그리기
////- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
/// 
//:: 주인 이름: std-1
//총 음식량: 175
//전체 급식판 수: 1
//
//
//:: 주인 이름: std-2
//총 음식량: 175
//전체 급식판 수: 2

/*
 오류나는 이유
 맨 처음 LunchTray, trayCount, totalFood, maxRice, showTrayCount(), showOwner() 클래스 변수, 클래스 메서드들이 method area 메모리에 할당
 때문에 static int totalFood = rice + soup; 와같이 인스턴스 변수들은 메모리에 할당되어있지 않아 연산 및 대입 불가능
 
 */

class LunchTray { // 메서드 안의{} 변수 -> 지역 변수
	// 인스턴스 변수
    String owner;        
    int rice = 90;               
    int soup = 85;               

    // 클래스 변수
    static int trayCount = 0;      
    static int maxRice = 100;       
    //static int totalFood = rice + soup;

    // 인스턴스 메서드
    public int getFoodAmount() {
        return rice + soup;         
    }

    public void showTray() {
    	System.out.println("\n\n:: 주인 이름: " + owner);                
    	System.out.println("총 음식량: " + getFoodAmount());     
    }
    
    public LunchTray() {
    	super();
    	this.owner = "std-"+ ++trayCount; 
    }
    
    // 클래스 메서드
    public static void showTrayCount() {
        System.out.println("전체 급식판 수: " + trayCount);   
    }

//    public static void showOwner() { 
//       System.out.println(owner);
//    }

}


public class StaticEx005 {
   public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
   }
} 
////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------
[METHOD:정보, static, final] LunchTray.class , StaticEx005.class
 trayCount, totalFood, maxRice, showTrayCount(), showOwner()
------------------------------------------------------------------------
[HEAP:동적]    		       		 					|  [STACK:지역]

1번지 { owner,rice,soup, showTray(), getFoodAmount()}	<- s1[1번지]   			
2번지 { owner,rice,soup, showTray(), getFoodAmount()}	<- s2[2번지] 
														main #2
------------------------------------------------------------------------
*/
////////////////////////////////////////////////////////////////////////