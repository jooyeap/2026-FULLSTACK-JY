package com.thejoa703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	// application.yml 에서 업로드된 경로 불러오기
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	// 이미지 리소스
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// /uploads 호출 경로
		registry.addResourceHandler("/uploads/**")
				// 실제 올리는 경로
				.addResourceLocations("file:" + uploadDir + "/");
	}
	
	// Cor - 외부에서 접근 가능하게 설정 (RestController)
//	@Override
//    public void addCorsMappings(CorsRegistry registry) { 
//        registry.addMapping("/**") // controller 모든경로
//                .allowedOrigins("http://localhost:3000")  // 프론트 엔드 주소 명확히
//                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 허용하는 메서드
//                .allowedHeaders("*")
//                .allowCredentials(true)  // 세션/쿠키연동하는 방법
//                .maxAge(3600);	// 1*60*60 1시간 캐시에 저장
//    }
}
