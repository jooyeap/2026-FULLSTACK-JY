package com.the703.basic010_ex;

import com.the703.basic010.UserInfo2;

class UserInfoSon extends UserInfo2{
public void show() {
	System.out.println(":: 홍길동 아버지 이름 > " + name);		//public
	System.out.println(":: 홍길동 아버지 비밀번호 > " + safe);		//protected
	//System.out.println(":: 홍길동 아버지 집 > " + house);		//default -> 같은 폴더,패키지가 아니므로 접근 불가능
	System.out.println(":: 홍길동 아버지 아이큐 > " + getiQ());	//private -> getter setter로 인해 접근가능
	}
}

