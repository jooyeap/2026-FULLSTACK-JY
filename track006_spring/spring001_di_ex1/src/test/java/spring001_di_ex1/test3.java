package spring001_di_ex1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioc3.IceCreamShop;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans3.xml")

public class test3 {

	@Autowired ApplicationContext context;
	
	@Test
	public void test() {
		IceCreamShop ics = (IceCreamShop)context.getBean("iceCreamShop");
		ics.print();
	}
}
