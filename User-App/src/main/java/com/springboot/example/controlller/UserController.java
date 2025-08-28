package com.springboot.example.controlller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.entities.User;
import com.springboot.example.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	
	@PostMapping("/addnewuser")
	public User addUser(@Valid @RequestBody User user) {
		return userService.save(user);
		
	}
	
	@GetMapping("/getUserByID/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAll(){
		return userService.FindAllUsersInDataBase();
	}
	@GetMapping("/getAllUserPage")
	public Page<User> getAllUserPage(Pageable pageable){ //{{baseURL}}/getAllUserPage?page=0&size=4&sort=name,desc
		return userService.FindAllUserPage(pageable);
	}
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		System.out.println("iam deleting so on so user");
		 
	}
	
	@PutMapping("/updateUserById/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
		
	}
	
	@PatchMapping("/patchUserById/{id}")
	public User patchUpdateUserById(@PathVariable Long id, @RequestBody User user) {
		return userService.patchUpdateUserById(id, user);
		
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name ) {
		return userService.getUserByName(name);
		
	}
	
}
