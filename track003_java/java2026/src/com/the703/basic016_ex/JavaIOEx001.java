package com.the703.basic016_ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {
	public static void main(String[] args) throws IOException {
		// #1. 경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); // 포맷 설정
		long millis = System.currentTimeMillis();	// 시스템 시간 가져오기
		String folder_rel = "src/com/the703/basic016_ex/";	// 상대경로 - 현재 작업하는 폴더 기준
		String file_path = "app.log";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_path);
		
		// #2. 파일 + 폴더 준비
		if(!folder.exists()) { folder.mkdirs(); }
		if(!file.exists()) { file.createNewFile();}
		System.out.println("파일,폴더 준비 끝");
		
		// #3. Char 단위로 파일 쓰기
		// sdf.format(millis) + "로그파일입니다"
		Writer wr = new FileWriter(file);
		
		wr.write(sdf.format(millis));
		wr.close();
		System.out.println("쓰기완료");
		
		// #4. Char 단위로 파일 읽기
		int count = 0;
		Reader re = new FileReader(file);
		
		while((count = re.read()) != -1) {
			System.out.print((char)count);
		}
		re.close();
	}
}
