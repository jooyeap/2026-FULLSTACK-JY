package com.the703.basic010;

public class UserInfo2{
	public String name;		// 아무데서나 접근 가능
	protected String safe; 	// 자식에서 사용가능 (extends 시)
   /*default*/String house;	// 패키지내부
	private int iQ;			// 클래스내부 is not used
	
	public int getiQ() { return iQ; }			// get 갖고오는것
	public void setiQ(int iQ) { this.iQ = iQ; } // set 세팅하는것
}
// public < protected < default(package) 아무것도 안붙은 지정접근자 < private
