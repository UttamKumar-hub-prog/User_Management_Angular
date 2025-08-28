package com.springboot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.example.entities.User;
import com.springboot.example.repositorys.UserRepository;

@SpringBootApplication
public class UserAppApplication implements ApplicationRunner {

	@Autowired
	private UserRepository userrepository;

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User(null,"uttam","uttam@gmail.com");
		userrepository.save(user);
		User user1 = new User(null,"chandu","chandu@gmail.com");
		userrepository.save(user1);
		User user2 = new User(null,"reddy","reddy@gmail.com");
		userrepository.save(user2);
		User user3 = new User(null,"narra","narra@gmail.com");
		userrepository.save(user3);
	}

}
