package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.BoardDto;
import com.the703.dto.UserDto;
import com.the703.service.BoardServiceImpl;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // 1. spring 구동 테스트
//@ContextConfiguration(locations = "classpath:config/*-context.xml") // 2. 설정
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/security-context.xml" })

public class BoardTest001 {
	@Autowired ApplicationContext context; // 3. Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper testMapper;
	@Autowired BoardMapper board;
	//@Autowired BoardServiceImpl service; 
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Ignore
	public void test1() {
		System.out.println(context);
		System.out.println(dataSource);
		System.out.println(sqlSession);
		System.out.println(testMapper.now());
	}
	
	@Ignore
	public void test2() throws UnknownHostException {
		BoardDto boardDto = new BoardDto();
		
		// delete
//		board.delete(2);
		
		// update
//		boardDto.setBno(1);
//		boardDto.setBtitle("bbb");
//		boardDto.setBcontent("bbb");
//		board.update(boardDto);
		
		// select
		System.out.println(board.select(1));
		
		// insert
//		boardDto.setBname("aaa");
//		boardDto.setBpass("aaa");
//		boardDto.setBtitle("aaa");
//		boardDto.setBcontent("aaa");
//		boardDto.setBip(InetAddress.getLocalHost().getHostAddress());
//		board.insert(boardDto);
		
		// selectAll
		System.out.println(board.selectAll());
	}
	
	@Ignore
	public void test3() {
		
		// 삭제
//		BoardDto dto = new BoardDto();
//		dto.setBno(4);
//		System.out.println(service.delete(dto));
		
		// 수정
//		BoardDto dto = new BoardDto();
//		dto.setBno(4);
//		dto.setBname("ccc");
//		dto.setBpass("ccc");
//		dto.setBtitle("ddd");
//		dto.setBcontent("ddd");
//		System.out.println(service.edit(dto));
		
		// 상세보기, 수정폼 / 검색
//		System.out.println(service.detail(4));
//		System.out.println(service.editView(4));
		
		// 삽입
//		BoardDto dto = new BoardDto();
//		dto.setBname("ccc");
//		dto.setBpass("ccc");
//		dto.setBtitle("ccc");
//		dto.setBcontent("ccc");
//		System.out.println(service.insert(dto));
		
		// 전체 리스트
		//service.selectAll();
	}
	
	@Ignore
	public void test4() {
		// 전체 글 카운트
		System.out.println(board.selectCnt());
		// 최신글 10개씩
		HashMap<String,Integer> map = new HashMap<>();
		map.put("start", 0);
		map.put("end", 10);
		System.out.println(board.select10(map));
	}
	
	// security
	@Test
	public void test5() {
		// 회원가입 (암호화) pwencoder.encode("a")
		UserDto userDto = new UserDto();
		
		userDto.setNickname("b");
		userDto.setBpass(pwencoder.encode("b"));
		userDto.setEmail("b@b");
		userDto.setMobile("000-1111-2222");
		System.out.println(service.insert(userDto));
		
		// ROLE_MEMBER, ROLE_ADMIN / 권한 2개 회원, ADMIN
		AuthDto auth = new AuthDto();
		auth.setEmail("a@a");
//		auth.setAuth("ROLE_ADMIN");
//		auth.setAuth("ROLE_MEMBER");
//		System.out.println(user.insertAuth(auth));
		
		// 권한2개 줬으면 주석달고 위에 해당유저 정보 가져오기
//		System.out.println(user.readAuth(auth));
		
		
	}
}
