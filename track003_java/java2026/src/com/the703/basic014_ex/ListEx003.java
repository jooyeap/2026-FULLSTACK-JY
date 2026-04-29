package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// 1. 아이스크림 정보 클래스
class IceCreamDTO{
	private String name;
	private int price;
	public IceCreamDTO() { super();  }
	public IceCreamDTO(String name, int price) { super(); this.name = name; this.price = price; }
	
	public IceCreamDTO(String name) {
		this(); this.name = name;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	@Override public String toString() { return "IceCreamDTO [name=" + name + ", price=" + price + "]"; }
	@Override public int hashCode() { return Objects.hash(name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IceCreamDTO other = (IceCreamDTO) obj;
		return Objects.equals(name, other.name);
	}
	
}
public class ListEx003 {
	public static void main(String[] args) {
		int chk = -1;
		int num = -1;
		int price = 0;
		int count = 0;
		String name = "";
		String name_ck = "";
		
		Scanner sc = new Scanner(System.in);
		List<IceCreamDTO> ice = new ArrayList<>();
//		IceCreamDTO dto = new IceCreamDTO();
		
		System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️\r\n"
				+ "✨ 오늘도 달콤한 하루가 시작됩니다! ✨\r\n"
				+ "🛎️ 손님~ 어떤 아이스크림을 원하시나요?\r\n"
				+ "--------------------------------------------------");
		while(chk != 0) {
			count = 0; name_ck = ""; name = "";
			System.out.print("\n📋 메뉴판 "
				   			  +"\n🍧 IceCream Menu 🍧"  
							  +"\n1️ 아이스크림 추가"
							  +"\n2️ 아이스크림 목록 보기"
							  +"\n3️ 아이스크림 제거"
							  +"\n4️ 아이스크림 존재 확인"
							  +"\n5️ 총 아이스크림 개수"
							  +"\n0️ 종료"
							  +"\n👉 선택:");
			
			num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.print("\n🍓 아이스크림 이름 > ");
				name = sc.next();
				System.out.print("\n💰 가격 > ");
				price = sc.nextInt();
				ice.add(new IceCreamDTO(name, price));
				System.out.println("✅ " + name +" 추가 완료!");
				break;
			case 2:
				System.out.println("🍨 현재 아이스크림 목록---");
				if(ice.size() == 0) {
					System.out.println("아직 등록된 아이스크림이 없습니다");
					continue;
				}
				for( IceCreamDTO a : ice ) {
					System.out.println("- " + a.getName() + " (" + a.getPrice() + "원)");
				}
				break;
			case 3:
				
				System.out.print("🗑️ 제거할 아이스크림 이름 > ");
				name = sc.next();
				//System.out.println(name + "입력 이름");
				for(IceCreamDTO a : ice) { // name 에 입력받은거랑 대조해서 반복문 돌려서 이름 일치하는거 있으면 그거 remove
					name_ck = a.getName();
					//System.out.println(name_ck + "체크용 이름");
					if(name.equals(name_ck)) {
						ice.remove(count);
						System.out.println("🧹 제거 완료!");
						break;
					}
					count++;
				}
				if(count == ice.size()) {
					System.out.println("일치하는 아이스크림 없음");
				}
				//System.out.println( ice.remove(new IceCreamDTO(name)) ? "제거완료" : "일치하는 머시기없음");
				break;
			case 4:
				System.out.print("🔍 확인할 아이스크림 이름 > ");
				name = sc.next();
				if(ice.contains(new IceCreamDTO(name))) {
					System.out.println("✅ 존재합니다!");
				}
				else {System.out.println("❌ 없습니다!");}
				break;
			case 5:
				System.out.print("📦 총 아이스크림 개수 > " + ice.size());
				break;
			case 0:
				System.out.println("👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!");
				chk = 0; break;
				default : System.out.println("예외처리"); break;
			}
		}
	}
}
//패키지명 : com.company.java014_ex 
//클래스명 : ListEx003
//
//1. 문제 개요
//아래 조건에 맞게 ListEx003.java 파일을 작성하고, 콘솔에서 실행되는 결과를 예측하시오. 
//이 프로그램은 아이스크림 가게를 운영하는 시뮬레이션으로, 
//사용자의 입력에 따라 아이스크림을 추가, 제거, 확인, 출력하는 기능을 포함한다.
//
//2. 클래스 구조
//클래스명   역할   주요 메서드
//IceCreamDTO   아이스크림 정보 저장 DTO      / getName(), getPrice(), toString()
//ListEx003   메인 실행 클래스   main(), List 활용
//
//- IceCreamDTO는 이름과 가격을 저장하는 데이터 객체
//- ListEx003                클래스는 List<IceCreamDTO>를 활용하여 아이스크림을 추가, 출력, 제거, 검색
//- add, get, size, remove, contains 메서드를 모두 활용
//
//3. 요구사항
//- IceCreamDTO 클래스를 정의하고, 
//이름과 가격을 저장할 수 있도록 생성자 및 getter 작성
//- ListEx003 클래스에서 List<IceCreamDTO>를 생성하고, add() 메서드로 아이스크림 추가
//get() 메서드로 목록 출력, size()로 개수 확인
//메뉴는 무한 반복 구조로 구성되어 사용자가 0을 입력할 때까지 계속 실행됨 
//
//4. 콘솔 출력 흐름
//🎉 프로그램 시작 시 
//❄️🍦 Welcome to the Magical IceCream Land 🍦❄️  
//✨ 오늘도 달콤한 하루가 시작됩니다! ✨  
//🛎️ 손님~ 어떤 아이스크림을 원하시나요?  
//--------------------------------------------------
//📋 메뉴판 
//🍧 IceCream Menu 🍧  
//1️ 아이스크림 추가
//2️ 아이스크림 목록 보기
//3️ 아이스크림 제거
//4️ 아이스크림 존재 확인
//5️ 총 아이스크림 개수
//0️ 종료
//👉 선택:
//
//5. 각 메뉴 선택 시 출력 메시지
//5-1. 아이스크림 추가 
//아이스크림 이름: [사용자 입력]  
//가격: [사용자 입력]  
//[입력한 이름] 추가 완료!
//
//5-2. 아이스크림 목록 보기
//리스트가 비어있을 경우:
//현재 아이스크림 목록:  
//아직 등록된 아이스크림이 없습니다.
//
//아이스크림이 있을 경우:
//현재 아이스크림 목록:  
//- 초코 (1500원)  
//- 바닐라 (1300원)
//
//5-3. 아이스크림 제거 
//제거할 아이스크림 이름: [사용자 입력]  
//제거 완료!   또는   해당 아이스크림이 존재하지 않습니다.
//
//5-4. 아이스크림 존재 확인
//
//확인할 아이스크림 이름: [사용자 입력]  
//존재합니다!   또는   존재하지 않습니다.
//
//5-5. 총 아이스크림 개수
//총 아이스크림 개수: [리스트 크기]
//
//5-6. 종료
//아이스크림 가게를 닫습니다. 다음에 또 만나요!
//
//6. 추가 조건 (선택 사항)
//Scanner를 사용하여 사용자 입력을 처리할 것
//ArrayList<IceCreamDTO>를 사용하여 아이스크림 목록을 저장할 것
//toString() 메서드를 오버라이드하여 출력 형식을 예쁘게 만들 것
//이모지를 활용하여 콘솔 출력이 재미있고 직관적으로 보이도록 할 것
//
//
//전체출력화면 ) 
//❄️🍦 Welcome to the Magical IceCream Land 🍦❄️
//✨ 오늘도 달콤한 하루가 시작됩니다! ✨
//🛎️ 손님~ 어떤 아이스크림을 원하시나요?
//--------------------------------------------------
