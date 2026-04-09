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
		
		// 2 1 2    3 1 3   4 1 4
        // 2 2 4    3 2 6   4 2 8
        // 2 3 6    3 3 9   4 3 12

//        int a = 0;
//        int b = 0;
//        int c = 2;
//        int d = 4;
//        int count = 0;
//
//        for(a=1; a<4; a++){
//        	
//            for(b=1;b<4;b++){
//            	c = 2;
//            	if(count == 3) {c = 5; d += 2;}
//            	else if(count == 6) {c = 7; d +=2;}
//	                for(; c<=d; c++) {
//	                System.out.print(c+"*"+b+"="+(c*b)+"\t");
//	                }
//                System.out.println();
//                count++;
//                System.out.println(count);
//
//            }
//        }
        

	}

}
