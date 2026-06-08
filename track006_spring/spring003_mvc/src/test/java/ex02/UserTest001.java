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
		
		// delete
		user.delete(10);
		
		// update
//		userDto.setUno(10);
//		userDto.setNickname("asdqwe");
//		userDto.setBpass("asdqwe");
//		userDto.setEmail("asd@qwe.com");
//		userDto.setMobile("000-4321-4321");
//		userDto.setBip(InetAddress.getLocalHost().getHostAddress());
//		user.update(userDto);

		
		// select
		System.out.println(user.select(1));
		
		// insert
//		userDto.setNickname("asdqwe");
//		userDto.setBpass("asdqwe");
//		userDto.setEmail("asd@qwe.com");
//		userDto.setMobile("000-1234-1234");
//		userDto.setBip(InetAddress.getLocalHost().getHostAddress());
//		user.insert(userDto);
		
		// selectAll
		System.out.println(user.selectAll());
	}
}
