package com.the703.basic010_ex;

// 1. 클래스는 부품객체
// 2. 상태(멤버변수)와 행위(멤버함수)를 갖는다
// 멤버변수 : name, no, kor, eng, math
// 멤버함수 : void info()
// 3. 설계도 -> 부품객체 -> 사용
class Student001{
	String name;
	int no, kor, eng, math;
	void info() {
		System.out.printf("이름 : %s\n총점 : %d\n평균 : %.2f",name,(kor+eng+math),(kor+eng+math)/3f);
	}
} // 설계도

public class ClassEx001{
	public static void main(String[] args) {
		// 1) new 번지, 객체생성  2) 생성자-초기화  3) s1주소
		Student001 s1 = new Student001(); // 부품객체 생성 (인스턴스화) heap
		s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
		s1.info(); // 사용
	}
}
////////////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
-------------------------------------------------------------------------------
[METHOD:정보]		Student001.class , ClassEx001.class #1
-------------------------------------------------------------------------------
[HEAP:동적]      				   					  	 	|  [STACK:지역]

1) 1번지 : Student001{									<- s1 [1번지] 3)
	멤버변수 > name=null, np=0, kor=0, eng=0, math=0
	멤버함수 > info() } 2)
															main #2
-------------------------------------------------------------------------------
*/
///////////////////////////////////////////////////////////////////////////////

//연습문제1)  class
//패키지명 : com.company.com.the703.basic010_ex
//클래스명 :  ClassEx001
//class Student001{
//  멤버변수 : String name;  int no, kor, eng, math;
//  멤버함수 : void info()
//}
//

//출력내용 : 
//  이름: first
//  총점 : 299
//  평균 : 99.67