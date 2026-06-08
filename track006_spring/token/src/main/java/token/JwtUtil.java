package token;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final String secretString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!!!";
	private final Key secretKey = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));

	public String createToken(String email) {
		// 토큰에 유호기간을 주기 위한 준비작업
		long now = System.currentTimeMillis();
		long expirationTime = now + 1000 * 60 * 60;
		
		return Jwts.builder()									// 토큰 조립기
				.setSubject(email)								// 토큰의 주인(유저 이메일) 저장
				.setIssuedAt(new Date(now))						// 토큰 발행 시간
				.setExpiration(new Date(expirationTime))		// 토큰 만료 시간
				.signWith(secretKey, SignatureAlgorithm.HS256)	// 우리 비밀키와 암호화 알고리즘으로 서명
				.compact();										// 최종적으로 토큰(문자열) 발행
	}
	
	public String getEmailFromToken(String token) {
		try {
			// 우리가 만든 비밀키로 토큰을 복호화(파싱)
			// 복호화 -> 암호화되거나 인코딩된 데이터를 원래 읽을수있는 형태로 되돌리는것
			Claims claims = Jwts.parserBuilder()				// 토큰 해독기
							// 토큰 해독할수있는 열쇠를 줌, 위에서 암호화할때 잠근 키랑 같아야 열림
							.setSigningKey(secretKey)			
							.build()							// 조립 완료
							// 검증 시작 / 위에서 받은 secretKey랑 일치하는지, 위조검사 / 토큰 만료일 검사
							.parseClaimsJws(token)				
							.getBody(); 						// 검증이 완료되면 리턴, 이메일,만료시간등 
			
			// 복호화(파싱) 성공했다면 내부에 저장했던 Subject(이메일)를 반환
			return claims.getSubject();
		} catch (Exception e) {
			// 토큰이 만료되거나, 위조되거나, 형식이 잘못되면 예외가 발생
			return "유효하지 않은 토큰: " + e.getMessage();
		}
	}
}