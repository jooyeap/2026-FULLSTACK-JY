package java_practice001;

import java.util.Scanner;

public class practice002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hp = 60;
		int time = 8;
		int str = 0;
		int days = 0;
		int gold = 0;
		double stat = 1.0;
		
		String OVER_STR = "행동을 하기에 너무 많은 스트레스가 쌓여있습니다.";
		String GO_MENU = "초기메뉴로 돌아갑니다.";
		String ERR_MSG = "정상적인 값을 입력해주세요";
		String NOW_TIME = "현재 시각 " + time + ":00";
		
		
		while(true) {
			
			
			if(str >= 70) {
				System.out.println();
			}
			
			else if(hp >= 50) {
				System.out.println();
			}
			
			else if(time >= 20) {
				System.out.println();
			}
			
			else {
			 	System.out.println();
			}
			
			System.out.println("================");
			System.out.println(" 집 마련 프로젝트 ");
			System.out.println("================");
			System.out.println(NOW_TIME);
			System.out.println( days + " 일 째");
			System.out.println("================");
			System.out.println("1. 상태 확인");
			System.out.println("2. 행동 하기");
			System.out.println("3. 설명");
			System.out.println("4. 돈 쓰기");
			System.out.println("5. 종료");
			System.out.println("================");
			System.out.print("숫자 입력 -> ");
			
			int numM = sc.nextInt();
			
			if(numM > 0 && numM < 6) {
				
				System.out.println("정상값 입력 확인");
				
				// 1. 상태
				if(numM == 1) {
					
					System.out.println("1번 실행\n");
					System.out.println("현재 체력 : " + hp + "/100");
					System.out.println("피로 : " + str);
					System.out.println("보유 현금 : " + gold);
					System.out.println("능력 : " + stat);
					
				} // 1번 마지막
				
				// 2. 행동
				else if(numM == 2) {
					
					while(true) {
						System.out.println("2번 실행\n");
						System.out.println(NOW_TIME);
						System.out.println("무엇을 할까요?");
						System.out.println("----------");
						System.out.println("1. 공부하기");
						System.out.println("2. 놀기");
						System.out.println("3. 자기");
						System.out.println("4. 일하기");
						System.out.println("5. 메인으로 돌아가기");
						numM = sc.nextInt();
						
						if(numM == 1 && time <= 23) {
							if(str >= 80) {
								System.out.println(OVER_STR);
							}
							else {
								System.out.println("공부를 합니다.");
								stat += 0.5;
								str += 20;
								time++;
							}
							
						}
						else if(numM == 2 && time <= 23) {
							
							System.out.println("놀기");
							if(str >= 0) {
								str -= 20;
								System.out.println("피로가 10 만큼 감소합니다.");
								if(str <= 0 ) {
									System.out.println("피로는 0보다 낮을 수 없습니다.");
									str = 0;
									}
								}
							time++;
						}
						else if(numM == 3) {
							
							System.out.println("잠을 잡니다");
							hp += 30;
							if(hp > 100) {
								hp = 100;
								System.out.println("체력은 100이상을 보유할 수 없습니다.");
								}
							if(str >= 0) {
								str -= 30;
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
						else if(numM == 4 && time <= 16) {
							
							if(str >= 70) {
								System.out.println(OVER_STR);
								
							}
							else {
								System.out.println("일을 합니다");
								gold += 1000 * stat;
								str += 30;
								time += 8;
							}
						}
								
						
						else if(numM == 5) {
							System.out.println(GO_MENU);
							break;
						}
						else {
							System.out.println(ERR_MSG);
						}
					}
					
				} // 2번 마지막
				
				// 3. 설명
				else if(numM == 3) {
					
					System.out.println("3. 설명");
					System.out.println("체력은 모든 행동을 할때 10씩 소모됩니다.");
					System.out.println("능력은 일을 할때 받을수있는 금액의 배율을 올려줍니다.");
					System.out.println("피로 지수가 100을 초과하면 패널티가 부여됩니다.");
					System.out.println("시간이 24시에 도달하면 자동으로 하루를 종료합니다");
					System.out.println("최종 목표는 공부하여 능력을 키우고 돈을 벌어 집을 사는것입니다.");
					
					
				} // 3번 마지막
				
				else if(numM == 4) {
					
					System.out.println("4번 실행\n");
					
				} // 4번 마지막
				
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
					System.out.println(GO_MENU);
					break;
					}
					else {
						System.out.println(ERR_MSG);
						continue;
					}
				  }
					
				} // 5번 마지막
				else {
					System.out.println(ERR_MSG);
				}
			}
		}
	}
}
