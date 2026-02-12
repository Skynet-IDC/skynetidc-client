package com.skynetidc.repository;

import com.skynetidc.model.User;

import java.util.Optional;

public interface UserRepositoryCustom {

	Optional<User> loadByEmail(String email);

}
