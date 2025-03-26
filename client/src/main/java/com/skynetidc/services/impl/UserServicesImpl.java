package com.skynetidc.services.impl;

import com.skynetidc.dto.RegistrationRequest;
import com.skynetidc.model.Role;
import com.skynetidc.model.User;
import com.skynetidc.repository.UserRepository;
import com.skynetidc.services.UserServices;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User registerUser(RegistrationRequest registerationRequest) {

		var user = new User(registerationRequest.getFirstName(), registerationRequest.getLastName(),
				registerationRequest.getEmail(), passwordEncoder.encode(registerationRequest.getPassword()),
				Arrays.asList(new Role("ROLE_USER")));

		System.out.println(user);
		userRepository.save(user);

		return user;
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("User not found with email:${email}"));

	}

}
