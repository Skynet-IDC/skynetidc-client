package com.skynetidc.converter;

import com.skynetidc.model.User;
import com.skynetidc.model.UserModel;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;

public class UserConverter implements Converter<UserModel, User> {

	@Override
	public User convert(UserModel source) {
		User user = new User();
		user.setId(source.getId());
		user.setFirstName(source.getFirstName());
		user.setLastName(source.getLastName());
		user.setEmail(source.getEmail());
		user.setClientId(source.getClientId());
		user.setPassword(source.getPassword());
		user.setRoles(Collections.emptyList());
		return user;
	}

}
