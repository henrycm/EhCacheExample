package com.jhcm.cacheSample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jhcm.cacheSample.backend.model.User;
import com.jhcm.cacheSample.backend.repositories.UserRepository;

@Configuration
public class InitialDataConfig {

	private static final Logger log = LoggerFactory
			.getLogger(InitialDataConfig.class);

	@Bean
	public InitializingBean insertDefaultUsers() {
		return new InitializingBean() {
			@Autowired
			private UserRepository userRepository;

			public void afterPropertiesSet() {
				log.debug("Start massive load...");
				for (int i = 0; i < 100000; i++)
					addUser("User_" + i, "email@aa.com_" + i);
				log.debug("Finish massive load.");
			}

			private void addUser(String username, String email) {
				User user = new User();
				user.setName(username);
				user.setEmail(email);
				userRepository.save(user);
			}
		};
	}

}
