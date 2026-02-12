package com.skynetidc.util;

import com.skynetidc.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

	public String usernameAuth() {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		return userDetails.getUserName();
	}

	public String nameAuth() {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		return String.join(" ", userDetails.getFirstName(), userDetails.getLastName());
	}

	public long userIdAuth() {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		return userDetails.getId();
	}

	public long clientIdAuth() {
		MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		return userDetails.getClientId();
	}

}
