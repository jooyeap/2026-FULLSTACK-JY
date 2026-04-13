package java_practice001;

import java.util.Arrays;

public class Practice006_List {

	public static void main(String[] args) {
		
		String [] food = {"apple","banana","coconut",""}; 
		System.out.println(food[3]);
		
		food[3] = "dddd";
		System.out.println(food[3]);
		System.out.println(food.length);
		System.out.println("\n");
		
		int [] score = {85, 92, 78, 95, 88};
		int total = 0;
		
		
		for(int i=0; i<score.length; i++) { total += score[i]; }
		System.out.println(total);
		
		System.out.println("\n");
		int [] a = {15000, 8000, 25000, 5000, 30000};
		int [] b = new int[3];
		int [] sale = new int[5];
		int count = 0;
		
		for(int i=0; i<a.length; i++) {
			if(a[i]>=20000) {b[count] = a[i]; count++;}
			sale[i] = (int)(a[i]*0.9);
		}
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(sale));
		
	}

}
