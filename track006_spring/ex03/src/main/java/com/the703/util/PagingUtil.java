package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {
    
    private int listtotal;      // 게시글 전체 개수
    private int onepagelist;    // 한 페이지에 보여줄 게시글 개수
    private int pagetotal;      // 페이지 전체 개수, 소수점 올림 처리
    private int bottomlist;     // 하단 페이지 네비게이션 개수 (ex: 11 12 ... 19 20)
    private int pstartno;       // 페이지 시작 번호 / 데이터베이스에서 가져올 게시글 시작 번호
       
    private int current;        // 현재 페이지 번호 ex) 15       
    private int start;          // 시작 페이지 번호 ex) 11
    private int end;            // 마지막 페이지 번호 ex) 20
    
    public PagingUtil(int listtotal, int pstartno) { // 전체 게시글 수, 요청하는 페이지 번호
        super();
        
        // 전체 게시글 수
        this.listtotal = listtotal;
        
        // 한 페이지에 보여줄 게시글 수
        this.onepagelist = 10; 
        
        // 소수점이 있으면 페이지 올림 처리
        this.pagetotal = listtotal <= 0 ? 1 :
            (int) Math.ceil(listtotal/(double)onepagelist);
        
        // 하단 페이징 개수
        this.bottomlist = 10;
        
        // 1 -> 0번째부터, 10개
        // 2 -> 10번째부터, 10개
        // 3 -> 20번째부터, 10개
        // 데이터베이스 쿼리 페이징(Offset)을 위한 시작 인덱스 계산
        this.pstartno = (pstartno-1)*onepagelist;
        
        this.current = pstartno;
        
        // 하단 시작 페이지 번호 계산
        // 15 -> 11     ((15-1)/10)*10 + 1 = 11
        // 20 -> 11     ((20-1)/10)*10 + 1 = 11
        this.start = ((this.current-1)/this.bottomlist)*this.bottomlist + 1;
        
        // 하단 끝 페이지 번호 계산
        // 15 -> 20     11+10-1 = 20
        // 20 -> 20     11+10-1 = 20
        this.end = this.start + this.bottomlist -1;
        
        // 전체 페이지 수보다 계산된 끝 페이지가 크면 끝 페이지를 전체 페이지 수로 맞춤
        // ex) 전체 게시글 256개 -> 마지막 페이지는 30이 아니라 26
        if(this.end > this.pagetotal) {this.end = this.pagetotal;}
    }
   
}