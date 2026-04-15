package com.the703.basic008_ex;

public class Array3Total {

	public static void main(String[] args) {
		
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor = {100, 100, 100, 70, 35};   
	    int[] eng = {100, 100, 100, 80, 35};
	    int[] mat = {100, 100, 100, 60, 35};
	    int[] rank = {1,1,1,1,1};
	    int[] avg = new int[5];
	    String[] pass = new String[5];
	    String[] jang = new String[5];
	    int same = 0;
	    
	    for(int i=0; i<name.length; i++) {avg[i] = (kor[i]+ eng[i] + mat[i])/3;}
	    for(int i=0; i<avg.length; i++) {pass[i] = avg[i] < 70 ? "불합격" : "합격";}
	    for(int i=0; i<avg.length; i++) {jang[i] = avg[i] < 95 ? "----" : "장학생";}

	    
	    for(int i=0; i<name.length; i++) {
	    	if(avg[0] == avg[i] && i != 0) {same++;}
	    	for(int j=0; j<name.length; j++) {
	    		if(avg[i] < avg[j]) {rank[i]++;}
	    	}
	    }
	    
	    for(int i=0; i<name.length; i++) {
	    	if(rank[i] != 1) {rank[i] -= same;}
	    }
	    
//	    System.out.println(same);
//	    System.out.println(Arrays.toString(avg));
//	    System.out.println(Arrays.toString(pass));
//	    System.out.println(Arrays.toString(jang));
//	    System.out.println(Arrays.toString(rank));
	    
	    System.out.printf("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹\n");
		for(int i=0; i<name.length; i++) {
			  System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t"
					  ,name[i],kor[i],eng[i],mat[i],avg[i],rank[i],pass[i],jang[i]);
			  for(int j=0; j<(avg[i]/10); j++) {
				System.out.print("★");  
			  }
			  System.out.println();}
	    

	}

}
