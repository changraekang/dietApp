package com.cos.dietApp.test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.dietApp.domain.user.User;
import com.cos.dietApp.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserControllerTest {
	
	private final UserRepository userRepository;
	
	@GetMapping("/test/user")
	public List<User> usertest() {
		String name = "name";
		List<User> user = userRepository.findByNameContaining(name);
		return user;
	}
	
}
