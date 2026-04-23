package com.the703.basic010;

// 1) basic010, basic010_ex
class UserInfo{
	public String name;		// 아무데서나 접근 가능
	protected String safe; 	// 자식에서 사용가능 (extends 시)
   /*default*/String house;	// 패키지내부
	private int iQ;			// 클래스내부 is not used
	
	public int getiQ() { return iQ; }			// get 갖고오는것
	public void setiQ(int iQ) { this.iQ = iQ; } // set 세팅하는것
}

public class Class007_Modifier {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보");
		UserInfo user = new UserInfo();
		user.name = "홍상직"; // public 아무데서나 접근 가능
		user.safe = "1234";
		user.house = "전라남도 장성군";
		// user.iQ = 3; 
		user.setiQ(12);
		System.out.println(user.getiQ());
		
	}
}

/*

	1. 지정 접근자 
	- 클래스의 구성 요소에 대한 접근을 제한하는 역할
				클래스내부 		패키지(폴더) 	하위클래스 		그 외
	public		O			O			O			O
	protected	O			O			O			X
	default		O			O			X			X
	private		O			X			X			X
	
*/