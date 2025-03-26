package com.skynetidc.services;

import com.skynetidc.dto.RegistrationRequest;
import com.skynetidc.model.User;

import java.util.List;

public interface UserServices {

	List<User> getAllUser();

	User registerUser(RegistrationRequest registerationRequest);

	User findByEmail(String email);

}
