package com.the703.basic016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004_img {
	public static void main(String[] args) throws IOException {
		
		// #1. 경로
		String origin = "src/com/the703/basic016/ma.jpg";
		String target1 = "src/com/the703/basic016/ma1.jpg";
		String target2 = "src/com/the703/basic016/ma2.jpg";
		
		// #2. byte 이미지파일 원본 읽어들여서 쓰기
		//	InputStream > [프로그램] > OutputStream
		InputStream bis = new FileInputStream(origin);		// 원본 읽어 들여서 (read)
		OutputStream bos = new FileOutputStream(target1);	// ma1.jpg 쓰기 (write)
		
		int count = 0;
		while((count = bis.read()) != -1) {
			bos.write((byte)count); 	// ma1.jpg 쓰기 (write)
		}
		bos.close(); bis.close();
		System.out.println("이미지 복사완료");
		
		// #3. char 이미지파일 원본 읽어들여서 쓰기
		// char는 문자열 전용이기 때문에 이미지파일 전송하면 파일이 깨짐
		// Reader > [프로그램] > Writer
		Reader cr = new FileReader(origin);		// 원본 읽어 들여서
		Writer cw = new FileWriter(target2);	// ma2.jpg 쓰기
		
		count = 0;
		while((count = cr.read()) != -1) {		// 원본 읽어 들여서
			cw.write((char)count);				// ma2.jpg 쓰기
		}
		cw.close(); cr.close();
		System.out.println("복사완료");
	}
}
