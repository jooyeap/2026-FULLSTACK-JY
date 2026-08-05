package com.thejoa703.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID; 
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

 
@Service  
public class FileStorageService {
   
	// 프로젝트 실행 위치를 기준으로 uploads폴더 생성
    private final Path root = Paths.get("uploads");  

    public String upload(MultipartFile file) {
        try {
        	// 디렉토리 생성 확인
            if (!Files.exists(root)) {
            	// 중간 경로까지 모두 생성
                Files.createDirectories(root);  
            }
            // 파일명 충돌 방지
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            // uploads 디렉토리 안에서 filename 붙여서 최종 경로
            Path target = root.resolve(filename);
            // 파일 올리기
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            // uploads/파일   경로
            return "uploads/" + filename;   
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }
}
