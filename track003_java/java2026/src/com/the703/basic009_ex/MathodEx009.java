package com.the703.basic009_ex;

import java.util.Arrays;

public class MathodEx009 {
	
	public static int getGCD(int i, int j) {
		
		// 큰값에 작은값 반복해서 나머지값 받고
		// 위에 작은값 가져와서 나머지값 받아와서 나머지값 0일때 조건 잡고
		// 그때 작은값 return으로 반환
		if(i==0) {return j;}// 2. 나머지가 0이 아니면 아직 계산이 된게 아니니까
		int k;
		k = j%i;			// 1. 나머지 = 큰값%작은값
		j = i;				// 큰값 = 위 계산할때 작은값
		i = k;				// 작은값 = 위 계산의 나머지  // 이렇게 반복 시키고
		return getGCD(i,j); // 3. 이쪽으로 다시 들어가서 위에 1번 반복후 2번 조건 다시대입
	}

	public static void main(String[] args) {
		int [] answer = new int[2];
		int n = 2, m = 5;
		int GCD = getGCD(Math.min(n, m),Math.max(n, m));
		answer[0] = GCD; // 최대공약수
		answer[1] = (n * m ) / GCD; // 최소공배수 = (small*big)/최대공약수
		System.out.println(Arrays.toString(answer));
	}

}
