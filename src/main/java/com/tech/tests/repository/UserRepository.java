package com.tech.tests.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.tests.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findByUsernameOrEmail(String username, String email);
	Optional<User> findById(Long userId);
	
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);

}
