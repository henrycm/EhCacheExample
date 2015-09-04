package com.jhcm.cacheSample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jhcm.cacheSample.backend.model.User;
import com.jhcm.cacheSample.backend.service.UserService;
import com.jhcm.cacheSample.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		UserService serv = (UserService) context.getBean("userService");
		User u = new User("hh", "henrycm@gmail.com");
		serv.save(u);

		log.debug("Result : {}", serv.getUserByEmail("henrycm@gmail.com"));		
		log.debug("Result : {}", serv.getUserByEmail("henrycm@gmail.com"));
		serv.save(u);
		log.debug("Result : {}", serv.getUserByEmail("henrycm@gmail.com"));
	}
}
