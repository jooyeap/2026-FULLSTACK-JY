package com.the703.basic017;

public class StringStringBuffer {
	public static void main(String[] args) {
		// #1. String
		String str = "ABC";
		System.out.println("1. str의 주소 > " + str + " " + System.identityHashCode(str));
		
		str += "D";
		System.out.println("2. str의 주소 > " + str + " " + System.identityHashCode(str));
		
		// 1. str의 주소 > ABC 1134712904
		// 2. str의 주소 > ABCD 1020923989
		// 값을 더하면 새로운 주소값이 부여됨 / 새로운 메모리에 할당 O
		
		// #2. StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("ABC");
		System.out.println("3. sb의 주소 > " + sb + " " + System.identityHashCode(sb));
		
		sb.append("D");
		System.out.println("4. sb의 주소 > " + sb + " " + System.identityHashCode(sb));
		
		// 3. sb의 주소 > ABC 127618319
		// 4. sb의 주소 > ABCD 127618319
		// 값을 더해도 같은 주소값이 부여됨 / 새로운 메모리에 할당 X
	}
}
