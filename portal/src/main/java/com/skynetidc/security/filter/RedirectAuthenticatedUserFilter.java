package com.skynetidc.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RedirectAuthenticatedUserFilter extends OncePerRequestFilter {

	private final String loginPageUrl;

	private final String homePageUrl;

	public RedirectAuthenticatedUserFilter(String loginPageUrl, String homePageUrl) {
		this.loginPageUrl = loginPageUrl;
		this.homePageUrl = homePageUrl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()
				&& !authentication.getPrincipal().equals("anonymousUser")) {
			if (request.getRequestURI().equals(loginPageUrl)) {
				response.sendRedirect(homePageUrl);
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

}
