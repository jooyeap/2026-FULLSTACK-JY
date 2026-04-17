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
		// 아래로 내려가서 값 계산 전에 maxArray가 한번 더 호출됨
		
		if(max > a[b-1]) { // if else 둘중 하나 큰 값을 가져옴
			return max;
		}
		else {return a[b-1];}	}
	
		// 제일 이해안갔던거? 리턴값을 뱉는다고 무조건 메서드가 끝나는게아니고
		// 아래까지 오기전에 중간에 maxArray << 이메서드가 돌아가고 있기때문에
		// 제일 안쪽에 실행되고있는 메서드부터 연산이 다 끝나고 나서
		// 안쪽부터 차례대로 끝나면서 메서드가 종료되는거임
		// 그리고 메서드에 입력된 값은 들어갈때 값이지 나올땐 뭐가 나올지를 생각해야할거같음
		// 코드에 시각적으로 보이는거에 의존하면 안됨
	
		// 1. 중간 maxArray 에서 a 배열의 [5-1] > [4] / 제일 뒤 숫자 max에 대입 하기전에 메서드 호출
		// 2. 다시 maxArray 에서 a 배열의 [4-1] > [3] 
		// 3. 다시 maxArray 에서 a 배열의 [3-1] > [2]
		// 4. 다시 maxArray 에서 a 배열의 [2-1] > [1]
		// 5. 다시 maxArray 에서 a 배열의 [1-1] > [0] / if에 걸리니까 더이상 메서드 호출하지않음
		// 여기서부터 max에 값이 들어가고 아래 if문에 들어가서 비교 시작하면서 안쪽 메서드부터 닫힘
		// 6. 5번에 들어간 max(a[0])값 이랑 a[1]이랑 비교 해서 큰 값을 max에 뱉음
		// 7. 6번에서 나온 max값(6번에서 비교한 두개중 더 큰 값) 이랑 a[2]랑 비교 해서 큰 값을 max에 뱉음
		// 8. 7번에서 나온 max값(7번에서 비교한 두개중 더 큰 값) 이랑 a[3]랑 비교 해서 큰 값을 max에 뱉음
		// 9. 8번에서 나온 max값(8번에서 비교한 두개중 더 큰 값) 이랑 a[4]랑 비교 해서 큰 값을 max에 뱉음
		// 10. 9번이 작동중인 제일 마지막 메서드니까 리턴값 뱉어서 아래 main 함수에 출력
		
	
	public static void main(String[] args) {
		// 재귀함수 이용하여 배열에서 가장 큰값을 출력
		int arr[] = {1,3,9,7,5};
		System.out.println(maxArray(arr,arr.length)); // 출력값 9
	}
}
