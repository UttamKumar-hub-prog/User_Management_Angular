package com.springboot.example.controlller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.example.entities.User;
import com.springboot.example.services.UserService;

@WebMvcTest
//Loads only the given class (UserController) into the Spring test context.
@ContextConfiguration(classes = { UserController.class }) // Only load the controller
@Import(org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration.class)

class UserControllerTest {

	@Autowired // fake http request MockMvc
	private MockMvc mockMvc;

	@MockitoBean // fake object for UserService
	private UserService userService;

	@Test
	@Disabled
	void addUserTest() throws Exception {

		// our own user Object
		User user = new User(1L, "chandu", "chandu@gmail.com");
		// when ever some call for this userService.save i am simply returning this
		// user(object)
		Mockito.when(userService.save(Mockito.any())).thenReturn(user);

		mockMvc.perform(post("/addnewuser").contentType("application/json").content("""
				          {
				               "name":"chandu",
				               "email":"chandu@gmail.com"
				          }

				""")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("chandu"))
		.andExpect(status().isOk()).andExpect(jsonPath("$.email").value("chandu@gmail.com"));

	}
	
	@Test
	void getUserByIdTest() {
		
	}

}