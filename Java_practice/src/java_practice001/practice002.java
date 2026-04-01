package java_practice001;

import java.util.Scanner;

public class practice002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hp = 60;
		int time = 8;
		int str = 0;
		int days = 0;
		int hpy = 0;
		
		while(true) {
			
			System.out.println("================");
			System.out.println("현재 시각 " + time + ":00" );
			System.out.println("일상 생활");
			System.out.println("1. 상태 확인");
			System.out.println("2. 행동 하기");
			System.out.println("3. 시간 확인");
			System.out.println("4. 여기에 뭐넣을지 구상좀해봐라");
			System.out.println("5. 종료");
			System.out.println("================");
			
			int numM = sc.nextInt();
			
			if(numM > 0 && numM < 6) {
				
				System.out.println("정상값 입력 확인");
				
				if(numM == 1) {
					
					System.out.println("1번 실행\n");
					System.out.println("\n" + days + "일 째" );
					System.out.println("현재 체력 : " + hp + "/100");
					System.out.println("스트레스 지수 : " + str);
					System.out.println("행복 지수 : " + hpy);
					
				}
				
				else if(numM == 2) {
					
					while(true) {
						System.out.println("2번 실행\n");
						System.out.println("무엇을 할까요?");
						System.out.println("1. 공부하기");
						System.out.println("2. 놀기");
						System.out.println("3. 자기");
						System.out.println("4. 메인으로 돌아가기");
						numM = sc.nextInt();
						if(numM == 1) {
							
							time++;
						}
						else if(numM == 2) {
							System.out.println("놀기");
							
							time++;
						}
						else if(numM == 3) {
							System.out.println("잠을 잡니다");
							hp = hp +30;
							if(hp > 100) {
								hp = 100;
								System.out.println("체력은 100이상을 보유할 수 없습니다.");
								}
							if(str >= 0) {
								str = str -30;
									if(str <= 0 ) 
									{
									System.out.println("스트레스 지수는 0보다 낮을 수 없습니다.");
									str = 0;
									}
								}
								time = 8;
								days++;
								break;
							
						}
						else if(numM == 4) {
							System.out.println("메인으로 돌아갑니다.");
							break;
						}
						else {
							System.out.println("정상적인 값을 입력해주세요.\n");
						}
					}
					
				}
				
				else if(numM == 3) {
					
					System.out.println("3번 실행\n");
					System.out.println("현재 시각은 " + time +":00 입니다.");
					
				}
				
				else if(numM == 4) {
					
					System.out.println("4번 실행\n");
					
				}
				
				else if(numM == 5) {
					
					while(true) {
					System.out.println("5번 실행\n");
					System.out.println("종료하시겠습니까?");
					System.out.println("1. 종료 / 2. 메인으로");
					numM = sc.nextInt();
					
					if(numM == 1) {
					System.out.println("종료합니다.");
					System.exit(0);
					}
					else if(numM == 2) {
					System.out.println("메인으로 돌아갑니다.");
					break;
					}
					else {
						System.out.println("정상적인 값을 입력해주세요.\n");
						continue;
					}
				  }
					
				}
				else {
					System.out.println("정상적인 값을 입력해주세요.");
				}
			}
		}
	}
}
