package the.com703.v001;

import java.util.Scanner;

public class BankV3 {

	   // 변수 0 1 2
	   ////////////////////////////////////////////////////
	   static String []id = new String[3];       //  one two three	      
	   static String []pass = new String[3];   // 1111 2222 3333
	   static double []balance = new double[3];// 1100 2200 3300   
	   static Scanner sc = new Scanner(System.in);
	   static int tempbalance = -1;
	   static boolean login = false;
	   static int id_count = -1;
	   static String id_ck = "";
	   static String pass_ck = "";
		////////////////////////////////////////////////////
		//1. 메뉴판을 기능
	    static int mainMenu() {
	    	System.out.print("💲💲  WELCOME TO BANK SYSTEM  💲💲\n"
							+"==============================\n"
							+"[1] ➕ 계좌 추가\n"
							+"[2] 🔍 계좌 조회\n"
							+"[3] 📈 입금하기\n"
							+"[4] 📉 출금하기\n"
							+"[5] ❌ 계좌 삭제\n"
							+"[9] ‼ 종료 ‼\n"
							+"=============================\n"
							+"번호 입력 > ");
	    	
	    	return sc.nextInt();
	    }
	    
	    //2. 유저 빈칸찾기 기능
	    static int bankCheak() {
	    	id_count = -1;
	    	for(int i=0; i<balance.length; i++) {
	    		if(balance[i] == 0) { id_count = i; break;}
	    	}
	    	return id_count;
	    }
	    //3. 사용자인증기능 (아이디와 비밀번호가 같은지 찾기)
	    static int userCheak(String user_id, String user_pass) {
	    	for(int i=0; i< id.length; i++) {
	    		if(id[i] != null && pass[i] != null && id[i].equals(user_id) && pass[i].equals(user_pass)) {
	    			System.out.println(id[i]+"님 로그인");
	    			login = true;
	    			id_count = i;
	    			return i;
	    		}
	    	}
	    	System.out.println("아이디 혹은 비밀번호를 확인해주세요.");
	    	login = false;
	    	return -1;
	    }
	    //4. 계좌추가기능
		static void makeId(int id_count) {
			System.out.println("아이디를 입력해주세요 > ");
			id[id_count] = sc.next();
			
			System.out.println("비밀번호를 입력해주세요 > ");
			pass[id_count] = sc.next();
			
			System.out.println("잔액 입력 > ");
			balance[id_count] = sc.nextInt();
		}
	    //5. 조회기능
		static void info() {
			System.out.println("\n아이디	 : " + id[id_count]
						      +"\n비밀번호	 : " + pass[id_count]
							  +"\n잔액 	 : " + balance[id_count] + " 원 \n");
		}
	    //6. 입금기능
		static void input() {
			System.out.print("\n입금하실 금액 > ");
			int temp = sc.nextInt();
			balance[id_count] += temp;
			
			System.out.println( "\n" + temp + " 원 입금");
			System.out.println("==========================");
			System.out.println("현재 잔액 : " + balance[id_count]);
		}
	    //7. 출금기능
		static void output() {
			System.out.print("\n출금하실 금액 > ");
			int temp = sc.nextInt();
			
			if(temp<balance[id_count]) {
				balance[id_count] -= temp;
				
				System.out.println("\n" + temp + " 원 출금");
				System.out.println("====================");
				System.out.println("현재 잔액 : " + balance[id_count] + " 원");
			}
			else {System.out.println("잔액이 부족합니다.");}
			
		}
	    //8. 삭제기능
		static void delete() {
			System.out.println("\n계좌를 삭제하시겠습니까?\n Y/N ");
			char ch = sc.next().charAt(0);
			
			if(ch == 'Y' || ch == 'y') {
				id[id_count] = null;
				pass[id_count] = null;
				balance[id_count] = 0;
				id_count = -1;
				login = false;
				System.out.println("계좌를 삭제합니다.");
			}
			else if(ch == 'N' || ch == 'n') {
				System.out.println("취소");
			}
			else {System.out.println("정확한 값을 입력해주세요");}
		}
		////////////////////////////////////////////////////
		
	public static void main(String[] args) {
		int num = -1;
		int menu=-1;  
		
		while(true) {
			
			menu = mainMenu();
			
			if(menu == 1) {makeId(bankCheak());}
			else if(login == false && menu != 9) {
				
				System.out.print("아이디 입력 > ");
				id_ck = sc.next();
				
				System.out.print("\n비밀번호 입력 > ");
				pass_ck = sc.next();
				
				num = userCheak(id_ck,pass_ck);
				}
			else if(menu == 2) {info();}
			else if(menu == 3) {input();}
			else if(menu == 4) {output();}
			else if(menu == 5) {delete();}
			else if(menu == 9) {System.out.println("종료"); break;}
		}

	}

}
