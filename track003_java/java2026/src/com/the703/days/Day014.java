package com.the703.days;

import java.util.Scanner;

public class Day014 {

	public static void main(String[] args) {
		
		int a = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 >");
		a = sc.nextInt();
		
		if(a==1) {System.out.println("1 이다");}
		else if(a==2) {System.out.println("2 이다");}
		else if(a==3) {System.out.println("3 이다");}
		
		switch(a) {
		case 1: System.out.println("1 이다"); break;
		case 2: System.out.println("2 이다"); break;
		case 3: System.out.println("3 이다"); break;
		}
		
		System.out.println();
		
		for(int i=1; i<=4; i++) {System.out.print(i);}
		int i=1; System.out.println();
		while(i<=4) {System.out.print(i); i++;}
		i=1; System.out.println();
		do {System.out.print(i); i++;}while(i<=4);
		
		System.out.println();
		
		for(i=0; i<4; i++) {
			for(int j=0; j<i; j++) {System.out.print("★");}
			System.out.println();
		}
		
		System.out.println();
		
		int [] arr2 = {1,2,3};
		
		System.out.println(arr2[2]);
		
		double [] arr = new double[5];
		double temp = 1;
		
		for(i=0; i<arr.length; i++) {
			temp += 0.1; 
			arr[i] = temp;
			System.out.printf("%.1f%s",arr[i]," ");
		}
		

	}

}
