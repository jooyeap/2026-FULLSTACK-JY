package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
public class UtilPaging { 
	private int listtotal;    // 전체 글 예) 193 개
	private int onepagelist;  // 한페이지에 보여줄 게시물의 수 예) 10
	private int pagetotal;    // 총 페이지 예) 193/10 -> 19페이지 + 3글 -> 20개
	private int bottomlist;   // 하단 버튼수(페이지수) 예) 10개
	private int pstartno;     // 페이지 시작번호 예) 1 -> 1번째 부터 10개 / 2 -> 11번째부터 10개
	private int current;      // 현재 번호
	private int start;        // 시작 번호
	private int end;          // 마지막 번호
    
	public UtilPaging(int listtotal, int pageNo) {
		// 한페이지 10, 하단 네비 10
		this(listtotal, pageNo, 10, 10);
	}
	
	public UtilPaging(int listtotal, int pageNo , int onepagelist , int  bottomlist) {
		
		this.listtotal   = (listtotal<=0)? 1: listtotal;
		this.onepagelist = onepagelist;
		
		// 193/10 -> 19.3 -> 올림처리 -> 20
		// 200/10 -> 20.0 -> 올림처리 -> 20
		this.pagetotal   = (int) Math.ceil(this.listtotal/ (double)onepagelist);
		this.bottomlist  = bottomlist;
		
		// 23 ? start = 21, end = 30
		this.current     = pageNo;
		
		// 21 ? (21-1)/10 -> 2 * 10 +1 -> 21  
		// 30 ? (30-1)/10 -> 2 * 10 +1 -> 21
		this.start       = ((current-1)/bottomlist)*bottomlist + 1;
		
		// 30 ? 21 + 10 - 1 -> 30
		this.end         = start + bottomlist -1;  
		if(end > pagetotal ) {  end = pagetotal; }   
		
		this.pstartno = (pageNo - 1) * onepagelist + 1;
	}      
}

