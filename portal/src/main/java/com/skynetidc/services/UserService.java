package com.skynetidc.services;

import com.skynetidc.dto.RegistrationRequest;
import com.skynetidc.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

	List<User> getAllUser();

	User registerUser(RegistrationRequest registerationRequest);

	User findByEmail(String email);

	void signup(String firstname, String lastname, String email, String paswword);

	void resetPassword(String email);

}
