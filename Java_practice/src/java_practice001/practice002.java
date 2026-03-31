package java_practice001;

import java.util.Scanner;

public class practice002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hp = 0;
		int time = 0;
		int str = 0;
		int days = 0;
		int hpy = 0;
		
		while(true) {
			
			System.out.println("=============");
			System.out.println("일상 생활");
			System.out.println("1. 상태 확인");
			System.out.println("2. 행동 하기");
			System.out.println("3. 시간 확인");
			System.out.println("4. 여기에 뭐넣을지 구상좀해봐라");
			System.out.println("5. 종료");
			System.out.println("=============");
			
			int numM = sc.nextInt();
			
			if(numM > 0 && numM < 6) {
				
				System.out.println("정상값 입력 확인");
				
				if(numM == 1) {
					
					System.out.println("1번 실행\n");
					System.out.println("\n" + days + "일 째" );
					System.out.println("현재 체력 : " + hp);
					System.out.println("스트레스 지수 : " + str);
					System.out.println("행복 지수 : " + hpy);
					
				}
				
				if(numM == 2) {
					
					System.out.println("2번 실행\n");
					
				}
				
				if(numM == 3) {
					
					System.out.println("3번 실행\n");
					System.out.println("현재 시각은 " + time +":00 입니다.");
					
				}
				
				if(numM == 4) {
					
					System.out.println("4번 실행\n");
					
				}
				
				while(numM == 5) {
					
					while(true) {
					System.out.println("5번 실행\n");
					System.out.println("종료하시겠습니까?");
					System.out.println("1. 종료 / 2. 메인으로");
					numM = sc.nextInt();
					
					if(numM == 1) {
					System.out.println("종료합니다.");
					System.exit(0);
					}
					if(numM == 2) {
					System.out.println("메인으로 돌아갑니다.");
					break;
					}
					else {
						System.out.println("정상적인 값을 입력해주세요.\n");
						continue;
					}
				  }
					
				}
				
				
			}
			else {
				System.out.println("정상적인 값을 입력해주세요.");
			}
			
		}

	}

}
