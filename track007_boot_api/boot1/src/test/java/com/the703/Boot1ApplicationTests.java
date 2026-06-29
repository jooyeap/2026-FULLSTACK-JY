package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
	
	@Autowired TestDao dao;
	@Autowired Sboard2Dao sboard;
	@Autowired Sboard2Service service;
	
	
	@Disabled
	@Test
	public void test10_delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(41);
		
		assertEquals(1, service.delete(dto));
	}
	
	@Disabled
	@Test
	public void test09_update() {
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setId(41);
		dto.setBtitle("updatetest");
		dto.setBcontent("updatetest");
		dto.setBfile("updatetest.png");
		
		MockMultipartFile file = 
				new MockMultipartFile("file", "text.txt",
									  "text/plain", "data".getBytes());
		
		assertEquals(1, service.update(dto,file));
	}
	
	@Disabled
	@Test
	public void test08_byId() {
		// 41
		
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setId(41);
		
		Sboard2Dto result = service.detail(dto);
		
		assertNotNull(result);
		assertEquals(41, service.detail(dto).getId());
	}
	
	@Disabled
	@Test
	public void test07_paging() {

		List<Sboard2Dto> result = service.list10(0);

		// 예상되는 결과 , 해당 코드
		assertEquals(2, result.size());
		assertEquals(2, service.selectCnt());
	}
	
	@Disabled
	@Test
	public void test06_insert() throws UnknownHostException {
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setAppUserId(1001);
		dto.setBtitle("title");
		dto.setBcontent("bcontent");
		dto.setBpass("1111");
		dto.setBfile("1.png");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		MockMultipartFile file = 
				new MockMultipartFile("file", "text.txt",
									  "text/plain", "data".getBytes());
		
		assertEquals(1, service.insert(dto,file));
	}
	
	///////////////////////////////////////////////////////
	
	@Disabled
	@Test
	public void test05_delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(23);
		
		assertEquals(1, sboard.delete(dto));
	}
	
	@Disabled
	@Test
	public void test04_update() {
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setId(23);
		dto.setBtitle("updatetest");
		dto.setBcontent("updatetest");
		dto.setBfile("updatetest.png");
		
		assertEquals(1, sboard.update(dto));
		
		assertEquals(1, sboard.updateHit(dto));
	}
	
	@Disabled
	@Test
	public void test03_byId() {
		// 23
		
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setId(23);
		
		Sboard2Dto result = sboard.selectById(dto);
		
		assertNotNull(result);
	}
	
	@Disabled
	@Test
	public void test02_paging() {
		
		HashMap<String,Object> para = new HashMap<>();
		para.put("start", 0);
		para.put("end", 10);
		
		List<Sboard2Dto> result1 = sboard.selectPaging(para);
		
		// 예상되는 결과 , 해당 코드
		assertEquals(2, result1.size());
		assertNotNull(result1);
		
		assertEquals(2, sboard.selectCnt());
	}
	
	@Disabled
	@Test
	public void test01_Insert() throws UnknownHostException {
		
		Sboard2Dto dto = new Sboard2Dto();
		
		dto.setAppUserId(1001);
		dto.setBtitle("title");
		dto.setBcontent("bcontent");
		dto.setBpass("1111");
		dto.setBfile("1.png");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		int result = sboard.insert(dto);
		
		// 수동으로 값 확인 : 콘솔에 1이 나오는지 직접 확인
		System.out.println("..........1 > " + result); 
		
		// 자동으로 값 확인 : 결과물이 1인지 junit이 체크
		assertEquals(1, result);
	}
	
	// @Ignore JUnit4 버전
	@Disabled @Test
	void contextLoads() {
//		System.out.println("ㅇㅅㅇ");
//		System.out.println(dao.readTime());
		
	}

}
