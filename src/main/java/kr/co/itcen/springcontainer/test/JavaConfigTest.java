package kr.co.itcen.springcontainer.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import config.user.UserConfig01;
import kr.co.itcen.springcontainer.user.Friend;
import kr.co.itcen.springcontainer.user.User;

public class JavaConfigTest {

	public static void main(String[] args) {
		testUser01();
		testUser02();
	}

	// 1. Java Config Class를 명시한다. (Explicit Configuration)
	public static void testUser01() {
		ApplicationContext appCntx = 
				new AnnotationConfigApplicationContext(UserConfig01.class);
		
		User user = appCntx.getBean("user", User.class);  //UserConfig01.java에 @Bean이 달려있는 User가 user로 바꾸어 사용할 수 있다.
		System.out.println(user);
		
		Friend friend = appCntx.getBean("friend", Friend.class); //UserConfig01.java에 @Bean이 달려있는 Friend가 friend로 바꾸어 사용할 수 있다.
		System.out.println(friend);
		
		((ConfigurableApplicationContext)appCntx).close();
	}

	//2. 자동으로 Java Config Class를 Scan한다. (auto-scan)
	public static void testUser02() {
		ApplicationContext appCntx = 
				new AnnotationConfigApplicationContext("config.user");  //package 명으로도 쓸 수 있다 .
									//config.user 패키지를 스캔을 하는데.
		User user = appCntx.getBean("ugg", User.class);  // User를 가져올때 같은명일때에는  @Configuration을 붙은 것을 가져온다.
		System.out.println(user);						// 혹 User에 bean("아이디")를 설정할 경우 그 명으로 가져올 수 있다.
		
		((ConfigurableApplicationContext)appCntx).close();
	}
	
}
