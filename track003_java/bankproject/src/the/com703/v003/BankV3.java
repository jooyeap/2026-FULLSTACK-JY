package the.com703.v003;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

// 전체적으로 정보는 정보 처리는 처리 확실하게 구분

// 각 코인들 어떻게 만들고 설정 할건지?
interface Crypto{
	void rate();
}
// 다른종류가 들어올수 있으니까 출력할때 반복문으로 출력하는거 구상
class CryptoDto {
	private String name;
	private String symbol;
	private double price;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	public CryptoDto() { super();  }
	public CryptoDto(String name, String symbol, double price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.price = price;
	}
	
}

class UserDto {
	private String id;
	private String pw;
	private double balance;
	
	// 심볼값, 수량 들어가게
	Map<String,Double> wallet = new HashMap<>();
	public UserDto(String id, String pw, double balance) {
		super();
		this.id = id;
		this.pw = pw;
		this.balance = balance;
	}
	
	public UserDto() { super();  }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }
	public Map<String, Double> getWallet() { return wallet; }
	public void setWallet(Map<String, Double> wallet) { this.wallet = wallet; }
	@Override public String toString() { return "BankDto [id=" + id + ", pw=" + pw + ", balance=" + balance + "]"; }
	@Override public int hashCode() { return Objects.hash(balance, id, pw); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}
	
	// 구매
	public void addCrypto(String symbol, double amount) {
		wallet.put(symbol, amount);
	}
	
	public void sellCrypto(String symbol, double amount) {
		
	}
	
	
}

// 시장 클래스 / 사고 팔고, 변동성 메서드 구현
class Market{
	Map<String,CryptoDto> coins = new HashMap<>();

	// 코인 추가
	public Market() { // name symbol price
		coins.put("AAA", new CryptoDto("A코인", "AAA", 1000000));
		coins.put("BBB", new CryptoDto("B코인", "BBB", 500000));
		coins.put("CCC", new CryptoDto("C코인", "CCC", 500000));
	}
	
	// 구매
	public void Buy(UserDto user, String symbol, double amount){
		CryptoDto coin = coins.get(symbol);
		double price = coin.getPrice() * amount;
		if(price > user.getBalance()) {
			System.out.println("지갑에 보유한 잔고가 부족합니다.");
		}
		else {
			user.setBalance(user.getBalance() - price);
			user.addCrypto(symbol, amount);
			System.out.println(user.getId()+"님 거래 성공");
			System.out.println("코인이름 : " + coin.getName());
			System.out.println("심볼명 : " + coin.getSymbol());
			System.out.println("수량 : " + amount);
			System.out.println("구매 금액 : " + coin.getPrice()*amount);
			System.out.println("남은 금액 : " + user.getBalance());
			// 총자산 계산하는 메서드 완성하고 조정
	//		System.out.println("보유 자산 : " + (user.getBalance() ));
		}
	}
	
	// 판매
	public void Sell(UserDto user, String symbol, double amount) {
		CryptoDto coin = coins.get(symbol);
		user.setBalance(user.getBalance() + coin.getPrice() * amount);
		// 여기 판매한만큼 user 코인 감소시키는 문장
		System.out.println(user.getId()+"님 거래 성공");
		System.out.println("코인 이름 : " + coin.getName());
		System.out.println("심볼명 : " + coin.getSymbol());
		System.out.println("수량 : " + amount);
		System.out.println("판매 금액 : " + coin.getPrice()*amount);
		System.out.println("남은 금액 : " + user.getBalance());
	}
	
	// 총 자산 계산 및 출력으로 일단 메서드 완성 이후 연산이랑 출력이랑 구분
	public void totalBalance(UserDto user) {
		int count = 1;
		double total = 0;
		for(Entry<String,Double> e : user.getWallet().entrySet()) {
			String symbol = e.getKey();
			double amount = e.getValue();
			// 순번, 이름 , 심볼명 , 보유 수량, 평가금액
			System.out.printf("%d. 이름:%s 심볼명:%s 보유수량:%.2f 평가금액%.2f",
					count++,coins.get(symbol).getName(),symbol,amount,(amount * coins.get(symbol).getPrice()));
			total += amount * coins.get(symbol).getPrice();
		}
		System.out.println("총 보유 자산 " + total);
	}
	
	// 가격 변동
	public void updatePrice() {
		for(CryptoDto c : coins.values()) {
			double random = Math.random();
			double update = (random * 21 - 10) / 100;
			double result = c.getPrice()+(c.getPrice()*update);
			c.setPrice(result);
		}
		System.out.println("가격 변동");
	}
}

// 메뉴 클래스 따로 빼서 뱅크 상속?
class Bank{
	Map<String,UserDto> users = new HashMap<>();
	UserDto loginUser;	

	public Bank() { super();  }
	public Bank(Map<String, UserDto> users) { super(); this.users = users;}
	public int menu() {
		Scanner sc = new Scanner(System.in);
		// 여기도 전체적으로 구문 수정
		System.out.print("\n💲💲  WELCOME TO BANK SYSTEM  💲💲\n"
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
	// 계좌추가
	public void addUser() {
		String newId = "";
		String newPw = "";
		String newName = "";
		double newBalance = 0;
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력해주세요 >");
		newName = sc.next();
		
		System.out.print("아이디를 입력해주세요 > ");
		newId = sc.next();
		
		// 아이디 중복 검사
		for(Entry<String,UserDto> b : users.entrySet()) {
			if(b.getValue().getId().equals(newId)) {
				System.out.println("이미 존재하는 아이디입니다.");
				return;
			}
		}
		
		System.out.print("\n비밀번호를 입력해주세요 > ");
		newPw = sc.next();
		
		System.out.print("\n잔액을 입력해주세요 > ");
		newBalance = sc.nextDouble();
		
		users.put(newName , new UserDto(newId,newPw,newBalance));
		
		System.out.println("\nID = " + newId
						  +"\nPW = " + newPw
						  +"\n잔액 = " + newBalance);	
	}// 계좌 추가 메서드 끝
	
	// 유저 로그인 
	public UserDto userCheak() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--- 로그인 필요 ---");
		System.out.print("\n아이디를 입력해주세요 > ");
		String uid = sc.next();
		System.out.print("\n비밀번호를 입력해주세요 > ");
		String upw = sc.next();
		
		for(Entry<String,UserDto> u : users.entrySet()) {
			if(uid.equals(u.getValue().getId()) && upw.equals(u.getValue().getPw())) {
				System.out.println(uid + " 님 확인");
				this.loginUser = u.getValue();
				return u.getValue();
			}
		}
		System.out.println("입력하신 정보와 일치하는 계좌가 없습니다.");
		return null;
	}// 로그인 메서드 끝
	
	// 유저 계좌 정보
	public void userInfo(UserDto user) {
//		BankDto user = users.get(index);
		
		System.out.println(user.getId() + " 님의 정보");
		System.out.println("\nID = " + user.getId()
				  +"\nPW = " + user.getPw()
				  +"\n잔액 = " + user.getBalance());
	}// 계좌 정보 메서드 끝
	
	// 입금
	public void deposit(UserDto user) {
//		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		user.setBalance(input + user.getBalance());
		
		System.out.println(user.getId() + "님의");
		System.out.println("입금 하신 금액 : " + input);
		System.out.println("총 잔고 : " + user.getBalance());
	}// 입금 메서드 끝
	
	// 출금
	public void withdrawal(UserDto user) {
//		BankDto user = users.get(index);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출금 가능 잔액 : " + user.getBalance());
		System.out.print("출금하실 금액을 입력해주세요 > ");
		int input = sc.nextInt();
		
		if(user.getBalance() < input) {
			System.out.println("출금 가능한 잔액이 모자랍니다");
		}
		else {
			user.setBalance(user.getBalance() - input);
			System.out.println(user.getId() + "님의");
			System.out.println("출금 하신 금액 : " + input);
			System.out.println("총 잔고 : " + user.getBalance());
		}
	}// 출금 메서드 끝
	
	// 계좌 삭제
	public void deleteUser() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 하시려는 계좌 정보를 입력해주세요.");
		System.out.println("아이디 > ");
		String id = sc.next();
		
		System.out.println("비밀번호 > ");
		String pw = sc.next();
		
//		int index = -1;
		boolean msg = false;
		
		for(Entry<String,UserDto> b : users.entrySet()) {
//			++index;
			if(b.getValue().getId().equals(id) && b.getValue().getPw().equals(pw)) {
				System.out.println(id + "님의 계좌를 삭제하시겠습니까?");
				System.out.println("Y -> 종료 / 외 다른 입력 취소");
				char temp = sc.next().charAt(0);
				if(temp == 'Y' || temp == 'y') {
					System.out.println(b.getKey() + "님의 계좌 삭제완료");
					users.remove(b.getKey());
					this.loginUser = null;
					msg = true;
					break;
				}
				else { System.out.println("취소합니다. 메인으로 돌아갑니다.");}
			}
		}
		if(msg) {System.out.println("입력하신 정보와 일치하는 계좌가 없습니다.");}
		
		
	}// 계좌 삭제 메서드 끝
	
	// 종료
	public void exit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하시겠습니까?");
		System.out.println("Y -> 종료 / 외 다른 입력 취소");
		char temp = sc.next().charAt(0);
		if(temp == 'Y' || temp == 'y') {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		else{
			System.out.println("메인으로 돌아갑니다.");
		}
		
	}// 종료 메서드 끝
	
}
	
public class BankV3 {
	public static void main(String[] args) {
		
		
		int num = -1;
		Bank b = new Bank();
		
		while(num != 9) {

			num = b.menu();
			
			if(b.loginUser == null && num != 1) { b.loginUser = b.userCheak(); continue; }
			
			switch(num) {
			case 1: b.addUser(); break;
			case 2: b.userInfo(b.loginUser); break;
			case 3: b.deposit(b.loginUser); break;
			case 4: b.withdrawal(b.loginUser); break;
			case 5: b.deleteUser(); break;
			case 9: b.exit(); break;
			default: System.out.println("값을 다시 입력해주세요");
			}
			
		}
	}
}
