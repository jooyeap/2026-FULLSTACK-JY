package com.the703.basic007;

public class For2Ex015 {

	public static void main(String[] args) {
		
		//■ ■ ■ ■ ■ 5
		//□ ■ ■ ■ □ 4 < 없어도 되는거 아닌가?
		//□ □ ■ □ □ 3 <
		//□ ■ ■ ■ □ 4 < 
		//■ ■ ■ ■ ■ 5
		
		// 내려갔다가 일정 도달 하면 올라가야함
		
		int a = 0;
		int b = 1;
		int count = 0;
		
		for(a=1; a<6; a++) {
		// 여기서 빈 공간 처리?	
			
			for(; b<6; b++) { // 여기 조건식을 유동적으로 바꿀방법을 ㅇㅇ
				System.out.print("#");	
			}
			System.out.println();
			
				switch(count) {
				case 0: count++; System.out.print(" "); b=3; break;
				case 1: count++; System.out.print(" "+" "); b=5; break;
				case 2: count++; System.out.print(" "); b=3; break;
				case 3: count++; b=1; break;
				}

		}
	}

}
