package com.the703.basic014;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 1. 클래스는 부품객체이다
// 2. 상태(멤버변수) 와 행위(멤버함수)

class UserDto{
	//멤버변수
	private static int cnt = 0; // 클래스 변수 ( static -> method area - this x - 공용이 목적 )
	private final int no;		// 인스턴스 변수 -> final은 수정 안됨
	private String email;		// 인스턴스 변수 ( heap area - new o - 생성자 o - this o )
	
	public UserDto() { this.no = ++cnt; } // 유저 번호 = 값; 값 1개 증가하고 대입
	public UserDto(int no, String email) { super(); this.no = no; this.email = email; }
	public UserDto(String email) { this(); this.email = email; }
	@Override public String toString() { return "UserDto [no=" + no + ", email=" + email + "]"; }
	
	public static int getCnt() { return cnt; }
	public static void setCnt(int cnt) { UserDto.cnt = cnt; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public int getNo() { return no; }
	
	// 1. 클래스가 맞는지 확인 (UserDto 클래스 안에서, email/no 를 비교)
	@Override public int hashCode() { return Objects.hash(email); }  	// 객체들의 값
	
	// 2. 객체 안의 값이 같은지 확인
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email);
	} 
	
	//멤버함수						// 기본값 - 명시적초기화 - 초기화 블록 - 생성자
	
}

public class List002 {
	public static void main(String[] args) {
		// add, get, size, remove, contains
		List<UserDto> users =new ArrayList<>();
		users.add( new UserDto("aaa@gmail.com") ); // 주소값
		users.add( new UserDto("bbb@gmail.com") );
		
		System.out.println(users);
		System.out.println("1. get > " + users.get(0));
		System.out.println("2. size > " + users.size());
		System.out.println("3. remove > " + users.remove(1));
		System.out.println("4. contains > " + users.contains( new UserDto("aaa@gmail.com")));
		System.out.println("5. contains > " + users.contains( new UserDto("bbb@gmail.com")));
		
		UserDto dto = users.get(0);
		System.out.println("INFO"+(0+1) + " : "+ dto.getNo() + "/" + dto.getEmail());
		
		int num = 0;
		for(UserDto a : users) {
			System.out.println("INFO" + (num+1) + " : " + a.getNo() + "/" + a.getEmail());
			num++;
		}
		
	}
}
