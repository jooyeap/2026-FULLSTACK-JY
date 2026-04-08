package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		
		int i = 0;

		int count = 0;
		
		for(i=1;i<=30;i++) {
			if(i%3 == 0 && i%2 == 0) {
				count++;
				System.out.println(count+"."
				+ "3의 배수이면서 2의 배수인 숫자 : " + i);
			}
		}
		System.out.println("갯수 : " + count);
		System.out.println();
		
		i = 1; count = 0;
		
		while(i<=30) {
			if(i%3 == 0 && i%2 == 0) {
				count++;
				System.out.println(count+"."
				+"3의 배수이면서 2의 배수인 숫자 : " + i);
			}
			i++;
		}
		System.out.println("갯수 : " + count);
		System.out.println();
		
		i = 1; count = 0;
		
		do {
			if(i%3 == 0 && i%2 == 0) {
				count++;
				System.out.println(count + "."
				+"3의 배수이면서 2의 배수인 숫자 : " + i);
			}
			i++;
		} while(i<=30);
		System.out.println("갯수 : " + count);
	}

}
