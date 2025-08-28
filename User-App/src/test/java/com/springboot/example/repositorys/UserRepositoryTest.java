package com.springboot.example.repositorys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.example.entities.User;

@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
 
	@Test
	@DisplayName("Save method in repo layer")
	void testSaveUser() {
		User user = new User(null,"chandu", "chandu@gmail.com");
		User savedUser = userRepository.save(user);
		
		Assertions.assertNotNull(savedUser.getId());
	}
}
