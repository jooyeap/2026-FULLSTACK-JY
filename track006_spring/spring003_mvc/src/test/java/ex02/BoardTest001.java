package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class) // 1. spring 구동 테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml") // 2. 설정

public class BoardTest001 {
	@Autowired ApplicationContext context; // 3. Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper testMapper;
	@Autowired BoardMapper board;
	
	@Ignore
	public void test1() {
		System.out.println(context);
		System.out.println(dataSource);
		System.out.println(sqlSession);
		System.out.println(testMapper.now());
	}
	
	@Test
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
}
