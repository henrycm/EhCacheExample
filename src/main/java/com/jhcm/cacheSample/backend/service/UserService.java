package com.jhcm.cacheSample.backend.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jhcm.cacheSample.backend.model.User;
import com.jhcm.cacheSample.backend.repositories.UserRepository;

@Service
public class UserService {
	private static final Logger log = LoggerFactory
			.getLogger(UserService.class);

	@Resource
	private UserRepository urepo;

	@Cacheable(value = "userCache", key = "#email")
	public User getUserByEmail(String email) {
		log.debug("In service: getUserByEmail:{}", email);
		return urepo.findByEmail(email);
	}

	public User getUser(long id) {
		return urepo.findOne(id);
	}

	@CacheEvict(value = "userCache", key = "#user.email")
	public User save(User user) {
		return urepo.save(user);
	}

	public void delete(Long id) {
		urepo.delete(id);
	}
}
