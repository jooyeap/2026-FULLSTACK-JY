package java_practice001;

import java.util.Scanner;

public class practice002 {

	public static void main(String[] args) {
		
		// 0406 메뉴 숫자 선택할때 if말고 switch로 변경해야할거같음
		
		Scanner sc = new Scanner(System.in);
		int hp = 60;
		int time = 8;
		int str = 0;
		int days = 1;
		int gold = 0;
		double stat = 1.0;
		
		String LOW_HP = "행동하기에 체력이 모자랍니다.\n";
		String OVER_STR = "행동을 하기에 너무 많은 스트레스가 쌓여있습니다.\n";
		String OVER_TIME = "행동하기에 시간이 모자랍니다.\n";
		String GO_MENU = "초기메뉴로 돌아갑니다.\n";
		String ERR_MSG = "정상적인 값을 입력해주세요.\n";
		String NO_MONEY = "잔액이 부족합니다.\n";
		
		
		while(true) {
			
			
			if(str >= 70) {
				System.out.println("피로가 70이상 쌓여있습니다 휴식이 필요합니다.\n"
						+ ":("); // 피로경고
			}
			
			else if(hp <= 50) {
				System.out.println("체력이 50 이하입니다 휴식이 필요합니다.\n"
						+ ":("); // 체력 경고
			}
			
			else if(time >= 20) {
				System.out.println("시간이 늦어 눈이 점점 감깁니다\n"
						+ ":("); // 시간 경고
			}
			
			else {
			 	System.out.println(":)"); // 평상시
			}
			
			System.out.println();
			System.out.print( "================\n"
					    	+ "고양이 집 마련 프로젝트\n"
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

			
			int numM = sc.nextInt();
			
			//if(numM > 0 && numM < 6) {
			switch(numM) {	
				
				//System.out.println("정상값 입력 확인");
				
				// 1. 상태
				//if(numM == 1) {
				case 1:  {
					
					System.out.print  ("\n"
						              +"현재 체력 : " + hp + "/100\n"
						              +"피로 : " + str + "\n"
						              +"보유 현금 : " + gold + "\n"
						              +"능력 : " + stat + "\n");
					
				} // 1번 마지막
				
				// 2. 행동
				//else if(numM == 2) {
				case 2:  {
					
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
						
						if(time >= 24 && numM !=3) {
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
								
								if(hp >= 10) { System.out.println(LOW_HP); break;}
								else if(str >= 80) { System.out.println(OVER_STR); break; }
								else {
									System.out.println("공부를 합니다.\n"
											+ "능력 +0.5\n"
											+ "피로 -10\n"
											+ "체력 -10\n");
									hp -= 10;
									stat += 0.5;
									str += 10;
									time += 2;
									break;
								}
							
						}
						else if(numM == 2) {
							
							System.out.println("놀기");
							
							if(hp >= 10) {System.out.println(LOW_HP); break;}
							else if(str >= 0) {
								str -= 20;
								System.out.println("피로 -20\n");
								if(str <= 0 ) {
									System.out.println("피로는 0보다 낮을 수 없습니다.\n");
									str = 0;
									}
								}
							hp -= 10;
							time += 2;
							break;
						}
						else if(numM == 3) {
							
							
							System.out.println("잠을 잡니다\n"
									+ "체력 +30\n"
									+ "피로 -50\n");
							hp += 30;
							if(hp > 100) {
								hp = 100;
								System.out.println("체력은 100이상을 보유할 수 없습니다.\n");
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
							
							if(str >= 70) { System.out.println(OVER_STR); break; }
							else if(time >= 16) { System.out.println("시간이 너무 늦어 일을 할수가 없습니다.\n" ); break; }
							else if(hp >= 30) { System.out.println(LOW_HP); break;}
							else {
								System.out.println("일을 합니다");
								System.out.println((10000 * stat) + "+ 원\n"
										+ "피로 +30\n");
								gold += 10000 * stat;
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
				//else if(numM == 3) {
				case 3:  {
					
					System.out.print("3. 설명\n"
									+"체력은 모든 행동을 할때 10씩 소모됩니다.\n"
									+"능력은 일을 할때 받을수있는 금액의 배율을 올려줍니다.\n"
									+"피로 지수가 100을 초과하면 패널티가 부여됩니다.\n"
									+"시간이 24시에 도달하면 자동으로 하루를 종료합니다.\n"
									+"최종 목표는 공부하여 능력을 키우고 돈을 벌어 집을 사는것입니다.\n");
					
					
				} // 3번 마지막
				
				// 4. 상점
				//else if(numM == 4) {
				case 4:  {
					
					while(true) {
						
						System.out.print("4. 돈 쓰기\n"
										+"------------\n"
										+"1. ☆★집★☆\t 100,000\n"
										+"2. 츄르\t 30,000\n"
										+"3. 밥\t 10,000\n"
										+"4. 책\t 20,000\n"
										+"5. 나가기\n");
						numM = sc.nextInt();
						
						if(numM == 1) {
							
							if(gold > 100000) {
								System.out.println(NO_MONEY);
							}
							else {
								System.out.println("드디어 고양이 집을 마련했습니다.");
								System.exit(0);
							}
						}
						
						else if(numM == 2) {
							
							if(gold > 30000) {
								System.out.println(NO_MONEY);
							}
							else {
								System.out.println("고양이가 좋아합니다.\n"
										+ "피로 -30\n");
								str -= 30;
								gold -= 30000;
							}
						}
						
						else if(numM == 3) {
							
							if(gold > 10000) {
								System.out.println(NO_MONEY);
							}
							else {
								System.out.println("밥을 먹어 기운이 납니다.\n"
										+ "체력 +40");
								hp += 40;
								gold -= 10000;
							}
						}
						
						else if(numM == 4) {
							
							if(gold > 20000) {
								System.out.println(NO_MONEY);
							}
							else {
								System.out.println("지식이 늘었습니다.\n"
										+ "능력 + 0.5\n");
								stat += 0.5;
								gold -= 20000;
							}
						}
						
						else if(numM == 5) {
							System.out.println(GO_MENU);
							break;
						}
						else {System.out.println(ERR_MSG);}
					}
					
				} // 4번 마지막
				
				//5. 종료
				//else if(numM == 5) {
				case 5:  {
					
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
				default: { System.out.println(ERR_MSG); }
			}// 맨처음 if문 끝
		}
	}
}
