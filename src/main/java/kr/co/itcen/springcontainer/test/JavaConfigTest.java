package kr.co.itcen.springcontainer.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.user.UserConfig01;
import kr.co.itcen.springcontainer.user.User;

public class JavaConfigTest {

	public static void main(String[] args) {
		testUser01();
	}

	// Explicit(명시적) Java Config
	public static void testUser01() {
		ApplicationContext appCntx = 
				new AnnotationConfigApplicationContext(UserConfig01.class);
		
		User user = appCntx.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)appCntx).close();
	}
}
