package spring002_db_mysql;

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
import com.the703.dao.UserInfoMapper;
import com.the703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class) // 1. spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml") // 2. 설정파일

public class ModelTest001 {
	@Autowired ApplicationContext context; // 3. Bean (스프링이 관리하는 객체) 생성부터 소멸까지 관리
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper testMapper;
	@Autowired UserInfoMapper userInfo;
	
	//@Test public void test1() { System.out.println(context); }
	// @Ignore : 무시하기
	@Ignore public void test1() { System.out.println(context); } 
	@Ignore public void test2() { System.out.println(dataSource); }
	@Ignore public void test3() { System.out.println(sqlSession); }
	@Ignore public void test4() { System.out.println(testMapper.now()); }
	
	@Test
	public void test5() {
		UserInfoDto utest = new UserInfoDto();
		// 5. 삭제
		userInfo.delete(3);
		
		// 4. 수정
		utest.setNo(2);
		utest.setEmail("second");
		utest.setAge(22);
		userInfo.update(utest);
		
		// 3. 한명 검색
		System.out.println(userInfo.select(2));
		
		// 2. 삽입
//		UserInfoDto utest = new UserInfoDto();
//		utest.setEmail("bbb");
//		utest.setAge(2);
//		userInfo.insert(utest);
		
		// 1. 전체 검색
		System.out.println(userInfo.selectAll());
	}
	
	
	
}
