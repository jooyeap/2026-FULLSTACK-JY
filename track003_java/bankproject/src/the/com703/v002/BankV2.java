package the.com703.v002;

import java.util.List;
import java.util.Scanner;

class BankDto {
	private String id;
	private String pw;
	private double balance;
	public BankDto(String id, String pw, double balance) {
		super();
		this.id = id;
		this.pw = pw;
		this.balance = balance;
	}
	public BankDto() { super();  }
}

class Bank{
	List<BankDto> users;

	public Bank(List<BankDto> users) { super(); this.users = users; }
	public Bank() { super();  }
	
	public int menu() {
		Scanner sc = new Scanner(System.in);
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
	
	public void addUser() {
		String newId = "";
		String newPw = "";
		double newBalance = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력해주세요 > ");
		newId = sc.next();
		
		System.out.print("\n비밀번호를 입력해주세요 > ");
		newPw = sc.next();
		
		System.out.println("\n잔액을 입력해주세요 > ");
		newBalance = sc.nextDouble();
		
		users.add(new BankDto(newId,newPw,newBalance));
		
		System.out.println("ID = " + newId
						  +"\nPW = " + newPw
						  +"\n잔액 = " + newBalance);	
	}
	
	public void userCheak(String uid, String upw) {
		
		for(BankDto u : users) {
			
		}
	}
}
	
public class BankV2 {
	public static void main(String[] args) {
		

	}
}
