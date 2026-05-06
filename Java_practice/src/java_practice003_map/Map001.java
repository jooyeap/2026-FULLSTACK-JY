package java_practice003_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Cafe{
	private String menu;
	private int price;
	public Cafe(String menu, int price) { super(); this.menu = menu; this.price = price; }
	public Cafe() { super();  }
	public String getMenu() { return menu; }
	public void setMenu(String menu) { this.menu = menu; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; } 
	
}

public class Map001 {
	public static void main(String[] args) {
		String place = "";
//		int price = 0;
		String menuName = "";
		Map<String,Cafe> aCafe = new HashMap<>();
		aCafe.put("a-1",new Cafe("아메리카노", 2000));
		aCafe.put("a-2",new Cafe("라떼",3500));
		
		Map<String,Cafe> bCafe = new HashMap<>();
		bCafe.put("b-1",new Cafe("에스프레소", 1500));
		bCafe.put("b-2", new Cafe("아이스티",2500));
		
		Map<String, Map<String, Cafe>> cafeManager = new HashMap<>();
		cafeManager.put("A", aCafe);
		cafeManager.put("B", bCafe);
		
		
		System.out.println("==========================");
		System.out.println("카페 정보 출력");
		System.out.println("==========================");
		for(Map.Entry<String, Map<String,Cafe>> a : cafeManager.entrySet()) {
			System.out.println(a.getKey());
			for(Map.Entry<String, Cafe> b : a.getValue().entrySet()) {
				System.out.printf("지점 : %s\t 메뉴명 : %s\t 가격 : %d\n",
						b.getKey(),b.getValue().getMenu(),b.getValue().getPrice());
			}
			System.out.println("------------------------------");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("찾는 지역 A,B 입력 > ");
		place = sc.next();
		System.out.print("메뉴 입력 > ");
//		price = sc.nextInt();
		menuName = sc.next(); // key값이 뭔지를 확인했어야 했음 메뉴이름이 아니라 a-1, a-2 같은게 입력되어야했음
		
		if(cafeManager.containsKey(place)) {
			System.out.println("첫 if문 진입");
			Cafe result = cafeManager.get(place).get(menuName);
//			System.out.println(result);
			if(result != null) {
				System.out.println(result.getMenu() + " - " + result.getPrice());
			}
			else { System.out.println("입력 확인");}
			
//			Map<String, Cafe> temp = cafeManager.get(place);
//			System.out.println("지점 " + place);
//			
//			if(temp.containsKey(menuName)) {
//				System.out.println("안쪽 if문 진입");
//			}
		}
		else {System.out.println("입력 확인");}
		
		
		
	}
}


