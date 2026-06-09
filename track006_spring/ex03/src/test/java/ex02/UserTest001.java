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

import com.the703.dao.TestMapper;
import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")

public class UserTest001 {
	@Autowired ApplicationContext context;
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper test;
	@Autowired UserMapper user;
	
	@Ignore
	public void test1() {
		System.out.println(context);
		System.out.println(dataSource);
		System.out.println(sqlSession);
		System.out.println(test);
	}
	
	@Ignore
	public void test2() throws UnknownHostException {
		UserDto userDto = new UserDto();
		
		userDto.setNickname("bbb");
		userDto.setBpass("bbb");
		userDto.setEmail("bbb@bbb.com");
		userDto.setMobile("000-1111-2222");
		userDto.setBip("111.111.111.111");
		
		// 이메일 중복
		System.out.println(user.findByEmail("aaa@aaa.com"));
		
		// 마이페이지
//		System.out.println(user.findByUno(1));
		
		// 로그인
		
//		System.out.println(user.findLogin(userDto));
		
		// 회원가입
//		
//		System.out.println(user.insert(userDto));
	}
}
