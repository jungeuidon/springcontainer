package config.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.itcen.springcontainer.user.User;

@Configuration
public class UserConfig02 {
	
	@Bean("ugg")
	public User user() {
		return new User();
	}
}
