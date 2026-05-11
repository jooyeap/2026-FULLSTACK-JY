package com.the703.basic017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NetWork003_book {
	public static void main(String[] args) {
		try {
			
			// 1. URL - 주소확인
			String apiurl = "https://openapi.naver.com/v1/search/book.json?query="
							+ URLEncoder.encode("spring" , "UTF-8"); // ## 검색어
			URL url = new URL(apiurl);
			
			// 2. HttpURLConnectrion - 연결객체
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 프로토콜 : HTTPS
			
			// 3. 요청설정 GET - GET
			conn.setRequestMethod("GET"); // HTTP 메서드 	: GET
			conn.setRequestProperty("X-Naver-Client-Id", "HUTzxhAQM4xkb3I0DfYN");
			conn.setRequestProperty("X-Naver-Client-Secret", "7i541UEIkG");

			// 4. 응답확인
			int code = conn.getResponseCode();
			System.out.println(code);
			
			// 5. 응답데이터
			BufferedReader br;
			if(code == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			String line = "";
			StringBuffer sb = new StringBuffer();
			
			while( (line = br.readLine()) != null) { sb.append(line+"\n"); }
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
			
		} catch(Exception e){ e.printStackTrace(); 
		}
	}
}

/*

	> URL
		https://openapi.naver.com/v1/search/book.xml	XML <>
		https://openapi.naver.com/v1/search/book.json	JSON {}
	
	> 옵션
		프로토콜 		: HTTPS
		HTTP 메서드 	: GET
		파라미터		: query String
		> GET /v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1 HTTP/1.1
		> Host: openapi.naver.com
		> User-Agent: curl/7.49.1
		> Accept: 
		> X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
		> X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
		>


*/