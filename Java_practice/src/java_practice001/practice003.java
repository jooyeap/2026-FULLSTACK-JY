package java_practice001;

import java.util.Scanner;

public class practice003 {

	public static void main(String[] args) {
		
	// if문 활용: 점수를 입력받아 90점 이상이면 'A', 80점 이상이면 'B', 그 외엔 'C' 출력하기
		int score = 0;
		char grade = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수 입력 > ");
		score = sc.nextInt();
		
		if(score >= 90) {
			grade = 'A';
		}
		else if(score >= 80) {
			grade = 'B';
		}
		else { grade = 'C';}
		
		System.out.println("입력한 점수 : " + score
						  +"\n출력 랭크? : " + grade);
		
		grade = score >= 90 ? 'A' : (score >= 80 ? 'B' : 'C');
		System.out.println(grade);
		
		////////////////////////////////////////////////////
		// switch문 활용: char형 변수에 'M'이면 "남성", 'F'이면 "여성" 출력하기
		
		char ch = '\u0000';
		char ch2 = '\u0000';
		
		System.out.println("성별 입력 M/F > ");
		ch = sc.next().charAt(0);
		
//		if(ch == 'M' || ch == 'F' ) {
//			if(ch == 'M') {System.out.println("남성");}
//			else {System.out.println("여성");}
//		}
//		else {System.out.println("정상적이지 않은 값");}
		
		switch(ch) {
		case 'M': case 'm': System.out.println("남성"); break;
		case 'F': case 'f': System.out.println("여성"); 
		} 
		
		////////////////////////////////////////////////////
		// for문 활용: 구구단 2단을 2 * 1 = 2 형식으로 출력하기
		
		int a = 0;
		
		System.out.println("숫자 입력 > ");
		a = sc.nextInt();
		
		for(int i = 1; i <= 9; i++ ) {
			System.out.printf("%d * %d = %d\n", a , i , a*i);
		}
		
	}

}
