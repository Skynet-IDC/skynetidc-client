package com.skynetidc.repository;

import com.skynetidc.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long>, UserRepositoryCustom {

	Optional<User> findByEmail(String email);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tblusers SET password=:password WHERE email=:email")
	void updatePasswordByEmail(String email, String password);

}
