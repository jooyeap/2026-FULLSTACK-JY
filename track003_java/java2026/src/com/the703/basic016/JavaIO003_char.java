package com.the703.basic016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class JavaIO003_char {
	public static void main(String[] args) {
		
		// #1. 경로
		String folder_rel = "src/com/the703/basic016/";	// 상대경로 - 현재 작업하는 폴더 기준
		String file_path = "io003_char.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_path);
		
		// #2. 폴더 + 파일 만들기
		try {
			if(!folder.exists()) { folder.mkdirs();}
			if(!file.exists()) { file.createNewFile();}
		}catch(Exception a) { a.printStackTrace(); 
		}
		System.out.println("파일 생성 완료");
		
		// #3. char 쓰기 / Writer (FileWriter)
		try {
			Writer writer = new FileWriter(file);
			writer.write("hello\n");
			writer.write("java\n");
			writer.close();
			System.out.println("쓰기 완료");
		} catch (IOException e) {  e.printStackTrace();
		}
		
		// #4. char 읽기 / Reader (FileReader)
		try {
			int count = 0;
			Reader reader = new FileReader(file);
			while((count = reader.read()) != -1) {
				System.out.print((char)count);
			}
			reader.close();
		} catch (FileNotFoundException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace();
		}
	}
}
/*

1. Java I/O 
- 입력(input)과 출력(output)
- 두 대상간의 데이터를 주고 받는 것
- 스트림이란? 사용 연결 통로

  입력스트림		->		[프로그램]			->		출력 스트림
		    InputStream				OutputStream
		      Reader				  Writer
	
2. Java I/O 분류
- byte (모든종류- 그림, 멀티미디어, 문자) / char (문자)
- byte (InputStream/OutputStream) / char (Reader/Writer)

3. 보조스트림

*/