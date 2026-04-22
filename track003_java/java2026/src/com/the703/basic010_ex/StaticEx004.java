package com.the703.basic010_ex;

//패키지명 : com.company.java010_ex
//클래스명 : MemberVarEx002
//
//-- class Student 작성해주세요
//
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//
class Student {
	
	/*
	 오류나는 이유
	 메모리상에 Student , studentCount, maxScore, showStudentCount(), showName() 먼저 method area에 할당되어 있음
	 이때 static int total = kor + eng 중 kor,eng 는 인스턴스 변수로 아직 메모리에 할당되어있지 않은 상태이므로
	 total(클래스 변수) 에 kor,eng(인스턴스 변수)를 대입할수 없음
	 showName() 메서드의 경우도 동일
	  
	 */
	// 인스턴스 변수
    String name = "홍길동";        
    int kor = 90;                  
    int eng = 85;
    
    // 클래스 변수
    static int studentCount = 0;    
    //static int total = kor + eng;   
    static int maxScore = 100;     

    // 인스턴스 메서드
    public Student() {
        studentCount++;             
    }

    public int getTotalScore() {
        return kor + eng;        
    }

    // 클래스 메서드
    public static void showStudentCount() {
    	// 지역 변수
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {
       //System.out.println(name);  
   }

   // 인스턴스 메서드
   public void showInfo() {
	   // 지역 변수
       System.out.println("이름: " + name);            
       System.out.println("총점: " + getTotalScore());    
   }
}

public class StaticEx004 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}
////////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------
[METHOD:정보, static, final] Student.class , StaticEx004.class
	Student.studentCount, Student.maxScore, Student.showStudentCount(), Student.showName()
------------------------------------------------------------------------
[HEAP:동적]    		       		 					|  [STACK:지역]

1번지 { name=null, kor=0, eng=0, showInfo()
		Student(),getTotalScore()		} 			<- s1[1번지]   			
2번지 { name=null, kor=0, eng=0, showInfo()} 			
		Student(),getTotalScore()		} 			<- s2[2번지]   	
														main #2
------------------------------------------------------------------------
*/
////////////////////////////////////////////////////////////////////////