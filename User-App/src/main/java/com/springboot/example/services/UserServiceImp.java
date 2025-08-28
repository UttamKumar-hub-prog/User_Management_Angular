package com.springboot.example.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.example.entities.User;
import com.springboot.example.repositorys.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

	private final UserRepository userRepository;

	@Override
	public User save(User user) {

		return userRepository.save(user); // save 0ne parameter
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id).get();
	}

	@Override
	public List<User> FindAllUsersInDataBase() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> FindAllUserPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUserById(Long id, User user) {
		User existedUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("user with that id is not present" + id));

		existedUser.setName(user.getName());
		existedUser.setEmail(user.getEmail());

		return userRepository.save(existedUser);

	}

	@Override
	public User patchUpdateUserById(Long id, User user) {
		User existedUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("user with that id is not present" + id));

		if (user.getName() != null) {
			existedUser.setName(user.getName());
		} else if (user.getEmail() != null) {
			existedUser.setEmail(user.getEmail());
		}

		return userRepository.save(existedUser);

	}

	@Override
	public List<User> getUserByName(String name ) {
		return userRepository.getUserByNameIgnoreCase(name);
	}

}
