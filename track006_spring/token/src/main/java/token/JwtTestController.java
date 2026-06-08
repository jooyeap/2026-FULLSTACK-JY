package token;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// html 화면을 보여주는게 아니라 단순히 데이터를 브라우저에 꽂아줌
@RestController
public class JwtTestController {
	private final JwtUtil jwtUtil;

	public JwtTestController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("/jwt-test")
	public String testJwt(@RequestParam String email) {
		return "";
	}
}
