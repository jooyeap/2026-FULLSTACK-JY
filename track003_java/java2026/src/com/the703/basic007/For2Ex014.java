package com.the703.basic007;

public class For2Ex014 {

	public static void main(String[] args) {
		
		// 2 1 2    3 1 3   4 1 4
        // 2 2 4    3 2 6   4 2 8
        // 2 3 6    3 3 9   4 3 12

        int num1 = 2;
        int num2 = 3;
        int num3 = 4;
        int a = 1;
        int b = 1;
        int count = 1;

        for(a=1; a<4; a++){
            for(b=1;b < 4; b++){
                if(num3 != 10){
                System.out.printf("%d%s%d%s%d\t%d%s%d%s%d\t%d%s%d%s%d\n"
                                    ,num1,"*",b,"=",(num1*b)
                                    ,num2,"*",b,"=",(num2*b)
                                    ,num3,"*",b,"=",(num3*b));}
                else if(num3 <= 10){
                    System.out.printf("%d%s%d%s%d\t%d%s%d%s%d\n"
                                    ,num1,"*",b,"=",(num1*b)
                                    ,num2,"*",b,"=",(num2*b));
                }
              
            }
            num1 +=3;
            num2 +=3;
            num3 +=3;
            System.out.println();
        }
        
        num1 = 2; 
        
        for(a=1; a<10; a++){
        	
        	num1 = 2;
        	if(a>3 && a<7) { num1 = 5; }
        	else if(a>6 && a<10) { num1 = 8;}
        	
            for(b=1;b < 4; b++){
                if(num1 != 10){
                	System.out.print(num1 + "*" + count + "=" + (num1*count) + "\t");
                	num1++;
                }
            }
            switch(count) {
            case 1: count = 2; break;
            case 2: count = 3; break;
            case 3: count = 1; System.out.println(); break;
            }
            System.out.println();
        }
		
		// 2 1 2    3 1 3   4 1 4
        // 2 2 4    3 2 6   4 2 8
        // 2 3 6    3 3 9   4 3 12

        
//        int num = 2;
//        int count1 = 0;
//
//        for(int x=1; x<4; x++){
//        	
//            for(int y=1;y<4;y++){
//            	count++;
//                for(int c=1; c<4; c++) {
//                	if(num < 8) {
//	            		System.out.print(num+"*"+y+"="+(num*y)+"\t");
//	                	num++;}
//                	else {
//                		System.out.print(num+"*"+y+"="+(num*y)+"\t");
//                		System.out.print((num+1)+"*"+y+"="+((num+1)*y)+"\t"); break;}
//                }
//                if(count < 3) {num = 2;}
//                else if(count < 6) { num = 5; }
//                else if(count < 9) { num = 8; }
//                
//                System.out.println();
//
//            }
//            System.out.println();
//
//        }

       

	}

}