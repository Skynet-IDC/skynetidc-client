package com.skynetidc.security;

import com.skynetidc.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServices implements UserDetailsService {

	private final UserRepository userRepository;

	public MyUserDetailsServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
			.map(MyUserDetails::new)
			.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + username));
	}

}
