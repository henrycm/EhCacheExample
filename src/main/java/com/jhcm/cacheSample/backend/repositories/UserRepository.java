package com.jhcm.cacheSample.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhcm.cacheSample.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
