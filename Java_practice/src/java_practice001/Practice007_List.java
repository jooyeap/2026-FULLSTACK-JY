package java_practice001;

import java.util.Arrays;

public class Practice007_List {

	public static void main(String[] args) {
		
		int [] num = {12,45,7,23,56,89,34};
		int a = 0;
		
		for(int i=0;i<num.length;i++) {
			if(a < num[i]) { a = num[i];}
		}
		System.out.println(a);
		
		String[] colors = {"Red","Orange","Yellow","Green","Blue"};
		String temp = "";
		
		int j = 4;
		
		for(int i=0; i<colors.length/2; i++) {
//			if(j == 2) {break;}
//			temp = colors[j];
//			colors[j] = colors[i];
//			colors[i] = temp;
//			j--;
			temp = colors[i];
			colors[i] =  colors[colors.length-1-i];
			colors[colors.length-1-i] = temp;
		}
		
		System.out.println(Arrays.toString(colors));
		
		int k = 0;
		j=0;
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		int[] odd = new int[10], even = new int[10];
		
		for(int i=0; i<data.length; i++) {
			if(data[i]%2 == 0){even[j] = data[i]; j++;}
			else {odd[k] = data[i]; k++;}
		}
		
		for(int i=0; i<k; i++) {System.out.print(odd[i]+" ");}
		System.out.println("\n");
		for(int i=0; i<j; i++) {System.out.print(even[i]+" ");}
		
	}

}
