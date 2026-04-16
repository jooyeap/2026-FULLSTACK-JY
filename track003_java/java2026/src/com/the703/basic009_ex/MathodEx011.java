package com.the703.basic009_ex;

public class MathodEx011 {

	public static int maxArray(int[] a, int b) {
//		int max = 0;
//		if(b == 1) {return a[0] = max;}
//		max = Math.max(a[b-1], a[b-2]);
//		return maxArray(a,--b);
		
		if(b == 1) {return a[0];} // 값을 전부다 비교했을때니까 그값을 뱉으면됨
		
		// 제일 뒤에있는 값을 비교 기준으로 잡음
		int max = maxArray(a,b-1); // 여기서 b - 1씩 하니까 한층씩 내려감
		
		if(max > a[b-1]) { // if else 둘중 하나 큰 값을 가져옴
			return max;
		}
		else {return a[b-1];}	}
	
		// 제일 이해안갔던거? 리턴값을 뱉는다고 무조건 메서드가 끝나는게아니고
		// 아래까지 오기전에 중간에 maxArray << 이메서드가 돌아가고 있기때문에
		// 제일 안쪽에 실행되고있는 메서드부터 연산이 다 끝나고 나서
		// 안쪽부터 차례대로 끝나면서 메서드가 종료되는거임
	
	public static void main(String[] args) {
		// 재귀함수 이용하여 배열에서 가장 큰값을 출력
		int arr[] = {1,3,9,7,5};
		System.out.println(maxArray(arr,arr.length)); // 출력값 9
	}
}
