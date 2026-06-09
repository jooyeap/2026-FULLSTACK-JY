package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {
	
	private int listtotal;		// 개시물의 총 갯수
	private int onepagelist;    // 한페이지의 출력할 개시물의 갯수
	private int pagetotal;    	// 페이지의 총 갯수 , 소숫점 올림 처리
	private int bottomlist;     // 하단의 페이지 || 이전 11 12 ... 19 20 다음
	private int pstartno;     	// 페이지 시작번호 / 페이지를 눌렀을때 시작하는 개시물의 번호
	   
	private int current;		// 현재 페이지 번호 ex) 15       
	private int start;        	// 시작 페이지 번호 ex) 11
	private int end;			// 마지막 페이지 번호 ex) 20
	
	public PagingUtil(int listtotal, int pstartno) { // 전체 페이지수, 시작하는 번호
		super();
		
		// 전체 페이지 수
		this.listtotal = listtotal;
		
		// 한 페이지에 보여줄 개시물의 수
		this.onepagelist = 10; 
		
		// 소숫점으로 나누고 올림 처리
		this.pagetotal = listtotal <= 0 ? 1 :
			(int) Math.ceil(listtotal/(double)onepagelist);
		
		// 하단 페이지
		this.bottomlist = 10;
		
		// 1 -> 0번째부터, 10개
		// 2 -> 10번째부터, 10개
		// 3 -> 20번째부터, 10개
		this.pstartno = (pstartno-1)*onepagelist;
		
		this.current = pstartno;
		
		this.start = ((this.current-1)/this.bottomlist)*this.bottomlist + 1;
		// 15 -> 11		앞자리를 1로 ((15-1)/10)*10 + 1 = 11
		// 20 -> 11 	앞자리를 1로 ((20-1)/10)*10 + 1 = 11
		
		this.end = this.start + this.bottomlist -1;
		// 15 -> 20		11+10-1 = 20
		// 20 -> 20		11+10-1 = 20
		
		// 전체 페이지 갯수가 256 -> 마지막은 30이 아니라 26
		if(this.end > this.pagetotal) {this.end = this.pagetotal;}
	}
   
}
