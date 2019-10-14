package config.user;

import org.springframework.context.annotation.Bean;

import kr.co.itcen.springcontainer.user.User;

public class UserConfig01 {
	@Bean
	public User user() {
		return new User();
	}
}
