package java_practice001;

import java.util.Scanner;

public class practice001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("거리를 입력하세요.");
		int i = Integer.parseInt(sc.nextLine());
		int k = 0;
		if(i < 1000)
			{System.out.println(i + "m");}
		else
			{k=i/1000;
			System.out.println(k + "km");}
		
		System.out.println();
		System.out.println();
		
	
		// 여기서 값을 받을 함수 만들고
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("거리입력 첫번째");
		// sc1 << 여기에 입력 받은 값을 i1 << 이쪽으로 넘김
		// Integer.parseInt "문자열"을 정수로 변환하는것, 재료가 반드시 문자열이여야함
		int i1 = Integer.parseInt(sc1.nextLine()); // 이때 입력값을 받는거
		
		System.out.println(sc1); // 함수가 아니라 객체는 println을 사용하면 상태정보를 나타내서 생각한 값이 안나옴
		System.out.println(i1);
		
		//---------------
		
		System.out.println();
		System.out.println();
		
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("거리입력 두번째");
		
		// nextInt >> 입력 대기 상태에서 "정수"를 바로 골라냄
		// 정수만 쏙 빼고 엔터값은 남아져있어서 다음코드에 영향이 있을것같다고함
		int i2 = sc.nextInt();
		
		System.out.println(i2);
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("오류 확인");
		
		// 위에 nextInt에 값을 입력하고 나갈때 정수만 가져가고 엔터값이 남아있어
		// 아래 nextLine에 값을 입력하기전에 엔터값이 들어가서 입력불가함 유의해야할거같음
		String name = sc.nextLine();
		System.out.println(name);

		//asdasd
		
	}

}
