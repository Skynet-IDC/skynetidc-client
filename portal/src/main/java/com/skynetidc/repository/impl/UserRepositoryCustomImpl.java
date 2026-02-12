package com.skynetidc.repository.impl;

import com.skynetidc.model.User;
import com.skynetidc.model.UserModel;
import com.skynetidc.repository.UserRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Optional;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<User> loadByEmail(String email) {
		String sql = "SELECT t.id, t.email, t.first_name, t.last_name, t.password, tc.client_id FROM tblusers AS t "
				+ "INNER JOIN tblusers_clients tc ON tc.auth_user_id = t.id " + "WHERE t.email = :email";
		Query query = em.createNativeQuery(sql, UserModel.class);
		query.setParameter("email", email);
		UserModel user = (UserModel) query.getSingleResult();
		return Optional.of(user.convertToUser());
	}

}
