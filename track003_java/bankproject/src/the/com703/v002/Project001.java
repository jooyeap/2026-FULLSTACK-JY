package the.com703.v002;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class User{
	private String name;
	private double balance;
	public User(String name, int balance) { super(); this.name = name; this.balance = balance; }
	public User() { super();  }
	@Override public String toString() { return "User [name=" + name + ", balance=" + balance + "]"; }
	@Override public int hashCode() { return Objects.hash(balance, name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return balance == other.balance && Objects.equals(name, other.name);
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getBalance() { return balance; }
	public void setBalance(int balance) { this.balance = balance; }
}

class User_Data extends User{
	private String id;
	private String pw;
	private double won;
	
	public User_Data() { super();  }
	public User_Data(String name, int balance) { super(name, balance);  }
	public User_Data(String name, int balance, String id, String pw, double won) {
		super(name, balance);
		this.id = id;
		this.pw = pw;
		this.won = won;
	}
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	public double getWon() { return won; }
	public void setWon(double won) { this.won = won; } 
}

class Menu{
	static int mainMenu() {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n===========================");
		System.out.println("거래소 이름 머시기 어쩌구저쩌구");
		System.out.println("===========================");
		System.out.println("1. 계정 생성");
		System.out.println("1.");
		System.out.println("1.");
		System.out.println("1.");
		System.out.println("1.");
		System.out.println("1.");
		System.out.println("===========================");
		System.out.print("메뉴 번호 입력 > ");
		
		return i =sc.nextInt();
	}
	
	static void createId() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n이름을 입력해주세요 > ");
		String name = sc.next();
		System.out.print("\nID를 입력해주세요 > ");
		String id = sc.next();
		System.out.print("\n비밀번호를 입력해주세요 > ");
		String pw = sc.next();
		System.out.print("\n초기 자금을 입력해주세요 > ");
		double money = sc.nextInt();
		
		
	}
}

public class Project001 {
	public static void main(String[] args) {
		Map<String,User_Data> users = new HashMap<>();
		
		int num = 0;
		num = Menu.mainMenu();
	}
}
