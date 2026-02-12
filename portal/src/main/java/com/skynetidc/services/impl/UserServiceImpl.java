package com.skynetidc.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.skynetidc.client.WHMCS;
import com.skynetidc.client.payload.Payload;
import com.skynetidc.client.payload.a.AddClientPayload;
import com.skynetidc.client.payload.r.ResetPasswordPayload;
import com.skynetidc.services.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.skynetidc.dto.RegistrationRequest;
import com.skynetidc.model.Role;
import com.skynetidc.model.User;
import com.skynetidc.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final WHMCS whmcs;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, WHMCS whmcs) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.whmcs = whmcs;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User registerUser(RegistrationRequest registrationRequest) {

		var user = new User(registrationRequest.getFirstName(), registrationRequest.getLastName(),
				registrationRequest.getEmail(), passwordEncoder.encode(registrationRequest.getPassword()),
				List.of(new Role("ROLE_USER")));
		userRepository.save(user);

		return user;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("User not found with email:${email}"));

	}

	@Override
	@Modifying
	@Transactional
	public void signup(String firstname, String lastname, String email, String password) {
		try {
			Optional<User> userOptional = userRepository.findByEmail(email);
			if (userOptional.isEmpty()) {
				String country = "VN";
				String postCode = "100000";
				String phoneNumber = "0988888888";
				String address = "Hanoi";
				String city = "Hanoi";
				String state = "Hanoi";
				Payload clientPayload = new AddClientPayload(firstname, lastname, email, address, city, state, postCode,
						country, phoneNumber, password);
				JSONObject clientResult = whmcs.submitPayload(clientPayload);

				if (clientResult.get("result").toString().equals("success")) {
					// Get Password encrypt

					userRepository.updatePasswordByEmail(email, passwordEncoder.encode(password));
				}
				LOGGER.info("Create client with email {} is {}", email, clientResult.get("result").toString());
			}
		}
		catch (Exception e) {
			LOGGER.error("Error while signing up", e);
		}
	}

	@Override
	public void resetPassword(String email) {
		Payload payload = new ResetPasswordPayload().withEmail(email);
		try {
			whmcs.submitPayload(payload);
		}
		catch (IOException | InterruptedException e) {
			LOGGER.error("Error while reset password", e);
		}
	}

}
