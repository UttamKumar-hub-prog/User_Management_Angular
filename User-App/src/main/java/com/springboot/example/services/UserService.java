package com.springboot.example.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.example.entities.User;

public interface UserService {

	User save(User user);

	User getUserById(Long id);

	List<User> FindAllUsersInDataBase();

	Page<User> FindAllUserPage(Pageable pageable);

	void deleteUserById(Long id);

	User updateUserById(Long id, User user);

	User patchUpdateUserById(Long id, User user);
 

	List<User> getUserByName(String name);

	 

}
