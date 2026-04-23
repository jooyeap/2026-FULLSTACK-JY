package com.the703.basic010_ex;

import com.the703.basic010.Milk;

public class ModifierEx1{ // basic010_ex 패키지에 설정해주세요.
	   public static void main(String[] args) {
	      Milk m1 = new Milk();  
	      System.out.println( m1 );  
	      m1.setMprice(2000);       
	      System.out.println( m1 );
	   } // end main
	} // end class
