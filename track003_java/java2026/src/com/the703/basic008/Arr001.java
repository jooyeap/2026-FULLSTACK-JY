package com.the703.basic008;

public class Arr001 {

	public static void main(String[] args) {
		
		// 1. 변수 활용 시
		int a=1, b=2, c=3;
		
		// 2. 배열이란?
		/* [같은타입]의 데이터를 [연속된 공간에 저장] 하는 자료구조 
		 - 각 데이터의 저장위치를 [index]를 통해서 접근하는 방식
		 - 1) int [] arr 주소 보관할 준비 O
		 - 2) null = 공간은 있지만 값이 없음 
		 */
		int [] arr = null;
		System.out.println(arr);
		
		// [stack] arr2 주소보관 = [heap] 이라는 연속된 공간에 1,2,3 을 저장
		int [] arr2 = {1,2,3}; // 3개면 index가 0~2
		// arr2(1000번지) -> 1000번지에 있는 { 1, 2, 3}
		//								 [0][1][2]
		System.out.println(arr2); // arr2의 주소값이 출력
		System.out.println("1 꺼내 쓰기 > " + arr2[0]);
		System.out.println("2 꺼내 쓰기 > " + arr2[1]);
		System.out.println("3 꺼내 쓰기 > " + arr2[2]);
		
		// 3. 배열예시
		// 3-1. arr3 : 1 2 3 4 5
		int [] arr3 = {1,2,3,4,5}; // 5개 0~4
		System.out.println(arr3[2]);
		
		// 3-2. arr4 : 100 200 300
		int [] arr4 = {100,200,300}; // 3개 0~2
		System.out.println(arr4[0]);
		
		// 3-3. arr5 : 1.1 1.2 1.3
		double [] arr5 = {1.1,1.2,1.3}; // 3개 0~2
		System.out.println(arr5[2]);
		
		// 3-4. arr6 : 'a' 'b' 'c'
		char [] arr6 = {'a','b','c'}; // 3개 0~2
//		System.out.print(arr6[0]);
//		System.out.print(arr6[1]);
//		System.out.print(arr6[2]);
		
		
		// 3-5. 3-4 for 출력
		System.out.println();
		System.out.println(arr6.length); // 3 출력
		for(int i=0; i<3; i++) {System.out.print(arr6[i]);}
		
		System.out.println();
		for(int i=0; i<arr6.length; i++) {System.out.print(arr6[i]);}
		
		
	}
}
