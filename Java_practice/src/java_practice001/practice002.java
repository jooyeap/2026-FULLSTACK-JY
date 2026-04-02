package java_practice001;

import java.util.Scanner;

public class practice002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hp = 60;
		int time = 16;
		int str = 0;
		int days = 0;
		int gold = 0;
		double stat = 1.0;
		
		String OVER_STR = "행동을 하기에 너무 많은 스트레스가 쌓여있습니다.";
		String OVER_TIME = "행동하기에 시간이 모자랍니다.";
		String GO_MENU = "초기메뉴로 돌아갑니다.";
		String ERR_MSG = "정상적인 값을 입력해주세요";
		
		
		while(true) {
			
			
			if(str >= 70) {
				System.out.println();
			}
			
			else if(hp <= 50) {
				System.out.println(":(");
			}
			
			else if(time <= 20) {
				System.out.println(":(");
			}
			
			else {
			 	System.out.println(":)");
			}
			
			System.out.println();
			System.out.print( "================\n"
					    	+ " 집 마련 프로젝트\n"
							+ "================\n"
							+ "현재 시각 " + time + ":00\n"
							+ days + " 일 째\n"
							+ "================\n"
							+ "1. 상태 확인\n"
							+ "2. 행동 하기\n"
							+ "3. 설명\n"
							+ "4. 돈 쓰기\n"
							+ "5. 종료\n"
							+ "================\n"
							+ "숫자 입력 -> ");
//			System.out.println(NOW_TIME);
//			System.out.println( days + " 일 째");
//			System.out.println("================");
//			System.out.println("1. 상태 확인");
//			System.out.println("2. 행동 하기");
//			System.out.println("3. 설명");
//			System.out.println("4. 돈 쓰기");
//			System.out.println("5. 종료");
//			System.out.println("================");
//			System.out.print("숫자 입력 -> ");
			
			int numM = sc.nextInt();
			
			if(numM > 0 && numM < 6) {
				
				//System.out.println("정상값 입력 확인");
				
				// 1. 상태
				if(numM == 1) {
					
					System.out.print  ("\n"
						              +"현재 체력 : " + hp + "/100\n"
						              +"피로 : " + str + "\n"
						              +"보유 현금 : " + gold + "\n"
						              +"능력 : " + stat + "\n");
					
				} // 1번 마지막
				
				// 2. 행동
				else if(numM == 2) {
					
					while(true) {
						System.out.println();
						System.out.print( "\n"
										+ "현재 시각 " + time + ":00\n"
										+ "무엇을 할까요?\n"
										+ "----------\n"
										+ "1. 공부하기\n"
										+ "2. 놀기\n"
										+ "3. 자기\n"
										+ "4. 일하기\n"
										+ "5. 메인으로 돌아가기\n");
						
						numM = sc.nextInt();
						
						if(time >= 24) {
							System.out.print("행동하기에 시간이 많이 늦어\n"
											+"잠자리에 듭니다.");
							hp += 30;
							if(hp > 100) {
								hp = 100;
								System.out.println("체력은 100이상을 보유할 수 없습니다.");
								}
							if(str >= 0) {
								str -= 50;
									if(str <= 0 ) 
									{
									System.out.println("스트레스 지수는 0보다 낮을 수 없습니다.");
									str = 0;
									}
								}
							time = 8;
							days++;
							break;
						} // 하루 시간제한 if 문 끝
						
						if(numM == 1) {
							
								if(str >= 80) {
									System.out.println(OVER_STR);
								}
								else {
									System.out.println("공부를 합니다.");
									stat += 0.5;
									str += 10;
									time++;
									break;
								}
							
						}
						else if(numM == 2) {
							
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
							break;
						}
						else if(numM == 3) {
							
							System.out.println("잠을 잡니다");
							hp += 30;
							if(hp > 100) {
								hp = 100;
								System.out.println("체력은 100이상을 보유할 수 없습니다.");
								}
							if(str >= 0) {
								str -= 50;
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
							
							if(str >= 70) {
								System.out.println(OVER_STR);
								
							}
							else if(time >= 16) {
								System.out.println("시간이 너무 늦어 일을 할수가 없습니다.\n"
												  +"이전 선택지로 돌아갑니다.");
							}
							else {
								System.out.println("일을 합니다");
								gold += 1000 * stat;
								str += 30;
								time += 8;
								break;
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
					
					System.out.print("3. 설명\n"
									+"체력은 모든 행동을 할때 10씩 소모됩니다.\n"
									+"능력은 일을 할때 받을수있는 금액의 배율을 올려줍니다.\n"
									+"피로 지수가 100을 초과하면 패널티가 부여됩니다.\n"
									+"시간이 24시에 도달하면 자동으로 하루를 종료합니다.\n"
									+"최종 목표는 공부하여 능력을 키우고 돈을 벌어 집을 사는것입니다.\n");
					
					
				} // 3번 마지막
				
				else if(numM == 4) {
					
					System.out.println("4번 실행\n");
					
				} // 4번 마지막
				
				else if(numM == 5) {
					
					while(true) {
					System.out.print("\n"
									+"종료하시겠습니까?\n"
									+"1. 종료 / 2. 메인으로\n");
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
			}// 맨처음 if문 끝
			else { System.out.println(ERR_MSG); }
		}
	}
}
