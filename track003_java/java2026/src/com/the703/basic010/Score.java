package com.the703.basic010;

public class Score{    // com.the703.basic010 패키지에 설정해주세요
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank;
	   
	   public Score() { super(); }
	   public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	   }
	   
	   public String getName() { return name; }
	   public void setName(String name) { this.name = name; }
	   public int getKor() { return kor; }
	   public void setKor(int kor) { this.kor = kor; }
	   public int getEng() { return eng; }
	   public void setEng(int eng) { this.eng = eng; }
	   public int getMath() { return math; }
	   public void setMath(int math) { this.math = math; }
	   
	   public static void info(){
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	   }
	   
	   public void show() {
		   total = kor+eng+math;
		   aver = (kor+eng+math)/3f;
		   p = aver < 60 ? "불합격" : 
			   kor < 40 || eng < 40 || math < 40 ? "불합격" : "합격";
		   s = aver < 90 ? "" : "장학생";
		   rank = "";
		   for(int i=0; i<(int)(aver/10); i++) {
			   rank += "*";
		   }
		   System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n"
				   ,name,kor,eng,math,total,aver,p,s,rank);
	   }
	   
	} 
//ㅁ출력된화면
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//이름   국어   영어   수학   총점   평균   합격여부   장학생   랭킹
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//iron   100   100   100   300   100.00   합격   장학생   **********
//hulk   20   50   30   100   33.33   불합격      ***
