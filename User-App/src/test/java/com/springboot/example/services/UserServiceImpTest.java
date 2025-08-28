package com.springboot.example.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.example.entities.User;
import com.springboot.example.repositorys.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImp userServiceimpl;

	@DisplayName("we were testing saveUserTest in service layer")
	@Test
	void saveUserTest() {

		// our own user object
		// controller to service
		User actualObject = new User(null, "chandu", "chandu@gmail.com");

		// our own user object
		// returning from repository to service
		User saveUserinDB = new User(72L, "chandu", "chandu@gmail.com");

		Mockito.when(userRepository.save(actualObject)).thenReturn(saveUserinDB);

		User finalResult = userServiceimpl.save(actualObject);
		// condition 1
		Assertions.assertEquals(72L, finalResult.getId());
		// condition2
		Assertions.assertEquals("chandu", finalResult.getName());
		// condition3
		Assertions.assertEquals("chandu@gmail.com", finalResult.getEmail());
	}

}
